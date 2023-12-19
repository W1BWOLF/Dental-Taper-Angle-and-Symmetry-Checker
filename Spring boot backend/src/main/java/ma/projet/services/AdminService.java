package ma.projet.services;


import ma.projet.entities.Admin;
import ma.projet.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    AdminRepository adminRepository;

    public Admin create(Admin o) {
        // TODO Auto-generated method stub
        return adminRepository.save(o);
    }

    public boolean delete(Admin o) {
        // TODO Auto-generated method stub
        try {
            adminRepository.delete(o);
            return true;
        } catch (Exception e) {
            return false;		}
    }

    public Admin update(Admin o) {
        // TODO Auto-generated method stub
        return adminRepository.save(o);
    }

    public List<Admin> findAll() {
        // TODO Auto-generated method stub
        return adminRepository.findAll();
    }



    public Admin findById(Long id) {
        // TODO Auto-generated method stub
        return adminRepository.findById(id).orElse(null);
    }




}