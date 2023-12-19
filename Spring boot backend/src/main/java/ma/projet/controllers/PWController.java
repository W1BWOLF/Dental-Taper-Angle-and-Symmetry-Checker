package ma.projet.controllers;

import ma.projet.entities.PW;
import ma.projet.services.PWService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/PW")
@CrossOrigin("*")
public class PWController {
    @Autowired
    private PWService pwService;

    @PostMapping("")

    public PW save(@RequestBody PW p) {

        p.setId(0L);
        return pwService.create(p);

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {

        PW p = pwService.findById(id);
        if (p == null) {

            return new ResponseEntity<Object>("Aucun pw avec l'id :" + id, HttpStatus.BAD_REQUEST);

        } else {

            return ResponseEntity.ok(p);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id, @RequestBody PW pw) {

        if (pwService.findById(id) == null) {

            return new ResponseEntity<Object>("Aucune pw avec l'id :" + id, HttpStatus.BAD_REQUEST);

        } else {

            pw.setId(id);
            return ResponseEntity.ok(pwService.update(pw));
        }

    }

    @GetMapping("")
    public List<PW> getAll() {
        return pwService.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        PW p = pwService.findById(id);

        if (p == null) {
            return new ResponseEntity<Object>("Aucune pw avec l id " + id, HttpStatus.BAD_REQUEST);
        } else {

            pwService.delete(p);
            return ResponseEntity.ok("PW " + id + " supprimé avec succes");

        }

    }



}
