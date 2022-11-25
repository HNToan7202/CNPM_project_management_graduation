package vn.iotstar.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.iotstar.Entity.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long>{
	
}
