package json_demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

public class WithGsonJackson {
	public static void main(String[] args) throws Exception{
		Employee e = new Employee(1, "AAAA", "01/16/2021");
//		Employee stu = new Employee();
//		stu.setEid(2);
//		stu.setEname("arjun");
//		stu.setEdoj("01/17/2021");
//		ObjectMapper mapper = new ObjectMapper();
//		String json = mapper.writeValueAsString(stu);
		Gson g = new Gson();
		String s = g.toJson(e);
		System.out.println(s);
//		System.out.println(json);
	}
}
