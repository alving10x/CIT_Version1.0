package com.projects.CIT_Version1_0.model;

import java.util.Date;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "incident")
public class Incident {

    @Id
	private Long incidentId;

    private Boolean active;
    private String state;
    private String priority;
    private String assignedTo;
    private String assignedGroup;
    private Date resolvedDate;
    private Date dueDate;
    private String description;
    private Set<String> tags;
    private String openedBy;
    private String SLA;
    private String SLALapse;
	
    public Long getIncidentId() {
		return incidentId;
	}
	public void setIncidentId(Long incidentId) {
		this.incidentId = incidentId;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getAssignedTo() {
		return assignedTo;
	}
	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}
	public String getAssignedGroup() {
		return assignedGroup;
	}
	public void setAssignedGroup(String assignedGroup) {
		this.assignedGroup = assignedGroup;
	}
	public Date getResolvedDate() {
		return resolvedDate;
	}
	public void setResolvedDate(Date resolvedDate) {
		this.resolvedDate = resolvedDate;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Set<String> getTags() {
		return tags;
	}

	public void setTags(Set<String> tags) {
	this.tags = tags;
	}
//	public String[] getTags() {
//		return tags;
//	}
//	public void setTags(String[] tags) {
//		this.tags = tags;
//	}
	public String getOpenedBy() {
		return openedBy;
	}
	public void setOpenedBy(String openedBy) {
		this.openedBy = openedBy;
	}
	public String getSLA() {
		return SLA;
	}
	public void setSLA(String sLA) {
		SLA = sLA;
	}
	public String getSLALapse() {
		return SLALapse;
	}
	public void setSLALapse(String sLALapse) {
		SLALapse = sLALapse;
	}

	@Override
	public String toString() {
		return "Incident{" +
				"incidentId='" + incidentId + '\'' +
				", active=" + active +
				", state='" + state + '\'' +
				", priority='" + priority + '\'' +
				", assignedTo='" + assignedTo + '\'' +
				", assignedGroup='" + assignedGroup + '\'' +
				", resolvedDate=" + resolvedDate +
				", dueDate=" + dueDate +
				", description='" + description + '\'' +
				", tags=" + tags +
				", openedBy='" + openedBy + '\'' +
				", SLA='" + SLA + '\'' +
				", SLALapse='" + SLALapse + '\'' +
				'}';
	}
}