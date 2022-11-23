package vn.iotstar.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.iotstar.Entity.Faculty;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {

}
