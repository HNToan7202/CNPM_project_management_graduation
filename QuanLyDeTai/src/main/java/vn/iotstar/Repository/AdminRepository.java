package vn.iotstar.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.iotstar.Entity.Admin;
@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{

}
