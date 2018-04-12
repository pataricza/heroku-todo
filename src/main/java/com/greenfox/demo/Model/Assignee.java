package com.greenfox.demo.Model;

import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.List;

@Entity
@Service
public class Assignee {

  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private long assigneeID;
  private String name;
  private String email;

  public Assignee() {
  }

  public long getAssigneeID() {
    return assigneeID;
  }

  public void setAssigneeID(long assigneeID) {
    this.assigneeID = assigneeID;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @OneToMany(mappedBy = "assignee")
  private List<Todo> todoList;

  public List<Todo> getTodoList() {
    return todoList;
  }

  public void setTodoList(List<Todo> todoList) {
    this.todoList = todoList;
  }
}
