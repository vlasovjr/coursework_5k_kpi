package entity;

import utilits.MyArray;

import java.util.ArrayList;

/**
 * Created by root on 15.06.17.
 */
public class Teachers {
    private int teacher_id;
    private int user_id;
    private String teacher_name;

    private MyArray<Subject> subjects = new MyArray<Subject>();

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    public int getTeacher_id() {
        return teacher_id;
    }

    public MyArray<Subject> getSubjects() {
        return subjects;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }
}
