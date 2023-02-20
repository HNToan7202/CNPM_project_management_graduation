package vn.iotstar.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import vn.iotstar.Entity.Notification;
import vn.iotstar.Repository.INotificationRepository;
import vn.iotstar.Service.INotificationService;

@Service
public class NotificationServiceImpl implements INotificationService {

	@Autowired

	INotificationRepository notificationRepository;

	@Override
	public List<Notification> findByIdstudent(Long idstudent) {
		return notificationRepository.findByIdstudent(idstudent);
	}

	@Override
	public List<Notification> findByChosv(Boolean check) {
		return notificationRepository.findByChosv(check);
	}

	@Override
	public <S extends Notification> S save(S entity) {
		return notificationRepository.save(entity);
	}

	@Override
	public List<Notification> findAll() {
		return notificationRepository.findAll();
	}

	@Override
	public Page<Notification> findAll(Pageable pageable) {
		return notificationRepository.findAll(pageable);
	}

	@Override
	public List<Notification> findAll(Sort sort) {
		return notificationRepository.findAll(sort);
	}

	@Override
	public Optional<Notification> findById(Long id) {
		return notificationRepository.findById(id);
	}

	@Override
	public long count() {
		return notificationRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		notificationRepository.deleteById(id);
	}

	@Override
	public Notification getById(Long id) {
		return notificationRepository.getById(id);
	}

	@Override
	public void deleteAll() {
		notificationRepository.deleteAll();
	}

}
