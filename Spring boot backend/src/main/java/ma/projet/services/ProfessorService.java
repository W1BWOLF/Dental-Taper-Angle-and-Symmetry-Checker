package ma.projet.services;


import ma.projet.entities.Professor;
import ma.projet.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {

    @Autowired
    ProfessorRepository professorRepository;

    public Professor create(Professor o) {
        // TODO Auto-generated method stub
        return professorRepository.save(o);
    }

    public boolean delete(Professor o) {
        // TODO Auto-generated method stub
        try {
            professorRepository.delete(o);
            return true;
        } catch (Exception e) {
            return false;		}
    }

    public Professor update(Professor o) {
        // TODO Auto-generated method stub
        return professorRepository.save(o);
    }

    public List<Professor> findAll() {
        // TODO Auto-generated method stub
        return professorRepository.findAll();
    }
    public Professor findById(Long id) {
        // TODO Auto-generated method stub
        return professorRepository.findById(id).orElse(null);
    }







}