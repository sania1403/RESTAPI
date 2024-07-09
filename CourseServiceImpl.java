package com.demo.service;

import java.util.List;

//import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.binding.Course;
import com.demo.repo.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository courseRepo;
	
	@Override
	public String upsert(Course course) {
	
		courseRepo.save(course);  //upsert(insert/update based on PRIMARY KEY)
		return "success";
	}

	@Override
	public Course getById(Integer cid) {
	java.util.Optional<Course> findById	=courseRepo.findById(cid);
	
		if(findById.isPresent()) {
			return findById.get();
		}
		
		return null;
	}

	@Override
	public List<Course> getAllCourses() {
		
		return courseRepo.findAll();
	}

	@Override
	public String deleteById(Integer cid) {
		if(courseRepo.existsById(cid))
		{
			courseRepo.deleteById(cid);
			return "Delete Success";
		}
		else
		{
			return "NO Record Found";
		}
		
	}

}
