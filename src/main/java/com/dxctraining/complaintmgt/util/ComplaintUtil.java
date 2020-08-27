package com.dxctraining.complaintmgt.util;

import org.springframework.stereotype.Component;

import com.dxctraining.complaintmgt.dto.ComplaintDto;
import com.dxctraining.complaintmgt.entities.Complaint;
@Component
public class ComplaintUtil {
	public ComplaintDto complaintDto(Complaint complaint, int consumerid, String consumername) { 
			ComplaintDto dto=new ComplaintDto(complaint.getId(),complaint.getDesc()); 
	 		dto.setConsumerid(consumerid);
	 		dto.setConsumername(consumername); 
	 		return dto; 
	}


}
