package com.vizz.Tasks.repository;

import com.vizz.Tasks.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TaskRepository extends MongoRepository<Task, String> {

    List<Task> findByName(String name);

    List<Task> findByAssignee(String assignee);

}
