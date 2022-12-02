package vn.iotstar.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.iotstar.Entity.LeaderLecture;

@Repository
public interface LeaderLectureRepository extends JpaRepository<LeaderLecture, Integer> {

	// Tìm Kiếm theo nội dung tên from category where Categoryname

	LeaderLecture findByEmailContaining(String email);

	//
	LeaderLecture findOneByName(String name);

	// Tìm kiếm và Phân trang

	Page<LeaderLecture> findByNameContaining(String name, Pageable pageable);

}
