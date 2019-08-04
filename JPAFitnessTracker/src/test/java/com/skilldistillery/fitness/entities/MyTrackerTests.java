package com.skilldistillery.fitness.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MyTrackerTests {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private MyTracker mt;
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception{
		emf = Persistence.createEntityManagerFactory("FitnessTracker");
	}
	
	@AfterAll
	static void tearDownAfterClass() throws Exception{
		emf.close();
	}
	
	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		mt = em.find(MyTracker.class, 1);
	}
	
	@AfterEach
	void tearDown() throws Exception{
		em.close();
		mt = null;
	}
	
	@Test
	@DisplayName("Initial Mappings")
	void test_connection() {
		assertNotNull(mt);
		assertEquals(1, mt.getId());
	}
	
	@Test
	@DisplayName("Data from DB being pulled")
	void test_for_actual_data() {
		assertEquals("24-hr Fitness", mt.getLocation());
		assertEquals("Stationary Bike", mt.getWorkoutTypes());
		assertEquals("Quick bike ride at the Gym.", mt.getComment());
		assertEquals("2019-08-02 11:00:00.0", mt.getDateStart().toString());
		assertEquals("2019-08-02 11:30:00.0", mt.getDateEnd().toString());
	}
}
