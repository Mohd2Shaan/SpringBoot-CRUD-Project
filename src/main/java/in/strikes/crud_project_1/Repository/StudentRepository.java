package in.strikes.crud_project_1.Repository;

import in.strikes.crud_project_1.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {




}

