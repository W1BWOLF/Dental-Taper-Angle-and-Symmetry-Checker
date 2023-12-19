package ma.projet.controllers;


import ma.projet.entities.Tooth;
import ma.projet.services.ToothService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/Tooth")
public class ToothController {
    @Autowired
    private ToothService toothService;

    @PostMapping("")

    public Tooth save(@RequestBody Tooth p) {

        p.setId(0L);
        return toothService.create(p);

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {

        Tooth p = toothService.findById(id);
        if (p == null) {

            return new ResponseEntity<Object>("Aucun tooth avec l'id :" + id, HttpStatus.BAD_REQUEST);

        } else {

            return ResponseEntity.ok(p);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id, @RequestBody Tooth tooth) {

        if (toothService.findById(id) == null) {

            return new ResponseEntity<Object>("Aucune tooth avec l'id :" + id, HttpStatus.BAD_REQUEST);

        } else {

            tooth.setId(id);
            return ResponseEntity.ok(toothService.update(tooth));
        }

    }

    @GetMapping("")
    public List<Tooth> getAll() {
        return toothService.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        Tooth p = toothService.findById(id);

        if (p == null) {
            return new ResponseEntity<Object>("Aucune tooth avec l id " + id, HttpStatus.BAD_REQUEST);
        } else {

            toothService.delete(p);
            return ResponseEntity.ok("Tooth " + id + " supprimé avec succes");

        }

    }



}
