package vn.iotstar.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.iotstar.Entity.Lecture;

public interface LectureRepository  extends JpaRepository<Lecture, Integer>{

}
