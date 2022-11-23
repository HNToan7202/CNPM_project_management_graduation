package vn.iotstar.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import vn.iotstar.Entity.Project;

public interface ProjectService {

	void deleteAll();

	void deleteById(String id);

	List<Project> findAll(Sort sort);

	Page<Project> findAll(Pageable pageable);

	List<Project> findAll();

	<S extends Project> Optional<S> findOne(Example<S> example);

	void delete(Project entity);

	long count();

	<S extends Project> S save(S entity);

	Optional<Project> findById(String id);

	Page<Project> findByIdContaining(String email, Pageable pageable);

	List<Project> findByIdContaining(String id);

}
