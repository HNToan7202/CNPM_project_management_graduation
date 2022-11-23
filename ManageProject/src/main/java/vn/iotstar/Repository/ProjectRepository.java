package vn.iotstar.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.iotstar.Entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, String> {
	
	//Tim kiem noi dung ten from account where email
	
	List<Project> findByIdContaining(String id);
	// Tìm kiếm và phân trang
	
	Page<Project> findByIdContaining(String id, Pageable pageable);
	Optional<Project> findById (String id);

}
