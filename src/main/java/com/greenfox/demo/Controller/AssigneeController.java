package com.greenfox.demo.Controller;

import com.greenfox.demo.Model.Assignee;
import com.greenfox.demo.Repository.AssigneeRepository;
import com.greenfox.demo.Repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AssigneeController {

  @Autowired
  Assignee myAssignee;

  @Autowired
  AssigneeRepository assigneeRepository;

  @GetMapping(value = "/todo/assignees")
  public String assignes(Model model) {
    model.addAttribute("assignees", assigneeRepository.findAll());
    return "assignees";
  }

  @GetMapping(value = "/todo/assignees/add")
  public String addAssignees(Model model) {
    model.addAttribute("newassignee", myAssignee);
    return "addassignee";
  }

  @PostMapping(value = "/todo/assignees/add")
  public String addedAssignees(@ModelAttribute Assignee newAssignee) {
    assigneeRepository.save(newAssignee);
    return "redirect:/todo/assignees";
  }

  @GetMapping(value = "/todo/assignees/{id}/delete")
  public String deleteAssignees(@PathVariable(name = "id") long id) {
    assigneeRepository.deleteById(id);
    return "redirect:/todo/assignees";
  }

  @GetMapping(value = "/todo/assignees/{id}/edit")
  public String editAssignees(@PathVariable(name = "id") long id, Model model) {
    model.addAttribute("editassignee", assigneeRepository.findById(id).get());
    return "editassignee";
  }

  @PostMapping(value = "/todo/assignees/{assigneeID}/edit")
  public String editedAssignees(@ModelAttribute Assignee editedAssignee) {
    assigneeRepository.save(editedAssignee);
    return "redirect:/todo/assignees";
  }

  @GetMapping(value = "/todo/assignees/{assigneeID}/todos")
  public String seeTodos(Model model, @PathVariable(name = "assigneeID") long id) {
    model.addAttribute("assignee", assigneeRepository.findById(id).get());
    return "todosofassignee";
  }
}
