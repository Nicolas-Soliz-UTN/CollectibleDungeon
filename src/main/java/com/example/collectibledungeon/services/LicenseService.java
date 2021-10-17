package com.example.collectibledungeon.services;

import com.example.collectibledungeon.entities.License;
import com.example.collectibledungeon.repositories.LicenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class LicenseService implements BaseService<License> {
    @Autowired
    private LicenseRepository repository;

    @Override
    @Transactional
    public List<License> findAll() throws Exception {
        try {
            List<License> licenses = repository.findAll();
            return licenses;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public License findById(long id) throws Exception {
        try {
            Optional<License> opt = repository.findById(id);
            return opt.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public License saveOne(License entity) throws Exception {
        try {
            License license = repository.save(entity);
            return license;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public License updateOne(License entity, long id) throws Exception {
        try {
            Optional<License> opt = repository.findById(id);
            License license = opt.get();
            license = repository.save(entity);
            return license;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean deleteById(long id) throws Exception {
        try {
            Optional<License> opt = repository.findById(id);
            if (!opt.isEmpty()) {
                License license = opt.get();
                license.setActive(!license.isActive());
                repository.save(license);
            } else {
                throw new Exception();
            }
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
