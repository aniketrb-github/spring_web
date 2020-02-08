# Reference Documentation for Restful Web-services application

# Pre-requisites for this application

# Technical requirements
1) STS IDE software
2) Postman API Client
3) Internet for Apache Maven dependency downloads
4) Some basic knowledge of Spring MVC, Core Java, HTTP protocol and SQL

# Following are the End-points we'd implement in our  restful application

# Social Media Application having users & posts

# REST End-points related to Users
- Get all users		: GET		/users
- Get an user		: GET		/users/{userId}
- create an user	: POST		/users
- delete an user 	: DELETE	/users/{userId}
- delete all users 	: DELETE	/users
- update an user	: PUT		/users/{userId}

# REST End-points related to Posts shared by users
- Get all posts shared by a user			: GET		/users/{userId}/posts
- Get details of a post shared by a user	: GET		/users/{userId}/posts/{postId}
- Create a post for a user					: POST		/users/{userId}/posts
- Delete all posts of a user				: DELETE 	/users/{userId}/posts
- Delete a post shared by an user			: DELETE	/users/{userId}/posts/{postId}
- Update a post of a user					: PUT		/users/{userId}/posts/{postId}