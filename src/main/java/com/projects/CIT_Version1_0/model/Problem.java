package com.projects.CIT_Version1_0.model;


import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "problem")
public class Problem {
    
	
    private String problemId;
    private String knownErrorId;
    private String status;
    private String description;
    private String urgency;
    private String impact[];
    private String associatedService[];
    private Date createdOn;
	public String getProblemId() {
		return problemId;
	}
	public void setProblemId(String problemId) {
		this.problemId = problemId;
	}
	public String getKnownErrorId() {
		return knownErrorId;
	}
	public void setKnownErrorId(String knownErrorId) {
		this.knownErrorId = knownErrorId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUrgency() {
		return urgency;
	}
	public void setUrgency(String urgency) {
		this.urgency = urgency;
	}
	public String[] getImpact() {
		return impact;
	}
	public void setImpact(String[] impact) {
		this.impact = impact;
	}
	public String[] getAssociatedService() {
		return associatedService;
	}
	public void setAssociatedService(String[] associatedService) {
		this.associatedService = associatedService;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	
}