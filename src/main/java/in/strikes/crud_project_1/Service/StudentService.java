package in.strikes.crud_project_1.Service;

import in.strikes.crud_project_1.Entity.Student;
import in.strikes.crud_project_1.Repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student studentReq) {
        System.out.println("Inside Student Service");
        Student studentResp = studentRepository.saveStudent(studentReq);
        System.out.println("Exiting Student Service");
        return studentResp;
    }
}

