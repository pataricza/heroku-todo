package com.greenfox.demo.Model;

import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.Date;

@Entity
@Service
public class Todo {

  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private long id;
  private String title;
  private boolean urgent;
  private boolean done;
  @Temporal(TemporalType.TIMESTAMP)
  private Date createdAt;

  public Todo() {
    createdAt = new Date();
  }

  public String getTitle() {
    return title;
  }

  public long getId() {
    return id;
  }

  public boolean isUrgent() {
    return urgent;
  }

  public boolean isDone() {
    return done;
  }

  public void setId(long id) {
    this.id = id;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setUrgent(boolean urgent) {
    this.urgent = urgent;
  }

  public void setDone(boolean done) {
    this.done = done;
  }

  @ManyToOne
  @JoinColumn(name = "assigneeID")
  private Assignee assignee;

  public Assignee getAssignee() {
    return assignee;
  }

  public void setAssignee(Assignee assignee) {
    this.assignee = assignee;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }
}
