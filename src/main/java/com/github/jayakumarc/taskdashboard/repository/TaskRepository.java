package com.github.jayakumarc.taskdashboard.repository;

import com.github.jayakumarc.taskdashboard.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}
