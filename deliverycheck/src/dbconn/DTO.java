package dbconn;

public class DTO {
	private int wayvill;
	private String company;
	private String memo;
	
	public DTO(int wayvill, String company, String memo) {
		this.wayvill = wayvill;
		this.company = (company==null)?"":company;
		this.memo = (memo==null)?"":memo;
	}

	public int getWayvill() {
		return wayvill;
	}

	public void setWayvill(int wayvill) {
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
