package ma.projet.services;

import ma.projet.entities.Student;
import ma.projet.entities.User;
import ma.projet.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public Student create(Student o) {
        // TODO Auto-generated method stub
        return studentRepository.save(o);
    }

    public boolean delete(Student o) {
        // TODO Auto-generated method stub
        try {
            studentRepository.delete(o);
            return true;
        } catch (Exception e) {
            return false;		}
    }

    public Student update(Student o) {
        // TODO Auto-generated method stub
        return studentRepository.save(o);
    }

    public List<Student> findAll() {
        // TODO Auto-generated method stub
        return studentRepository.findAll();
    }


    public Student findById(Long id) {
        // TODO Auto-generated method stub
        return studentRepository.findById(id).orElse(null);
    }




}