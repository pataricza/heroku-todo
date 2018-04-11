package com.greenfox.demo.Repository;

import com.greenfox.demo.Model.Todo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TodoRepository extends CrudRepository<Todo, Long> {
  List<Todo> findAllByDone(boolean done);
}
