package entity;

import utilits.MyArray;

import java.util.ArrayList;

/**
 * Created by root on 15.06.17.
 */
public class Lab {
    private int lab_id;
    private String lab_name;
    private String lab_body;
    private int subject_id;

    private MyArray<Journal> journals = new MyArray<Journal>();
    private Subject subject;

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Subject getSubject() {
        return subject;
    }

    public MyArray<Journal> getJournals() {
        return journals;
    }

    public int getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }

    public int getLab_id() {
        return lab_id;
    }

    public String getLab_body() {
        return lab_body;
    }

    public String getLab_name() {
        return lab_name;
    }

    public void setLab_body(String lab_body) {
        this.lab_body = lab_body;
    }

    public void setLab_id(int lab_id) {
        this.lab_id = lab_id;
    }

    public void setLab_name(String lab_name) {
        this.lab_name = lab_name;
    }
}
