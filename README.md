## Event Tracker Project

Spring REST/JavaScript/Angular homework for Skill Distillery Week 13-15

## Overview

The WEB application will leverage Spring boot with a RESTful API to allow myself to be able have a basic log for tracking workouts. In its current form, it will track the start time and stop time, what types of workouts completed, some comments, and where the workout was done. It is my hope to be able to expand this into something more viable, so the DB tables have been setup with that in mind.

Currently the backend connections from the DB to the web connections have been setup and tested. Data for the DB will continue to be populated throughout the week as I add actual data to the tables.

Vers.0.1 is deployed to AWS and will be prepped in the following week for front-end integration.

Later iterations will have more data points for tracking to gauge progress and track deficiencies.

* http://marsigliamiguel.com:8080/FitnessTracker/api/ping 


## REST API endpoints

| Request Type | api | Description |
|--------------|--------------|--------------|
| GET | api/entries/all | Find All Entries |
| GET | api/entries/search/{keyword} | Find Entries by Comments or Workout Type |
| GET | api/entry/{id} | Find Entry by ID |
| POST | api/entries | Add a new Entry |
| PUT | api/entry/{id} | Update an Entry by ID|
| DELETE | api/entry/{id} | Remove an Entry by ID |


### Tech Used
- GIT
- Spring
- REST API
- Java
- MySQL
- AWS
- more to be added....

### Lessons Learned
-Ensure DB is labeled correctly, so that Spring knows the correct one.
