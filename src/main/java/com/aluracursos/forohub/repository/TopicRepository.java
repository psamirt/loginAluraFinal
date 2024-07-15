package com.aluracursos.forohub.repository;

import com.aluracursos.forohub.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TopicRepository extends JpaRepository<Topic, Long> {
}
