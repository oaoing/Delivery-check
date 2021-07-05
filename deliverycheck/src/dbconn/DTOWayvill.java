package dbconn;

public class DTOWayvill {
	private String wayvill;
	private String code;
	private String company;
	private String memo;
	
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	
	public DTOWayvill(String wayvill, String code, String company, String memo) {
		this.wayvill = (wayvill==null)?"":wayvill;
		this.code = (code==null)?"":code;
		this.company = (company==null)?"":company;
		this.memo = (memo==null)?"":memo;
	}

	public String getWayvill() {
		return wayvill;
	}

	public void setWayvill(String wayvill) {
		this.wayvill = wayvill;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
	
}
