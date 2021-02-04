package json_demo;

public class Employee {
	private int eid;
	private String ename;
	private String edoj;
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEdoj() {
		return edoj;
	}
	public void setEdoj(String edoj) {
		this.edoj = edoj;
	}
	public Employee(int eid, String ename, String edoj) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.edoj = edoj;
	}
	public Employee() {
		super();
	}
	@Override
	public String toString() {
		return "EmployeePojo [eid=" + eid + ", ename=" + ename + ", edoj=" + edoj + ", getEid()=" + getEid()
				+ ", getEname()=" + getEname() + ", getEdoj()=" + getEdoj() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
}
