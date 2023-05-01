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
        System.out.println(("************************      I'm in the service       *****************"));
        Iterable<Image> images = imageRepository.findByProjectId(projectId.toString());
//        Iterable<Image> images = imageRepository.findAll();
        System.out.println("+++++++++++++++++++++++++" + images);
        return images;
    }

    public Image add(Image image) {
        return imageRepository.save(image);
    }
}
