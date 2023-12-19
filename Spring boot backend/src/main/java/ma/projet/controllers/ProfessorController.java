package ma.projet.controllers;

import ma.projet.entities.Professor;
import ma.projet.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/Professor")
@CrossOrigin("*")
public class ProfessorController {
    @Autowired
    private ProfessorService professorService;

    @PostMapping("")

    public Professor save(@RequestBody Professor p) {

        p.setId(0L);
        return professorService.create(p);

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {

        Professor p = professorService.findById(id);
        if (p == null) {

            return new ResponseEntity<Object>("Aucun professor avec l'id :" + id, HttpStatus.BAD_REQUEST);

        } else {

            return ResponseEntity.ok(p);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id, @RequestBody Professor professor) {

        if (professorService.findById(id) == null) {

            return new ResponseEntity<Object>("Aucune professor avec l'id :" + id, HttpStatus.BAD_REQUEST);

        } else {

            professor.setId(id);
            return ResponseEntity.ok(professorService.update(professor));
        }

    }

    @GetMapping("")
    public List<Professor> getAll() {
        return professorService.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        Professor p = professorService.findById(id);

        if (p == null) {
            return new ResponseEntity<Object>("Aucune professor avec l id " + id, HttpStatus.BAD_REQUEST);
        } else {

            professorService.delete(p);
            return ResponseEntity.ok("Professor " + id + " supprimé avec succes");

        }

    }



}