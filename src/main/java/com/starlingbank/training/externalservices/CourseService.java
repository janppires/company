package com.starlingbank.training.externalservices;

import com.starlingbank.training.company.entities.Course;
import com.starlingbank.training.company.persistence.InMemoryCoursePersistenceService;
import java.util.List;

public class CourseService {

  private final InMemoryCoursePersistenceService coursePersistenceService;

  public CourseService(InMemoryCoursePersistenceService coursePersistenceService) {
    this.coursePersistenceService = coursePersistenceService;
  }

  public void addNewCourse(String courseName, int duration) {
    coursePersistenceService.addNewCourse(courseName, duration);
  }

  public List<String> listEmployeeCoursesNames(int employeeId) {
    return null;
  }

  public List<Course> listCourses() {
    return coursePersistenceService.listCourses();
  }

  public void enrollEmployeeToCourse(int employeeId, int courseId) {
    coursePersistenceService.enrollEmployeeToCourse(courseId, employeeId);
  }
}
