package vn.iotstar.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import vn.iotstar.Entity.Council;
import vn.iotstar.Entity.Project;

public interface ICouncilService {

	void deleteAll();

	Council getById(Long id);

	void delete(Council entity);

	void deleteById(Long id);

	long count();

	Optional<Council> findById(Long id);

	List<Council> findAll(Sort sort);

	Page<Council> findAll(Pageable pageable);

	List<Council> findAll();

	<S extends Council> S save(S entity);
	
	// Tìm kiếm và phân trang
	Page<Council> findByIdContaining(Long id, Pageable pageable);
	
	List<Project> findByIdContaining(Long id);

}
