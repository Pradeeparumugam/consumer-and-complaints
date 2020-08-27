package com.dxctraining.complaintmgt.dto;

public class ComplaintDto {
	private int id;
	private String desc;
	private int consumerid;
	private String consumername;
	
	public ComplaintDto(int id, String desc) {
		this.id=id;
		this.desc=desc;
	}
	public ComplaintDto() {
		
	}

	public int getConsumerid() {
		return consumerid;
	}

	public void setConsumerid(int consumerid) {
		this.consumerid = consumerid;
	}

	public String getConsumername() {
		return consumername;
	}

	public void setConsumername(String consumername) {
		this.consumername = consumername;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ComplaintDto other = (ComplaintDto) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
