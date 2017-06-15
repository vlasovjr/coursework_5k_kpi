package entity;

import utilits.MyArray;

import java.util.ArrayList;

/**
 * Created by root on 15.06.17.
 */
public class Subject {
    private int subject_id;
    private String subject_name;
    private int teacher_id;

    private MyArray<Lab> labs = new MyArray<Lab>();
    private MyArray<Course> courses = new MyArray<Course>();
    private Teachers teachers;

    public void setTeachers(Teachers teachers) {
        this.teachers = teachers;
    }

    public Teachers getTeachers() {
        return teachers;
    }

    public MyArray<Course> getCourses() {
        return courses;
    }

    public MyArray<Lab> getLabs() {
        return labs;
    }

    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }

    public int getSubject_id() {
        return subject_id;
    }

    public int getTeacher_id() {
        return teacher_id;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }
}
