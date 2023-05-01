package com.estuaryenglish.imagemusictextServer.project;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @NotBlank(message = "Heading cannot be blank")
    private String heading;

    @NotBlank(message = "Description cannot be blank")
    private String description;

    @NotBlank(message = "Client cannot be blank")
    private String client;

    public Project(Long id, String name, String heading, String description, String client) {
        this.id = id;
        this.name = name;
        this.heading = heading;
        this.description = description;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getHeading() {
        return heading;
    }

    public String getDescription() {
        return description;
    }

    public String getClient() {
        return client;
    }
}
