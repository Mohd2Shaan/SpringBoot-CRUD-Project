package in.strikes.crud_project_1.Service;

import in.strikes.crud_project_1.Entity.Student;
import in.strikes.crud_project_1.Repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    //create
    public Student createStudent(Student studentReq) {
        System.out.println("Inside Student Service");
        Student studentResp = studentRepository.save(studentReq);
        System.out.println("Exiting Student Service");
        return studentResp;
    }
    //read one
    public Student getStudent(Long id)
    {
        Optional<Student> studentresp= studentRepository.findById(id);
        if(studentresp.isPresent())
        {
            return studentresp.get();
        }
        else {
            return null;
        }

    }
    //find all
    public List<Student> getAllStudent()
    {
        List<Student> studentList = studentRepository.findAll();
        return  studentList;
    }

    //update
    public Student updateStudent(Long id, Student studentReq) {
        Optional<Student> existingStudent = studentRepository.findById(id);

        if(existingStudent.isEmpty()) {
            return null;
        }

        Student studentToSave = existingStudent.get();

        studentToSave.setName(studentReq.getName());
        studentToSave.setRollNo(studentReq.getRollNo());
        studentToSave.setSubject(studentReq.getSubject());
        studentToSave.setEmail(studentReq.getEmail());
        studentToSave.setAge(studentReq.getAge());

        return studentRepository.save(studentToSave);
    }

    //delete
    public Boolean deleteStudent(Long id) {
        Boolean isStudent = studentRepository.existsById(id);

        if(!isStudent) return false;

        studentRepository.deleteById(id);

        return true;
    }


}

