package bookstore.shop.service.impl;

import bookstore.shop.model.entity.Publisher;
import bookstore.shop.model.service.PublisherServiceModel;
import bookstore.shop.repository.PublisherRepository;
import bookstore.shop.service.PublisherService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    public PublisherServiceModel findByName(String name) {
        return this.publisherRepository.findByCompanyName(name).map(p -> this.modelMapper.map(p, PublisherServiceModel.class)).orElse(null);
    }

    @Override
    public List<String> findAll() {
        return this.publisherRepository.findAll().stream()
                .map(Publisher::getCompanyName).collect(Collectors.toList());
    }

    @Override
    public void addPublisher(PublisherServiceModel publisherServiceModel) {
        Publisher publisher = this.modelMapper.map(publisherServiceModel, Publisher.class);
        this.publisherRepository.saveAndFlush(publisher);
    }
}
