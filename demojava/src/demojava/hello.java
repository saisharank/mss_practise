package demojava;

import java.sql.Timestamp;
import java.util.Date;

public class hello {

	public static void main(String[] args) {
		Date date= new Date();
		long time = date.getTime();
		Timestamp ts = new Timestamp(time);
		Object tr=ts;
		String ss=String.valueOf(tr);
		System.out.println(ss.getClass().getName());
		System.out.println(ss);

	}

}
