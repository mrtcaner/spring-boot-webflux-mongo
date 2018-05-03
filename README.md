# spring-boot-webflux-mongo

## build
* Run application and some recors will be inserted to db. ID's of records will be printed to console.
* type http://localhost:8080/movies/<a movie ID>/event browser and you should see something like "data:{"id":"611e4770-9955-4a8d-a405-eb657a858ad0","date":"2018-05-03T07:24:40.985+0000"}"  
	example http://localhost:8080/movies/611e4770-9955-4a8d-a405-eb657a858ad0/event
* Doesn't work with Microsoft Edge properly. Instead of receiving and printing data, Edge tries to download the stream as a file. Must be something to do with headers retured from server

## Future Work

* Fix Edge compability issue
