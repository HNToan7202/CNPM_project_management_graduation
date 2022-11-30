package vn.iotstar.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import vn.iotstar.Entity.LeaderLecture;

public interface ILeaderLectureService {

	void deleteAll();

	LeaderLecture getById(Long id);

	void delete(LeaderLecture entity);

	LeaderLecture getOne(Long id);

	void deleteById(Long id);

	long count();

	Optional<LeaderLecture> findById(Long id);

	List<LeaderLecture> findAll(Sort sort);

	Page<LeaderLecture> findAll(Pageable pageable);

	List<LeaderLecture> findAll();

	<S extends LeaderLecture> S save(S entity);

}
