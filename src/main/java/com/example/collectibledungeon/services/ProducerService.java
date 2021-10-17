package com.example.collectibledungeon.services;

import com.example.collectibledungeon.entities.Producer;
import com.example.collectibledungeon.repositories.ProducerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProducerService implements BaseService<Producer> {
    @Autowired
    private ProducerRepository repository;

    @Override
    @Transactional
    public List<Producer> findAll() throws Exception {
        try {
            List<Producer> producers = repository.findAll();
            return producers;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Producer findById(long id) throws Exception {
        try {
            Optional<Producer> opt = repository.findById(id);
            return opt.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Producer saveOne(Producer entity) throws Exception {
        try {
            Producer producer = repository.save(entity);
            return producer;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Producer updateOne(Producer entity, long id) throws Exception {
        try {
            Optional<Producer> opt = repository.findById(id);
            Producer producer = opt.get();
            producer = repository.save(entity);
            return producer;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean deleteById(long id) throws Exception {
        try {
            Optional<Producer> opt = repository.findById(id);
            if (!opt.isEmpty()) {
                Producer producer = opt.get();
                producer.setActive(!producer.isActive());
                repository.save(producer);
            } else {
                throw new Exception();
            }
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
