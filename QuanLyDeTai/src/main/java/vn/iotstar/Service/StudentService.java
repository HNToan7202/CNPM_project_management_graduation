package vn.iotstar.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import vn.iotstar.Entity.Student;

public interface StudentService {

	void deleteAll();

	Student getById(Long id);

	void delete(Student entity);

	long count();

	Optional<Student> findById(Long id);

	<S extends Student> Page<S> findAll(Example<S> example, Pageable pageable);

	List<Student> findAll();

	Student save(Student entity);

}
