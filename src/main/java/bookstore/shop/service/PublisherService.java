package bookstore.shop.service;

import bookstore.shop.model.entity.Publisher;
import bookstore.shop.model.service.PublisherServiceModel;

import java.util.List;

public interface PublisherService {
    Publisher findById(String id);
    PublisherServiceModel findByName(String name);
    List<String> findAll();
    void addPublisher(PublisherServiceModel publisherServiceModel);
}
