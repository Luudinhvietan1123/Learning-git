package SelfLearnJuly2021.springboot.api;

import SelfLearnJuly2021.springboot.model.Student;
import SelfLearnJuly2021.springboot.model.StudentRepository;
import SelfLearnJuly2021.springboot.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @GetMapping()
    public List<Student> fetchAllStudents() {
        return studentService.getAllStudents();
    }

    /*@Autowired
    private StudentRepository repository;

    @PostMapping("/addStudent")
    public String saveStudent(@RequestBody Student student) {
        repository.save(student);
        return "Added student with id:" + student.getId();
    }

    @GetMapping("/findAllStudent")
    public List<Student> getStudents() {
        return repository.findAll();
    }

    @GetMapping("/student/{id}")
    public Optional<Student> selectStudentById(@PathVariable("id") String id) {
        return repository.findById(id);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable("id") String id) {
        repository.deleteById(id);
        return "Delete student by id: " + id;
    }*/
}
