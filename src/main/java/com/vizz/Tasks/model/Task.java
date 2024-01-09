package com.vizz.Tasks.model;

import org.springframework.cglib.core.Local;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;

@Document(collection = "vinayak")
public class Task {

    @Id
    private String id;
    private String name;
    private String assignee;
    private String project;
    private LocalDateTime startTime;

    private String vinayakProperty;

    public Task(){}

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAssignee() {
        return assignee;
    }

    public String getProject() {
        return project;
    }

    public String getVinayakProperty() {
        return vinayakProperty;
    }

    public LocalDateTime getDate() {
        return startTime;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public void setDate(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public void setVinayakProperty(String vinayakProperty) {
        this.vinayakProperty = vinayakProperty;
    }

}
