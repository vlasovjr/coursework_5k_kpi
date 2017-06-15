package entity;

import utilits.MyArray;

import java.util.ArrayList;

/**
 * Created by root on 15.06.17.
 */
public class Study_groups {
    private int group_id;
    private String group_name;

    private MyArray<Student> students = new MyArray<Student>();
    private MyArray<Course> courses = new MyArray<Course>();

    public MyArray<Course> getCourses() {
        return courses;
    }

    public MyArray<Student> getStudents() {
        return students;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

    public int getGroup_id() {
        return group_id;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }
}
