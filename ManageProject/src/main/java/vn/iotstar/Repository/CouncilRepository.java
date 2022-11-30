package vn.iotstar.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.iotstar.Entity.Council;

@Repository
public interface CouncilRepository extends JpaRepository<Council, Long >{

}
