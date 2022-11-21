package vn.iotstar.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import vn.iotstar.Entity.Admin;

public interface AdminService {

	<S extends Admin> List<S> findAll(Example<S> example, Sort sort);

	void deleteAll();

	Admin getById(Integer id);

	void delete(Admin entity);

	Admin getOne(Integer id);

	void deleteById(Integer id);

	long count();

	<S extends Admin> boolean exists(Example<S> example);

	boolean existsById(Integer id);

	Optional<Admin> findById(Integer id);

	<S extends Admin> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends Admin> S saveAndFlush(S entity);

	List<Admin> findAllById(Iterable<Integer> ids);

	Page<Admin> findAll(Pageable pageable);

	List<Admin> findAll();

	<S extends Admin> S save(S entity);

}
