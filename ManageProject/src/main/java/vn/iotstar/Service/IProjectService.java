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

	Project getById(String id);

	void delete(Project entity);

	void deleteById(String id);

	long count();

	<S extends Project> Page<S> findAll(Example<S> example, Pageable pageable);

	List<Project> findAllById(Iterable<String> ids);

	List<Project> findAll(Sort sort);

	Page<Project> findAll(Pageable pageable);

	List<Project> findAll();

	<S extends Project> S save(S entity);

	Optional<Project> findById(String id);

	
}
