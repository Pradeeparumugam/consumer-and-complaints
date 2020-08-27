package com.dxctraining.complaintmgt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dxctraining.complaintmgt.dto.ComplaintDto;
import com.dxctraining.complaintmgt.dto.CreateComplaintRequest;
import com.dxctraining.complaintmgt.entities.Complaint;
import com.dxctraining.complaintmgt.service.ComplaintService;


@RestController
@RequestMapping("/complaint")
public class ComplaintRestController {
	@Autowired
	private ComplaintService service;
	
	
	@PostMapping("/addcomplaint")
	@ResponseStatus(HttpStatus.OK)
	public ComplaintDto create(@RequestBody CreateComplaintRequest req) {
		int id=req.getId();
		String desc=req.getDesc();
		Complaint complaint=new Complaint(id,desc);
		complaint=service.addComplaint(complaint);
		ComplaintDto dto=complaintdto(complaint);
		return dto;
		
	}
	@GetMapping("/findbyid/{id}")
	public ComplaintDto find(@PathVariable("id") int id ){
		Complaint c=service.findById(id);
		ComplaintDto dto=complaintdto(c);
		return dto;
		
	}
	public ComplaintDto complaintdto(Complaint c) {
		ComplaintDto cdto=new ComplaintDto();
		cdto.setId(c.getId());
		cdto.setDesc(c.getDesc());
		return cdto;
	}

}
