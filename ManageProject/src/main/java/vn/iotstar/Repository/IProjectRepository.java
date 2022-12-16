package vn.iotstar.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.iotstar.Entity.Project;

@Repository
public interface IProjectRepository extends JpaRepository<Project, Long> {
	// Tim kiem noi dung ten from account where email

	List<Project> findByIdContaining(Long id);

	// Tìm kiếm và phân trang
	Page<Project> findByIdContaining(Long id, Pageable pageable);

	Page<Project> findByNameContaining(String name, Pageable pageable);

	Optional<Project> findById(Long id);

	List<Project> findByIdlecture(Long id);

}
