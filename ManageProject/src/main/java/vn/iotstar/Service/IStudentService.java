package vn.iotstar.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import vn.iotstar.Entity.Student;

public interface IStudentService {

	
	
	List<Student> findByNameContaining (String name);
	Page<Student> findByNameContaining (String name,Pageable pageable);

	Student findByEmailContaining(String email);

	List<Student> findByIdproject(Integer idproject);
	Student getById(Integer id);
	void delete(Student entity);
	void deleteById(Integer id);
	long count();
	List<Student> findAllById(Iterable<Integer> ids);
	List<Student> findAll();
	<S extends Student> S save(S entity);
	Optional<Student> findById(Integer id);

	
}
