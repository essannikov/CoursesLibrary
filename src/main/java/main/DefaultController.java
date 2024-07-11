package main;

import main.model.Student;
import main.model.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class DefaultController {
    @Autowired
    private StudentRepository studentRepository;

    //@Value("${someParameter.value}")
    private Integer someParameter = 2024;

    @RequestMapping("/")
    public String index(Model model)
    {
        Iterable<Student> studentIterable = studentRepository.findAll();
        ArrayList<Student> students = new ArrayList<>();
        for (Student student: studentIterable){
            students.add(student);
        }

        model.addAttribute("students", students);
        model.addAttribute("studentsCount", students.size());
        model.addAttribute("someParameter", someParameter);

        return "index";
    }
}
