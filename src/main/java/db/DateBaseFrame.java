package db;

import entity.*;
import utilits.MyArray;


import java.util.ArrayList;

/**
 * Created by root on 15.06.17.
 */
public class DateBaseFrame {
    private MyArray<Course> courses = new MyArray<>();
    private MyArray<Journal> journals = new MyArray<>();
    private MyArray<Lab> labs = new MyArray<>();
    private MyArray<Student> students = new MyArray<>();
    private MyArray<Study_groups> study_groups =new MyArray<>();
    private MyArray<Subject> subjects = new MyArray<>();
    private MyArray<Teachers> teachers = new MyArray<>();

    public MyArray<Course> getCourses() {
        return courses;
    }

    public MyArray<Journal> getJournals() {
        return journals;
    }

    public MyArray<Lab> getLabs() {
        return labs;
    }

    public MyArray<Subject> getSubjects() {
        return subjects;
    }

    public MyArray<Student> getStudents() {
        return students;
    }

    public MyArray<Study_groups> getStudy_groups() {
        return study_groups;
    }

    public MyArray<Teachers> getTeachers() {
        return teachers;
    }
}
