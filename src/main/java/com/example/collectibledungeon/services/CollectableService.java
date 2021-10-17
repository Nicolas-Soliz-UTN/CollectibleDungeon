package com.example.collectibledungeon.services;

import com.example.collectibledungeon.entities.Collectable;
import com.example.collectibledungeon.repositories.CollectableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CollectableService implements BaseService<Collectable> {

    @Autowired
    private CollectableRepository repository;

    @Override
    @Transactional
    public List<Collectable> findAll() throws Exception {
        try {
            List<Collectable> collectables = repository.findAll();
            return collectables;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Collectable findById(long id) throws Exception {
        try {
            Optional<Collectable> opt = repository.findById(id);
            return opt.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Collectable saveOne(Collectable entity) throws Exception {
        try {
            Collectable collectable = repository.save(entity);
            return collectable;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Collectable updateOne(Collectable entity, long id) throws Exception {
        try {
            Optional<Collectable> opt = repository.findById(id);
            Collectable collectable = opt.get();
            collectable = repository.save(entity);
            return collectable;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean deleteById(long id) throws Exception {
        try {
            Optional<Collectable> opt = repository.findById(id);
            if (!opt.isEmpty()) {
                Collectable collectable = opt.get();
                collectable.setActive(!collectable.isActive());
                repository.save(collectable);
            } else {
                throw new Exception();
            }
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
