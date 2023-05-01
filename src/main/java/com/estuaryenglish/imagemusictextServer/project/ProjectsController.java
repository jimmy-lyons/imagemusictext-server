package com.estuaryenglish.imagemusictextServer.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectsController {
    @Autowired
    private ProjectsService projectsService;

    @GetMapping("/projects")
    public Iterable<Project> index() {
        return projectsService.index();
    }
}
