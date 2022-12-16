package vn.iotstar.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import vn.iotstar.Entity.Project;

public interface IProjectService {

	void deleteAll();

	void deleteAll(Iterable<? extends Project> entities);

	Project getById(Long id);

	void delete(Project entity);

	void deleteById(Long id);

	long count();

	<S extends Project> Page<S> findAll(Example<S> example, Pageable pageable);

	List<Project> findAllById(Iterable<Long> ids);

	List<Project> findAll(Sort sort);

	Page<Project> findAll(Pageable pageable);

	List<Project> findAll();

	<S extends Project> Optional<S> findOne(Example<S> example);

	<S extends Project> S save(S entity);

	Optional<Project> findById(Long id);

	Page<Project> findByIdContaining(Long id, Pageable pageable);

	List<Project> findByIdContaining(Long id);
	
	Page<Project> findByNameContaining(String name, Pageable pageable);

	List<Project> findByIdlecture(Long id);


}
