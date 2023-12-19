package ma.projet.services;


import ma.projet.entities.Groupe;
import ma.projet.repositories.GroupeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupeService {

    @Autowired
    GroupeRepository groupeRepository;

    public Groupe create(Groupe o) {
        // TODO Auto-generated method stub
        return groupeRepository.save(o);
    }

    public boolean delete(Groupe o) {
        // TODO Auto-generated method stub
        try {
            groupeRepository.delete(o);
            return true;
        } catch (Exception e) {
            return false;		}
    }

    public Groupe update(Groupe o) {
        // TODO Auto-generated method stub
        return groupeRepository.save(o);
    }

    public List<Groupe> findAll() {
        // TODO Auto-generated method stub
        return groupeRepository.findAll();
    }



    public Groupe findById(Long id) {
        // TODO Auto-generated method stub
        return groupeRepository.findById(id).orElse(null);
    }



}