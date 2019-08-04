package com.skilldistillery.fitness.entities;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class MyTracker {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_start")
	@CreationTimestamp
	private Date dateStart;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_end")
	@CreationTimestamp
	private Date dateEnd;
	
	@Column(name="workout_types")
	private String workoutTypes;
	
	private String location;
	
	private String comment;
	
//	Constructor Start
	public MyTracker () {}
//	Constructor End
	
//	Getters - Setters Start
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateStart() {
		return dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	public Date getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	public String getWorkoutTypes() {
		return workoutTypes;
	}

	public void setWorkoutTypes(String workoutTypes) {
		this.workoutTypes = workoutTypes;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
//	Getters - Setters End
	
//	To String Start
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MyTracker [id=").append(id).append(", startDate=").append(dateStart).append(", endDate=")
				.append(dateEnd).append(", workoutTypes=").append(workoutTypes).append(", location=").append(location)
				.append("]");
		return builder.toString();
	}
//	To String End

//	Hash Code and Equals Start	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + ((dateEnd == null) ? 0 : dateEnd.hashCode());
		result = prime * result + ((dateStart == null) ? 0 : dateStart.hashCode());
		result = prime * result + id;
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((workoutTypes == null) ? 0 : workoutTypes.hashCode());
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
		MyTracker other = (MyTracker) obj;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (dateEnd == null) {
			if (other.dateEnd != null)
				return false;
		} else if (!dateEnd.equals(other.dateEnd))
			return false;
		if (dateStart == null) {
			if (other.dateStart != null)
				return false;
		} else if (!dateStart.equals(other.dateStart))
			return false;
		if (id != other.id)
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (workoutTypes == null) {
			if (other.workoutTypes != null)
				return false;
		} else if (!workoutTypes.equals(other.workoutTypes))
			return false;
		return true;
	}
//	Hash Code and Equals End		
}
