package ma.projet.controllers;


import ma.projet.entities.User;
import ma.projet.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/User")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("")

    public User save(@RequestBody User p) {

        p.setId(0L);
        return userService.create(p);

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {

        User p = userService.findById(id);
        if (p == null) {

            return new ResponseEntity<Object>("Aucun user avec l'id :" + id, HttpStatus.BAD_REQUEST);

        } else {

            return ResponseEntity.ok(p);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id, @RequestBody User user) {

        if (userService.findById(id) == null) {

            return new ResponseEntity<Object>("Aucune user avec l'id :" + id, HttpStatus.BAD_REQUEST);

        } else {

            user.setId(id);
            return ResponseEntity.ok(userService.update(user));
        }

    }

    @GetMapping("")
    public List<User> getAll() {
        return userService.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        User p = userService.findById(id);

        if (p == null) {
            return new ResponseEntity<Object>("Aucune user avec l id " + id, HttpStatus.BAD_REQUEST);
        } else {

            userService.delete(p);
            return ResponseEntity.ok("User " + id + " supprimé avec succes");

        }

    }



}