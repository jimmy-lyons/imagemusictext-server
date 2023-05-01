package com.estuaryenglish.imagemusictextServer.image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImageController {
    @Autowired
    private ImageService imageService;

    @GetMapping("/projectImages")
    public Iterable<Image> getImagesByProjectId(Long projectId) {
        return imageService.getProjectImages(projectId);
    }
}
