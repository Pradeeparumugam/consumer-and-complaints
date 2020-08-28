package com.dxctraining.complaintmgt.controller;

import java.util.ArrayList;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.dxctraining.complaintmgt.dto.ComplaintDto;
import com.dxctraining.complaintmgt.dto.ConsumerDto;
import com.dxctraining.complaintmgt.dto.CreateComplaintRequest;
import com.dxctraining.complaintmgt.entities.Complaint;
import com.dxctraining.complaintmgt.service.ComplaintService;
import com.dxctraining.complaintmgt.util.ComplaintUtil;
@Validated
@RestController
@RequestMapping("/complaints")
public class ComplaintRestController {
	@Autowired
	private ComplaintService service;

	@Autowired
	private ComplaintUtil util;

	@Autowired
	private RestTemplate restTemplate;

	@PostMapping("/addcomplaint")
	@ResponseStatus(HttpStatus.OK)
	public ComplaintDto create(@Valid @NotNull @RequestBody CreateComplaintRequest req) {
		@NotBlank
		String desc = req.getDesc();
		@NotNull
		int consumerid = req.getConsumerid();
		
		Complaint complaint = new Complaint( desc, consumerid);
		complaint = service.addComplaint(complaint);
		ConsumerDto consumerDto = fetchConsumerById(consumerid);
		ComplaintDto dto = util.complaintDto(complaint,consumerid,consumerDto.getName());
		return dto;

	}

	@GetMapping("/findbyid/{id}")
	public ComplaintDto find(@NotNull  @PathVariable("id") int id) {
		Complaint c = service.findById(id);
		int consumerid = c.getConsumerid();
		ConsumerDto consumerDto = fetchConsumerById(consumerid);
		ComplaintDto dto = util.complaintDto(c,consumerid,consumerDto.getName());
		return dto;

	}

	@GetMapping("/consumer/{consumerid}")
	public List<ComplaintDto> fetchComplaints(@NotNull @Min(5)@PathVariable("consumerid") int consumerid) {
		List<Complaint> list = service.findAll(consumerid);
		List<ComplaintDto> response = new ArrayList<>();
		ConsumerDto consumerDto = fetchConsumerById(consumerid);
		for (Complaint complaint : list) {
			ComplaintDto dto = util.complaintDto(complaint, consumerid, consumerDto.getName());
			response.add(dto);
		}
		return response;
	}

	public ComplaintDto complaintdto(Complaint c) {
		ComplaintDto cdto = new ComplaintDto();
		cdto.setId(c.getId());
		cdto.setDesc(c.getDesc());
		return cdto;
	}
	public ConsumerDto fetchConsumerById(int consumerid) {
		String url = "http://localhost:8585/consumer/getconsumer/" + consumerid;
		ConsumerDto dto = restTemplate.getForObject(url, ConsumerDto.class);
		return dto;
	}

}
