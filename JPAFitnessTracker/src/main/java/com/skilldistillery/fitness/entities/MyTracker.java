package com.skilldistillery.fitness.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Temporal;

@Entity

public class MyTracker {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Temporal(value = null)
	@JoinColumn(name="date_start")
	private LocalDateTime startDate;
	
	@Temporal(value = null)
	@JoinColumn(name="date_end")
	private LocalDateTime endDate;
	
	@JoinColumn(name="workout_types")
	private String workoutTypes;
	
	private String location;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MyTracker [id=").append(id).append(", startDate=").append(startDate).append(", endDate=")
				.append(endDate).append(", workoutTypes=").append(workoutTypes).append(", location=").append(location)
				.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + id;
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
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
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (id != other.id)
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (workoutTypes == null) {
			if (other.workoutTypes != null)
				return false;
		} else if (!workoutTypes.equals(other.workoutTypes))
			return false;
		return true;
	}
	
	
}
