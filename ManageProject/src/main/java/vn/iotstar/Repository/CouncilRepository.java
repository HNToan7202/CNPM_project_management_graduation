package vn.iotstar.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.iotstar.Entity.Council;
import vn.iotstar.Entity.Project;

@Repository
public interface CouncilRepository extends JpaRepository<Council, Long >{
	
	List<Project> findByIdContaining(Long id);
	
	
	// Tìm kiếm và phân trang
	Page<Council> findByIdContaining(Long id, Pageable pageable);
	
	Optional<Council> findById (Long id);

}
