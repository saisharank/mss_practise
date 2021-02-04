package json_demo;

import com.google.gson.Gson;

public class WithGson {
	public static void main(String[] args) throws Exception{
		Employee e = new Employee(1, "AAAA", "01/16/2021");
		Gson g = new Gson();
		String s = g.toJson(e);
		System.out.println(s);
	}
}
