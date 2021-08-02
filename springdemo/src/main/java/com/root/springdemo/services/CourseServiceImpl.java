package com.root.springdemo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.root.springdemo.models.Course;



@Service
public class CourseServiceImpl implements CourseService{

	private List<Course> list;
	
	 public CourseServiceImpl() 
	 {
		 list = new ArrayList<>();
		 list.add(new Course(145, 	"Java Core Course", "this course contains basics of java"));
		 list.add(new Course(4343, 	"Spring Boot Course", "Creating rest API using Spring Boot"));

	}
	 
	 
	public List<Course> getCourses() 
	{		
		return list;
	}
	
	public  Course  getCourseById(long courseId)
	{
		Course c = null;
		for (Course 	i:list) 
		{
			if (i.getId() == courseId) 
			{
				c=i;
				break;
			}
		}
		return c;
	}


	@Override
	public Course addCourse(Course course) {
		list.add(course);
		return course;
	}


	/*
	 * @Override public void updateCourse(Course course, long courseId) {
	 * 
	 * for (int i=0;i<list.size();i++) { Course c = list.get(i); if (c.getId() ==
	 * courseId) { list.set(i, course); return; } }
	 * 
	 * }
	 */
	 //OR
	@Override
	public Course updateCourse(Course course)
	{
		list.forEach(e ->{
			if(e.getId() == course.getId())
			{
				e.setTitle(course.getTitle());
				e.setDescription(course.getDescription());
			}
		});
		return course;
	}


	@Override
	public void deleteCourseById(long courseId) {
		for (int i=0;i<list.size();i++) 
		{
			Course c = list.get(i);
			if (c.getId() == courseId) 
			{
				 list.remove(i);
				return;
			}
		}
	}


	
}
