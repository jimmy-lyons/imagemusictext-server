package com.estuaryenglish.imagemusictextServer.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectsService {
    @Autowired
    private ProjectsRepository projectsRepository;

    public ProjectsService(ProjectsRepository projectsRepository) {
        this.projectsRepository = projectsRepository;
    }

    public Iterable<Project> index() {
        return projectsRepository.findAll();
    }

    public Project add(Project project) {
        return projectsRepository.save(project);
    }
}
