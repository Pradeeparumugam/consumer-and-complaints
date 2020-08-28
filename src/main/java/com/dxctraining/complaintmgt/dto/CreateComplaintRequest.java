package com.dxctraining.complaintmgt.dto;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class CreateComplaintRequest {
	@NotBlank
	private String desc;
	@NotNull
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
