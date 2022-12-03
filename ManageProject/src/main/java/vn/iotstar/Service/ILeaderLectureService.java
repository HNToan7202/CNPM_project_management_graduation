package vn.iotstar.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import vn.iotstar.Entity.LeaderLecture;

public interface ILeaderLectureService {

	void deleteAll();

	void delete(LeaderLecture entity);

	void deleteById(Integer id);

	long count();

	Optional<LeaderLecture> findById(Integer id);

	List<LeaderLecture> findAllById(Iterable<Integer> ids);

	List<LeaderLecture> findAll(Sort sort);

	Page<LeaderLecture> findAll(Pageable pageable);

	List<LeaderLecture> findAll();

	<S extends LeaderLecture> S save(S entity);

	LeaderLecture findByEmailContaining(String email);

	//
	LeaderLecture findOneByName(String name);

	// Tìm kiếm và Phân trang

	Page<LeaderLecture> findByNameContaining(String name, Pageable pageable);

}
