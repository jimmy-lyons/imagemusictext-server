package com.estuaryenglish.imagemusictextServer.image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService {
    @Autowired
    private ImageRepository imageRepository;

    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public Iterable<Image> getProjectImages(Long projectId) {
        return imageRepository.findByProjectId(projectId.toString());
    }

    public Image add(Image image) {
        return imageRepository.save(image);
    }
}
