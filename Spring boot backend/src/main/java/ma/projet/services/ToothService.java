package ma.projet.services;

import ma.projet.entities.Tooth;
import ma.projet.repositories.ToothRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToothService {

    @Autowired
    ToothRepository toothRepository;

    public Tooth create(Tooth o) {
        // TODO Auto-generated method stub
        return toothRepository.save(o);
    }

    public boolean delete(Tooth o) {
        // TODO Auto-generated method stub
        try {
            toothRepository.delete(o);
            return true;
        } catch (Exception e) {
            return false;		}
    }

    public Tooth update(Tooth o) {
        // TODO Auto-generated method stub
        return toothRepository.save(o);
    }

    public List<Tooth> findAll() {
        // TODO Auto-generated method stub
        return toothRepository.findAll();
    }


    public Tooth findById(Long id) {
        // TODO Auto-generated method stub
        return toothRepository.findById(id).orElse(null);
    }


}