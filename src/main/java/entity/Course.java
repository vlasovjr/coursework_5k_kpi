package entity;

/**
 * Created by root on 15.06.17.
 */
public class Course {
    private int course_id;
    private int group_id;
    private int subject_id;

    private Study_groups study_group;
    private Subject subject;

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Study_groups getStudy_group() {
        return study_group;
    }

    public void setStudy_group(Study_groups study_group) {
        this.study_group = study_group;
    }

    public int getCourse_id(){
        return course_id;
    }

    public int getGroup_id() {
        return group_id;
    }

    public int getSubject_id() {
        return subject_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }
}
