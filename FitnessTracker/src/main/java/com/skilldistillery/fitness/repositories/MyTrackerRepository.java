package com.skilldistillery.fitness.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.fitness.entities.MyTracker;

public interface MyTrackerRepository extends JpaRepository<MyTracker, Integer >{

	
	List<MyTracker> findByCommentLikeOrWorkoutTypesLike(String kw1, String kw2);
}
