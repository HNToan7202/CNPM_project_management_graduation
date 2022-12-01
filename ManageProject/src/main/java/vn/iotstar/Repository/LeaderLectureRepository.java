package vn.iotstar.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.iotstar.Entity.LeaderLecture;

@Repository
public interface LeaderLectureRepository extends JpaRepository<LeaderLecture, Integer >{

}
