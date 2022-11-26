package vn.iotstar.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.iotstar.Entity.Lecture;

@Repository

public interface LectureRepository extends JpaRepository<Lecture, Long>{

	//Tìm Kiếm theo nội dung tên from category where Categoryname

	List<Lecture> findByLectureNameContaining(String name);

	//
	Lecture findOneBylectureName(String name);

	//Tìm kiếm và Phân trang

	Page<Lecture> findBylectureNameontaining(String name,Pageable pageable);
}
