package vn.iotstar.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.iotstar.Entity.Lecture;


@Repository
public interface LectureRepository extends JpaRepository<Lecture, Long>{

}
