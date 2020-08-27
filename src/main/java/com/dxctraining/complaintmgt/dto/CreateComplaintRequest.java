package com.dxctraining.complaintmgt.dto;

public class CreateComplaintRequest {
	
	private String desc;
	private int consumerid;
	
	public int getConsumerid() {
		return consumerid;
	}
	public void setConsumerid(int consumerid) {
		this.consumerid = consumerid;
	}
		public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	

}
