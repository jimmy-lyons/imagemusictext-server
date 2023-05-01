package com.estuaryenglish.imagemusictextServer.image;

import org.springframework.data.repository.CrudRepository;

public interface ImageRepository extends CrudRepository<Image, Long> {
    Iterable<Image> findByProjectId(Long projectId);
}
