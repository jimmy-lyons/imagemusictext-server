package com.estuaryenglish.imagemusictextServer.image;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ImageController {
    @Autowired
    private ImageService imageService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/projectImages/{id}")
    public Iterable<Image> getImagesByProjectId(@PathVariable Long id) {
        return imageService.getProjectImages(id);
    }

    @PostMapping("/projectImages/add")
    public Image add(@RequestBody @Valid Image image) {
        return imageService.add(image);
    }
}
