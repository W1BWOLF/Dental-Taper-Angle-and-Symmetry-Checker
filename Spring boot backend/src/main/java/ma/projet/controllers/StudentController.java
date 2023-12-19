package ma.projet.controllers;


import ma.projet.entities.Student;
import ma.projet.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/Student")
@CrossOrigin("*")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("")

    public Student save(@RequestBody Student p) {

        p.setId(0L);
        return studentService.create(p);

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {

        Student p = studentService.findById(id);
        if (p == null) {

            return new ResponseEntity<Object>("Aucun student avec l'id :" + id, HttpStatus.BAD_REQUEST);

        } else {

            return ResponseEntity.ok(p);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id, @RequestBody Student student) {

        if (studentService.findById(id) == null) {

            return new ResponseEntity<Object>("Aucune student avec l'id :" + id, HttpStatus.BAD_REQUEST);

        } else {

            student.setId(id);
            return ResponseEntity.ok(studentService.update(student));
        }

    }

    @GetMapping("")
    public List<Student> getAll() {
        return studentService.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        Student p = studentService.findById(id);

        if (p == null) {
            return new ResponseEntity<Object>("Aucune student avec l id " + id, HttpStatus.BAD_REQUEST);
        } else {

            studentService.delete(p);
            return ResponseEntity.ok("Student " + id + " supprimé avec succes");

        }

    }



}