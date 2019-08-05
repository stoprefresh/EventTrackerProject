package com.skilldistillery.fitness.services;

import java.util.List;

import com.skilldistillery.fitness.entities.MyTracker;

public interface MyTrackerService {

	List<MyTracker> allEntries();
	
	List<MyTracker> entriesByKeyword(String keyword);

	MyTracker entryById(int eid);
	
	MyTracker create(MyTracker newEntry);
	
	MyTracker update(int eid, MyTracker updateEntry);
	
	Boolean delete(int eid);
	
}
