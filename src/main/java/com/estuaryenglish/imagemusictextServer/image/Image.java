package com.estuaryenglish.imagemusictextServer.image;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Image cannot be blank")
    private String image;

    @NotBlank(message = "Project id cannot be blank")
    private String projectId;

    public Image(Long id, String image, String projectId) {
        this.id = id;
        this.image = image;
        this.projectId = projectId;
    }

    public Image() {
    }

    public Long getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public String getProjectId() {
        return projectId;
    }
}
