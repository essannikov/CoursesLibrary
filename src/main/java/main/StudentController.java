package main;

import main.model.Student;
import main.model.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/students/")
    public List<Student> list(){
        //return StudentDAO.list();

        Iterable<Student> studentIterable = studentRepository.findAll();
        ArrayList<Student> students = new ArrayList<>();
        for (Student student : studentIterable){
            students.add(student);
        }
        return students;
    }

    @PostMapping("/students/")
    public Integer add(Student student){
        //return StudentDAO.add(student);

        Student newStudent = studentRepository.save(student);
        return newStudent.getId();
    }

    @GetMapping("/students/{id}")
    public ResponseEntity get(@PathVariable Integer id){
        //Student student = StudentDAO.get(id);

        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (!optionalStudent.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity(optionalStudent.get(), HttpStatus.OK);
    }
}
