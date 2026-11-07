package in.strikes.crud_project_1.Controller;

import in.strikes.crud_project_1.Entity.Student;
import in.strikes.crud_project_1.Service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    @RequestMapping("/api/students")
    public class StudentController {

        private StudentService studentService;

        public StudentController(StudentService studentService) {
            this.studentService = studentService;
        }

        @PostMapping("/create")
        public ResponseEntity<Student> createStudent(@RequestBody Student student) {
            System.out.println("Inside Student Controller");
            Student createdStudent = studentService.createStudent(student);
            System.out.println("Exiting Student Controller");
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(createdStudent);
        }

        // read one student
        @GetMapping("/id/{id}")
        public ResponseEntity<Student> getStudent(@PathVariable Long id)
        {
            Student studentresp = studentService.getStudent(id);
            if(studentresp==null)
            {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            return ResponseEntity.ok(studentresp);

        }


        //getAll Student
        @GetMapping("/getAll")
        public ResponseEntity<List<Student>> getAllStudent()
        {
            List<Student> studentList = studentService.getAllStudent();
            if(studentList.isEmpty())
            {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            return ResponseEntity.ok(studentList);

        }
        // update student
        @PutMapping("/update")
        public ResponseEntity<Student> updateStudent(@RequestParam Long id,
                                                     @RequestBody Student studentReq) {
            Student studentResp = studentService.updateStudent(id, studentReq);

            if(studentResp == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(studentResp);
        }

        // delete student
        @DeleteMapping("/delete")
        public ResponseEntity<String> deleteStudent(@RequestParam Long id) {
            Boolean isDeleted = studentService.deleteStudent(id);

            if(!isDeleted) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok("Record deleted");
        }




}
