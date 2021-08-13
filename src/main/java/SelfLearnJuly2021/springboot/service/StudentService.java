package SelfLearnJuly2021.springboot.service;

import SelfLearnJuly2021.springboot.model.Student;
import SelfLearnJuly2021.springboot.model.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }
}
