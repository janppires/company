package com.starlingbank.training.company.persistence;

import com.starlingbank.training.company.entities.Course;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InMemoryCoursePersistenceService {

  private int nextFreeCourseId = 0;

  private Map<Integer, Course> availableCourses; // courseId, Course
  private Map<Integer, List<Integer>> employeesCoursesEnrolled; // employeeId, List<courseId>

  public InMemoryCoursePersistenceService() {
    this.availableCourses = new HashMap<>();
    this.employeesCoursesEnrolled = new HashMap<>();
  }

  public void addNewCourse(String courseName, int duration) {
    int newCourseId = nextFreeCourseId++;
    availableCourses.put(newCourseId, new Course(newCourseId, courseName, duration));
  }

  public void enrollEmployeeToCourse(int courseId, int employeeId) {
    if(!availableCourses.containsKey(courseId)) {
      throw new IllegalStateException("Course not found!");
    }

    List<Integer> coursesIds = employeesCoursesEnrolled.computeIfAbsent(employeeId, k -> new ArrayList<>());
    coursesIds.add(courseId);
  }

  public List<Course> listCoursesByEmployee(int employeeId) {
    return employeesCoursesEnrolled
        .get(employeeId)
        .stream()
        .map(this::getCourse)
        .collect(Collectors.toList());
  }

  private Course getCourse(int courseId) {
    return availableCourses.get(courseId);
  }

  public List<Course> listCourses() {
    return new ArrayList<>(availableCourses.values());
  }

}
