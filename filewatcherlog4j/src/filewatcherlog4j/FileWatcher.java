package filewatcherlog4j;
import java.io.*;
import java.nio.file.*;
import java.nio.file.WatchEvent.*;
import java.util.*;
import java.util.Date;
import java.sql.*;

import org.apache.log4j.*;
public class FileWatcher {

	public static void main(String[] args) throws Exception{
		final Logger log=Logger.getLogger(FileWatcher.class.getName());
		WatchService watchService = FileSystems.getDefault().newWatchService();
		Path p = Paths.get("D:/Hemanth");
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/filewatcher", "root", "root");
		String sql_insert="insert into filewatcher values(null,?,?,?)";
		PreparedStatement s=con.prepareStatement(sql_insert);
		p.register(watchService, StandardWatchEventKinds.ENTRY_CREATE,
					StandardWatchEventKinds.ENTRY_DELETE,
					StandardWatchEventKinds.ENTRY_MODIFY);
		boolean poll = true;
		System.out.println("Checking Changes.....");
		while (poll) {
			WatchKey key = watchService.take();
			for (WatchEvent<?> event : key.pollEvents()) {
				BasicConfigurator.configure();
				log.info("Event kind : " + event.kind() + " - File : " + event.context());
				Kind<?> k=null;
				k=event.kind();
				if("ENTRY_MODIFY"==k.name()) {
					Object name=event.context();
					String n=String.valueOf(name);
					System.out.println("Modified File "+event.context());
					File file=new File("D:/Hemanth/"+name);
					FileReader fr=new FileReader(file);
					BufferedReader bf =new BufferedReader(fr);
					String file_content = "";
					String line=null;
					s.setString(2, n);
					while((line=bf.readLine())!=null) {
						log.debug(line);
						file_content += line;
					}
					Date date= new Date();
					long time = date.getTime();
					Timestamp ts = new Timestamp(time);
					Object tr=ts;
					String ss=String.valueOf(tr);
					s.setString(1,ss );
					s.setString(3,file_content);
					int j=s.executeUpdate();
				}
				if("ENTRY_CREATE"==k.name()) {
					Object name=event.context();
					String n=String.valueOf(name);
					System.out.println("Created File "+event.context());
					File file=new File("D:/Hemanth/"+name);
//					FileReader fr=new FileReader(file);
//					BufferedReader bf =new BufferedReader(fr);
//					String file_content = "";
//					String line=null;
					s.setString(2, n);
//					while((line=bf.readLine())!=null) {
//						log.debug(line);
//						file_content += line;
//					}
					Date date= new Date();
					long time = date.getTime();
					Timestamp ts = new Timestamp(time);
					Object tr=ts;
					String ss=String.valueOf(tr);
					s.setString(1,ss );
					s.setString(3,"D:/Hemanth/"+name);
					int j=s.executeUpdate();
				}
			}poll = key.reset();
		}
}
}
