package com.dxctraining.complaintmgt.service;



import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxctraining.complaintmgt.dao.ComplaintDao;
import com.dxctraining.complaintmgt.entities.Complaint;
import com.dxctraining.complaintmgt.exception.NotValidException;

@Transactional
@Service
public class ComplaintServiceImpl implements ComplaintService{
	
	@Autowired 
	private ComplaintDao dao;
	
	public Complaint addComplaint(Complaint complaint) {
		verify(complaint);
		 complaint=dao.addComplaint(complaint);
		return complaint;
	}
	public Complaint findById(int id) {
		verify(id);
		Complaint complaint=dao.findById(id);
		return complaint;
	}
	public List<Complaint> findAll(int consumerid){
		verify(consumerid);
		List<Complaint> complaints=dao.findAll(consumerid);
		return complaints;
	}
	
	public void verify(Object ob) {
		if(ob==null) {
			throw new NotValidException("not valid");
		}
	}

}
