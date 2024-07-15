package com.aluracursos.forohub.controller;

import com.aluracursos.forohub.DTO.TopicRequest;
import com.aluracursos.forohub.model.Topic;
import com.aluracursos.forohub.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicController {

    @Autowired
    private TopicRepository topicRepository;

    @GetMapping("topics")
    public List<Topic> getAllTopics() {
        return topicRepository.findAll();
    }

    @PostMapping("topics")
    public String createTopic(@RequestBody TopicRequest topicRequest) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserId = authentication.getName();

        Topic topic = new Topic();
        topic.setTitle(topicRequest.getTitle());
        topic.setMessage(topicRequest.getMessage());
        topic.setNameCourse(topicRequest.getNameCourse());
        topic.setUserId(currentUserId);
        topicRepository.save(topic);
        return "Tópico creado correctamente";
    }

    @PutMapping("topics/{id}")
    public String updateTopic(@PathVariable Long id, @RequestBody TopicRequest updatedTopicRequest) {
        Topic existingTopic = topicRepository.findById(id).orElse(null);
        if (existingTopic != null) {
            existingTopic.setTitle(updatedTopicRequest.getTitle());
            existingTopic.setMessage(updatedTopicRequest.getMessage());
            existingTopic.setNameCourse(updatedTopicRequest.getNameCourse());
            topicRepository.save(existingTopic);
            return "Tópico editado correctamente";
        } else {
            return "Tópico no encontrado";
        }
    }

    @DeleteMapping("topics/{id}")
    public String deleteTopic(@PathVariable Long id) {
        Topic topicToDelete = topicRepository.findById(id).orElse(null);
        if (topicToDelete != null) {
            topicRepository.delete(topicToDelete);
            return "Tópico eliminado";
        } else {
            return "Tópico no encontrado";
        }
    }
}
