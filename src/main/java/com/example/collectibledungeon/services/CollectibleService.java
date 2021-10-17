package com.example.collectibledungeon.services;

import com.example.collectibledungeon.entities.Collectible;
import com.example.collectibledungeon.repositories.CollectibleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CollectibleService implements BaseService<Collectible> {

    @Autowired
    private CollectibleRepository repository;

    @Override
    @Transactional
    public List<Collectible> findAll() throws Exception {
        try {
            List<Collectible> collectibles = repository.findAll();
            return collectibles;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Collectible findById(long id) throws Exception {
        try {
            Optional<Collectible> opt = repository.findById(id);
            return opt.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Collectible saveOne(Collectible entity) throws Exception {
        try {
            Collectible collectible = repository.save(entity);
            return collectible;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Collectible updateOne(Collectible entity, long id) throws Exception {
        try {
            Optional<Collectible> opt = repository.findById(id);
            Collectible collectible = opt.get();
            collectible = repository.save(entity);
            return collectible;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean deleteById(long id) throws Exception {
        try {
            Optional<Collectible> opt = repository.findById(id);
            if (!opt.isEmpty()) {
                Collectible collectible = opt.get();
                collectible.setActive(!collectible.isActive());
                repository.save(collectible);
            } else {
                throw new Exception();
            }
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public List<Collectible> findAllByActive() throws Exception {
        try {
            List<Collectible> collectibles = repository.findAllByActive();
            return collectibles;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Collectible findAllByIdAndActive(long id) throws Exception {
        try {
            Optional<Collectible> opt = repository.findAllByIdAndActive(id);
            return opt.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
