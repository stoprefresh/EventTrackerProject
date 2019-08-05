package com.skilldistillery.fitness.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.fitness.entities.MyTracker;
import com.skilldistillery.fitness.services.MyTrackerService;

@RestController
@RequestMapping("api")
public class MyTrackerController {
	
		@Autowired
		private MyTrackerService svc;
		
		//TODO - finish build out http resposnses.
		@GetMapping("ping")
		public String ping() {
			return "pong";
		}
		
		@GetMapping("entries/all")
		public List<MyTracker> index(){
			return svc.allEntries();
		}
		
		@GetMapping("entries/search/{keyword}")
		public List<MyTracker> findEntriesByKeyword(
			@PathVariable("keyword") String keyword){
			return svc.entriesByKeyword(keyword);
		}

		@GetMapping("entry/{id}")
		public MyTracker findEntryById(
				@PathVariable("id") Integer eid){
			return svc.entryById(eid);
		}
		
		@PostMapping("entries")
		public MyTracker addNewEntry(
				@RequestBody MyTracker newEntry,
				HttpServletRequest req, HttpServletResponse resp) {
					newEntry = svc.create(newEntry);
					resp.setStatus(201);
					StringBuffer sb = req.getRequestURL();
					sb.append("/");
					sb.append(newEntry.getId());
					resp.setHeader("Location", sb.toString());
					return newEntry;
		}

		@PutMapping("entry/{id}")
		public MyTracker updateEntryById(
				@RequestBody MyTracker updatedEntry, @PathVariable("id") Integer eid,
				HttpServletResponse resp) {
					return svc.update(eid, updatedEntry);
		}
		
		@DeleteMapping("entry/{id}")
		public Boolean deleteEntry(@PathVariable("id") Integer eid,
				HttpServletResponse resp) {
			
			Boolean deleted = svc.delete(eid);
			if(deleted == null) {
				resp.setStatus(404);
			}
			else if(deleted) {
				resp.setStatus(204);
			}
			else {
				resp.setStatus(400);
			}
			return deleted;
		}	
}
