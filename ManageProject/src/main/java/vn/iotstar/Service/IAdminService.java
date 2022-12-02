package vn.iotstar.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import vn.iotstar.Entity.Admin;

public interface IAdminService {

	void deleteAll();

	Admin getById(Long id);

	void delete(Admin entity);

	void deleteById(Long id);

	long count();

	Optional<Admin> findById(Long id);

	List<Admin> findAll(Sort sort);

	Page<Admin> findAll(Pageable pageable);

	List<Admin> findAll();

	<S extends Admin> S save(S entity);

	Admin findByEmailContaining(String email);



}
