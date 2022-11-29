package vn.iotstar.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.iotstar.Entity.Role;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Integer>{

}
