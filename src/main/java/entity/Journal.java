package entity;

/**
 * Created by root on 15.06.17.
 */
public class Journal {
    private String rating;
    private int jurnal_id;
    private int student_id;
    private int lab_id;

    private Lab lab;
    private Student student;

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setLab_id(int lab_id) {
        this.lab_id = lab_id;
    }

    public int getLab_id() {
        return lab_id;
    }

    public int getJurnal_id() {
        return jurnal_id;
    }

    public Lab getLab() {
        return lab;
    }

    public String getRating() {
        return rating;
    }

    public Student getStudent() {
        return student;
    }

    public void setJurnal_id(int jurnal_id) {
        this.jurnal_id = jurnal_id;
    }

    public void setLab(Lab lab) {
        this.lab = lab;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
