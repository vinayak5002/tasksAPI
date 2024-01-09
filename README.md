# tasksAPI
A REST API developed with java spring boot, using mongoDB as backend


# Usage
Built on java [Spring boot](https://spring.io/projects/spring-boot/) using mongoDB as backend  

You need to install mongoDB server, mongo shell
Follow the steps [here](https://medium.com/@LondonAppBrewery/how-to-download-install-mongodb-on-windows-4ee4b3493514) or follow steps of your own choice

Deploy mongo server and create a database called ```tasks``` with one collection called ```vinayak```

*you can have the collection name of your wish, specify it in [Task.java](https://github.com/vinayak5002/tasksAPI/blob/deac3bb96a4df10499719dcfd7ca6990bb8d14fe/src/main/java/com/vizz/Tasks/model/Task.java#L11C34-L11C34)  
Create a user
```
db.createUser({ user: "root",pwd:  "root", roles: [ { role: "readWrite", db: "movies" }]})
```

After setting up the mongodb server, you can fork, clone this java project and open it in the java IDE of your choice

# Routes
Features of the API and their API routes
## All tasks
```
/
```
Basic structure of result
```
{
    "id": "502",
    "name": "update fedora",
    "assignee": "MSV",
    "project": "Kaiburr",
    "vinayakProperty": "nniVa",
    "date": "2024-01-09T20:20:47.481"
}
```
Return a list which contains all the tasks in the database
![Screenshot 2024-01-09 210230](https://github.com/vinayak5002/tasksAPI/assets/82216732/3d5d50fc-1ab1-4f9f-beef-07844b8390be)

## Task by ID
```
/{id}
```
Returns the task with the id specified
![Screenshot 2024-01-09 210441](https://github.com/vinayak5002/tasksAPI/assets/82216732/ce106cd3-a411-48df-98ed-c5e3b54dabd8)
If no task with the id specified exists, 404 error is returned
![Screenshot 2024-01-09 210528](https://github.com/vinayak5002/tasksAPI/assets/82216732/cf48454c-42c8-4e73-b0df-a5e3599a78cf)

## Create task
```
/addTask
```
Adds the task passed in the body of the request to the database
Sample request body:
```
{
    "id": "512",
    "name":"resolve frontend styling issues",
    "assignee": "Vinayak",
    "project": "Kaiburr",
    "date": ""
}
```
*note: Anything can be passed as date as this is auto generated while adding task to database
![Screenshot 2024-01-09 210627](https://github.com/vinayak5002/tasksAPI/assets/82216732/5391b8b2-45c8-422d-a0a0-9c451e0221d7)

 ## Remove task
```
/delTask/{id}
```
Removes the task with th ID specified
![Screenshot 2024-01-09 210735](https://github.com/vinayak5002/tasksAPI/assets/82216732/c76ac3e6-ad31-4579-9417-e123a6862da3)

## Search tasks by name
```
/byName/{name}
```
Returns list of all tasks by the specified name
![Screenshot 2024-01-09 211049](https://github.com/vinayak5002/tasksAPI/assets/82216732/f8c98b9b-78ab-4a66-87c9-1a01ef4348f3)

## Search task by assigne
```
/byAssignee/{name}
```
Returns list of 10 tasks in the name th specified assignee
![Screenshot 2024-01-09 211213](https://github.com/vinayak5002/tasksAPI/assets/82216732/b0c335fa-31f3-4086-8bbf-dd364f0b0f17)
