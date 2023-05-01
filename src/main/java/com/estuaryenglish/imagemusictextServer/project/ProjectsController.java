package com.estuaryenglish.imagemusictextServer.project;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProjectsController {
    @Autowired
    private ProjectsService projectsService;

    @GetMapping("/projects")
    public Iterable<Project> index() {
        return projectsService.index();
    }

    @PostMapping("/projects/add")
    public Project add(@RequestBody @Valid Project project) {
        return projectsService.add(project);
    }
}
