package vn.iotstar.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import vn.iotstar.Entity.Student;

public interface StudentService {

	void delete(Student entity);

	List<Student> findAll();

	Optional<Student> findById(Integer id);

	Page<Student> findAll(Pageable pageable);

}
