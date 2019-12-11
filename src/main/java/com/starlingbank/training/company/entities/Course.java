package com.starlingbank.training.company.entities;

public class Course {

  private final int courseId;
  private final String courseName;
  private final int duration;

  public Course(int courseId, String courseName, int duration) {

    this.courseId = courseId;
    this.courseName = courseName;
    this.duration = duration;
  }

  public int getCourseId() {
    return courseId;
  }

  public String getCourseName() {
    return courseName;
  }

  public int getDuration() {
    return duration;
  }
}
