package com.greenfox.demo.Repository;

import com.greenfox.demo.Model.Todo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TodoRepository extends CrudRepository<Todo, Long> {
  List<Todo> findAllByDone(boolean done);

  @Query("select lower(c) from Todo c where c.title like %:searchedtitle%")
  List<Todo> customTitleFinder(@Param("searchedtitle") String searchedtitle);
}
