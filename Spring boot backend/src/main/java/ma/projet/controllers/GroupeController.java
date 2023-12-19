package ma.projet.controllers;


import ma.projet.entities.Groupe;
import ma.projet.services.GroupeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/Groupe")
@CrossOrigin("*")
public class GroupeController {
    @Autowired
    private GroupeService groupeService;

    @PostMapping("")

    public Groupe save(@RequestBody Groupe p) {

        p.setId(0L);
        return groupeService.create(p);

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {

        Groupe p = groupeService.findById(id);
        if (p == null) {

            return new ResponseEntity<Object>("Aucun groupe avec l'id :" + id, HttpStatus.BAD_REQUEST);

        } else {

            return ResponseEntity.ok(p);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id, @RequestBody Groupe groupe) {

        if (groupeService.findById(id) == null) {

            return new ResponseEntity<Object>("Aucune groupe avec l'id :" + id, HttpStatus.BAD_REQUEST);

        } else {

            groupe.setId(id);
            return ResponseEntity.ok(groupeService.update(groupe));
        }

    }

    @GetMapping("")
    public List<Groupe> getAll() {
        return groupeService.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        Groupe p = groupeService.findById(id);

        if (p == null) {
            return new ResponseEntity<Object>("Aucune groupe avec l id " + id, HttpStatus.BAD_REQUEST);
        } else {

            groupeService.delete(p);
            return ResponseEntity.ok("Groupe " + id + " supprimé avec succes");

        }

    }



}