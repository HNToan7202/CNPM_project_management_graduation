package vn.iotstar.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.iotstar.Entity.Timeresgiter;
@Repository
public interface ITimeResgiterRepository extends JpaRepository<Timeresgiter, Long>{

}
