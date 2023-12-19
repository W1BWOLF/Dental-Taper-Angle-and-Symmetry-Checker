package ma.projet.services;


import ma.projet.entities.PW;
import ma.projet.entities.User;
import ma.projet.repositories.PWRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PWService {

    @Autowired
    PWRepository pwRepository;

    public PW create(PW o) {
        // TODO Auto-generated method stub
        return pwRepository.save(o);
    }

    public boolean delete(PW o) {
        // TODO Auto-generated method stub
        try {
            pwRepository.delete(o);
            return true;
        } catch (Exception e) {
            return false;		}
    }

    public PW update(PW o) {
        // TODO Auto-generated method stub
        return pwRepository.save(o);
    }

    public List<PW> findAll() {
        // TODO Auto-generated method stub
        return pwRepository.findAll();
    }
    public PW findById(Long id) {
        // TODO Auto-generated method stub
        return pwRepository.findById(id).orElse(null);
    }








}
