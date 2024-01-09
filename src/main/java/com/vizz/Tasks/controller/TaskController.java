package com.vizz.Tasks.controller;

import com.vizz.Tasks.model.Task;
import com.vizz.Tasks.repository.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

@RestController
public class TaskController {

    private Logger logger = LoggerFactory.getLogger(TaskController.class);

    @Autowired
    private TaskRepository taskRepository;

    // Get all tasks
    @GetMapping("/")
    public ResponseEntity<List<Task>> getAllTasks(){
        logger.info("Getting all tasks");
        return ResponseEntity.ok(taskRepository.findAll());
    }

    // Get all tasks by id
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable String id){
        logger.info("Getting task with id: " + id);

        try {
            Task task = taskRepository.findById(id).orElseThrow();
            return ResponseEntity.ok(task);
        } catch (Exception e) {
            logger.error("Error getting task with id: " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // Add task
    @PostMapping("/addTask")
    public ResponseEntity<Task> putTask(@RequestBody Task task){
        logger.info("Added task " + task.getName());

        try {
            // assigning the special property with the special random string when the task is created
            // this is done to make this property persistent in the database
            String inputString = "Vinayak";

            Random random = new Random();
            StringBuilder randStr = new StringBuilder();

            for (int i = 0; i < 5; i++) {
                int randomIndex = random.nextInt(inputString.length());
                char randomChar = inputString.charAt(randomIndex);
                randStr.append(randomChar);
            }

            task.setVinayakProperty(randStr.toString());

            task.setDate(LocalDateTime.now());

            Task savedTask = taskRepository.save(task);
            return ResponseEntity.ok(savedTask);
        } catch (Exception e) {
            logger.error("Error occurred while saving task: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(task);
        }
    }

    // Delete task
    @DeleteMapping("/delTask/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable String id){
        logger.info("Deleting task with id: " + id);

        try {
            taskRepository.deleteById(id);
            return ResponseEntity.ok("Task deleted successfully");
        } catch (Exception e) {
            logger.error("Error deleting task with id: " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error deleting task with id: " + id);

        }
    }

    // Search tasks by name
    @GetMapping("/byName/{name}")
    public ResponseEntity<List<Task>> getTaskByName(@PathVariable String name){
        logger.info("Getting tasks by name");

        List<Task> tasks = taskRepository.findByName(name);

        if(tasks.size() == 0){
            logger.info("Name specified, not found");
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return ResponseEntity.ok(tasks);
    }

    // Search for 10 most recent tasks by an assignee
    @GetMapping("/byAssignee/{name}")
    public ResponseEntity<List<Task>> getTaskByAssignee(@PathVariable String name){
        logger.info("Getting tasks by assignee name");

        List<Task> tasks = taskRepository.findByAssignee(name);

        if (tasks.size() == 0){
            logger.info("Assignee name specified, not found");
            ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

//        Collections.sort(tasks, Comparator.comparing(Task::getDate));
        tasks = tasks.subList(0, Math.min(tasks.size(), 10));

        return ResponseEntity.ok(tasks);
    }

}