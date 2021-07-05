package dbconn;

public class DTOCompany {
	private String code;
	private String name;
	
	public DTOCompany(String code, String name) {
		this.code = (code==null)?"":code;
		this.name = (name==null)?"":name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
