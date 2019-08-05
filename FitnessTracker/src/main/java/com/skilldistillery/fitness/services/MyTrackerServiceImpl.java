package com.skilldistillery.fitness.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.fitness.entities.MyTracker;
import com.skilldistillery.fitness.repositories.MyTrackerRepository;

@Service
public class MyTrackerServiceImpl implements MyTrackerService {

	@Autowired
	private MyTrackerRepository repo;

	@Override
	public List<MyTracker> allEntries() {
		return repo.findAll();
	}

	@Override
	public MyTracker entryById(int eid) {
		Optional<MyTracker> entry = repo.findById(eid);
		if (entry.isPresent()) {
			return entry.get();
		}
		return null;
	}
	
	@Override
	public List<MyTracker> entriesByKeyword(String keyword) {
		keyword = "%" + keyword + "%";
		return repo.findByCommentLikeOrWorkoutTypesLike(keyword, keyword);
	}
	
	@Override
	public MyTracker create(MyTracker newEntry) {
		return repo.saveAndFlush(newEntry);
	}
	
	@Override
	public MyTracker update(int eid, MyTracker updatedEntry) {
		Optional<MyTracker> opt = repo.findById(eid);
		MyTracker managedEntry = null;
		
		if(opt.isPresent()) {
			managedEntry = opt.get();
			managedEntry.setDateStart(updatedEntry.getDateStart());
			managedEntry.setDateEnd(updatedEntry.getDateEnd());
			managedEntry.setComment(updatedEntry.getComment());
			managedEntry.setLocation(updatedEntry.getLocation());
			managedEntry.setWorkoutTypes(updatedEntry.getWorkoutTypes());
			repo.saveAndFlush(managedEntry);
		}
		
		return managedEntry;
	}

	@Override
	public Boolean delete(int eid) {
		
		Boolean deleted = false;
		try {
			repo.deleteById(eid);
			deleted = true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return deleted;
	}
}
