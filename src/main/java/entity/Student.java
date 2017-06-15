package entity;

import utilits.MyArray;

import java.util.ArrayList;

/**
 * Created by root on 15.06.17.
 */
public class Student {
    private int student_id;
    private int user_id;
    private int group_id;
    private String student_name;

    private Study_groups study_group;
    private MyArray<Journal> journals = new MyArray<Journal>();

    public MyArray<Journal> getJournals() {
        return journals;
    }

    public void setStudy_group(Study_groups study_group) {
        this.study_group = study_group;
    }

    public Study_groups getStudy_group() {
        return study_group;
    }

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
