package bookstore.shop.service.impl;

import bookstore.shop.model.entity.Publisher;
import bookstore.shop.model.service.PublisherServiceModel;
import bookstore.shop.repository.PublisherRepository;
import bookstore.shop.service.PublisherService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PublisherServiceImpl implements PublisherService {
    private final PublisherRepository publisherRepository;
    private final ModelMapper modelMapper;

    public PublisherServiceImpl(PublisherRepository publisherRepository, ModelMapper modelMapper) {
        this.publisherRepository = publisherRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Publisher findById(String id) {
        return this.modelMapper.map(this.publisherRepository.findById(id), Publisher.class);
    }

    @Override
    public Publisher findByName(String name) {
        return this.publisherRepository.findByCompanyName(name);
    }

    @Override
    public List<Publisher> findAll() {
        return this.publisherRepository.findAll();
    }

    @Override
    public void addPublisher(PublisherServiceModel publisherServiceModel) {
        Publisher publisher = this.modelMapper.map(publisherServiceModel, Publisher.class);
        this.publisherRepository.saveAndFlush(publisher);
    }
}
