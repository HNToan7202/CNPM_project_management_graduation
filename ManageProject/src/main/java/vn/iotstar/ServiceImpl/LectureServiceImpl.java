package vn.iotstar.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import vn.iotstar.Entity.Lecture;
import vn.iotstar.Repository.LectureRepository;
import vn.iotstar.Service.LectureService;

@Service
public class LectureServiceImpl implements LectureService{

	@Autowired
	private LectureRepository lectureRepo;

	public <S extends Lecture> S save(S entity) {
		return lectureRepo.save(entity);
	}

	public List<Lecture> findAll() {
		return lectureRepo.findAll();
	}

	public Page<Lecture> findAll(Pageable pageable) {
		return lectureRepo.findAll(pageable);
	}

	public List<Lecture> findAll(Sort sort) {
		return lectureRepo.findAll(sort);
	}

	public <S extends Lecture> S saveAndFlush(S entity) {
		return lectureRepo.saveAndFlush(entity);
	}

	public <S extends Lecture> Page<S> findAll(Example<S> example, Pageable pageable) {
		return lectureRepo.findAll(example, pageable);
	}


	
}
