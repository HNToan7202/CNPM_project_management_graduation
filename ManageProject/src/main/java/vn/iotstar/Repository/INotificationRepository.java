package vn.iotstar.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.iotstar.Entity.Notification;

@Repository
public interface INotificationRepository extends JpaRepository<Notification, Long> {
	List<Notification> findByIdstudent(Long idstudent);

	List<Notification> findByChosv(Boolean check);
}
