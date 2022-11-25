package vn.iotstar.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import vn.iotstar.Entity.Faculty;

public interface IFacultyService {

	void deleteAll();

	void delete(Faculty entity);

	void deleteById(Long id);

	long count();

	Optional<Faculty> findById(Long id);

	Page<Faculty> findAll(Pageable pageable);

	List<Faculty> findAll();

	<S extends Faculty> S save(S entity);

}
