package ma.projet.controllers;

import ma.projet.entities.Admin;
import ma.projet.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("")

    public Admin save(@RequestBody Admin p) {

        p.setId(0L);
        return adminService.create(p);

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {

        Admin p = adminService.findById(id);
        if (p == null) {

            return new ResponseEntity<Object>("Aucun admin avec l'id :" + id, HttpStatus.BAD_REQUEST);

        } else {

            return ResponseEntity.ok(p);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id, @RequestBody Admin admin) {

        if (adminService.findById(id) == null) {

            return new ResponseEntity<Object>("Aucune admin avec l'id :" + id, HttpStatus.BAD_REQUEST);

        } else {

            admin.setId(id);
            return ResponseEntity.ok(adminService.update(admin));
        }

    }

    @GetMapping("")
    public List<Admin> getAll() {
        return adminService.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        Admin p = adminService.findById(id);

        if (p == null) {
            return new ResponseEntity<Object>("Aucune admin avec l id " + id, HttpStatus.BAD_REQUEST);
        } else {

            adminService.delete(p);
            return ResponseEntity.ok("Admin " + id + " supprimé avec succes");

        }

    }



}