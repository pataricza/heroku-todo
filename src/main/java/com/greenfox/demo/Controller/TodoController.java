package com.greenfox.demo.Controller;

import com.greenfox.demo.Model.Todo;
import com.greenfox.demo.Repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TodoController {

  @Autowired
  TodoRepository todoRepository;

  @Autowired
  Todo todo;

  @GetMapping(value = {"/todo/", "/todo/list"})
  public String list(@RequestParam(name = "isActive", required = false, defaultValue = "true") boolean isActive, Model model) {
    if (!isActive) {
      model.addAttribute("todos", todoRepository.findAllByDone(isActive));
      return "todoslist";
    } else {
      model.addAttribute("todos", todoRepository.findAll());
      return "todoslist";
    }
  }

  @GetMapping(value = "/todo/add")
  public String add(Model model) {
    model.addAttribute("newtodo", todo);
    return "addtodo";
  }

  @PostMapping(value = "/todo/add")
  public String added(@ModelAttribute Todo filledTodo) {
    todoRepository.save(filledTodo);
    return "redirect:/todo/";
  }

  @GetMapping(value = "/{id}/delete")
  public String delete(@PathVariable(name = "id") long id) {
    todoRepository.deleteById(id);
    return "redirect:/todo/";
  }

  @GetMapping(value = "/{id}/edit")
  public String edit(@PathVariable(name = "id") long id, Model model) {
   model.addAttribute("todo", todoRepository.findById(id).get());
   return "edit";
  }

  @PostMapping(value = "/{id}/edit")
  public String edited(@ModelAttribute Todo editedTodo) {
    todoRepository.save(editedTodo);
    return "redirect:/todo/";
  }
}
