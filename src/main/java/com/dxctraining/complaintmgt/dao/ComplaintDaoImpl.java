package com.dxctraining.complaintmgt.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
//import javax.persistence.TypedQuery;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.dxctraining.complaintmgt.entities.Complaint;



@Repository
public class ComplaintDaoImpl implements ComplaintDao{
	
	@PersistenceContext
	EntityManager em;
	
	public Complaint addComplaint(Complaint complaint) {
		em.persist(complaint);
		return complaint;	
	}
	public Complaint findById(int id) {
		Complaint complaint=em.find(Complaint.class, id);
		return complaint;
	}
	public List<Complaint> findAll(int consumerid) {
		String q="from Complaint where consumerid=:consumer";
		TypedQuery<Complaint>query=em.createQuery(q,Complaint.class);
		query.setParameter("consumer", consumerid);
		List<Complaint>complaintList=query.getResultList();
		return complaintList;
	}


}
