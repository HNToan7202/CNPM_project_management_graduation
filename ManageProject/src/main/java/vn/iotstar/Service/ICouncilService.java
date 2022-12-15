package vn.iotstar.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import vn.iotstar.Entity.Council;
import vn.iotstar.Entity.Project;

public interface ICouncilService {

	void deleteAll();

	Council getById(Integer id);

	void delete(Council entity);

	Council getOne(Integer id);

	void deleteById(Integer id);

	long count();

	Optional<Council> findById(Integer id);

	List<Council> findAllById(Iterable<Integer> ids);

	List<Council> findAll();

	<S extends Council> Optional<S> findOne(Example<S> example);

	<S extends Council> S save(S entity);

	Page<Council> findByIdContaining(Integer id, Pageable pageable);

}
