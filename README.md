# Textbook Donation Post

### Purpose

Provide a Platform for Teachers/Students/School Staff/Education Agencies to claim textbooks for themselves or students.

Provide a place to request for used texbooks

### APIs

#### Textbook Donation Post API

Post a Textbook Donation Post

Claim Textbook Donation Post

List<Textbook Donation Post>

Search API - by Name, by Subject, by Author, by Tags

Remove a Textbook Donation Post 

Get Details of Textbook Donation Post

#### Textbook Request Post API

List<textBook Request>

Get RequestPost

Post a Request Post

Remove a Request Post

Search Request Post - Name/Location


#### How to run locally

1. Have a local MongoDB set up and started(a must)/ If you want to use another MongoDB hosted somewhere else - make sure to change the uri in the application.yaml file
2. Run 'mvn clean install -U'
3. Run Java Program from main application
4. Send HTTP Requests from Postman or CURL like this localhost:80/textbook-request-post/ - for textbook request post API .
Coming soon : Textbook Donation API


