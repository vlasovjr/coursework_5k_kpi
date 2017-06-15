package db;

import db.operations.SelectOperations;

/**
 * Created by root on 15.06.17.
 */
public class DB {
    private static DateBaseFrame frame = new DateBaseFrame();

    public static final String connectionURL = "jdbc:mysql://localhost:3306/vlasov_db";
    public static final String connectionUser = "java";
    public static final String connectionPassword = "vlasov";


    public static DateBaseFrame getFrame() {
        return frame;
    }

    public static SelectOperations SELECT = new SelectOperations();

    public static void loadDateBaseForStudent(int user_id){
        frame.getStudents().add(
                SELECT.student.ByUserId(user_id));
        frame.getStudy_groups().add(
                SELECT.study_groups.ByStudentEntity(frame.getStudents().last()));
        frame.getCourses().addAll(
                SELECT.course.ByGroupId(frame.getStudy_groups().last().getGroup_id()));
        frame.getSubjects().addAll(
                SELECT.subject.ByCoursesArray(frame.getCourses()));
        frame.getLabs().addAll(
                SELECT.lab.BySubjectsArray(frame.getSubjects()));
        frame.getJournals().addAll(
                SELECT.journal.ByStudentEntity(frame.getStudents().last()));
        frame.getTeachers().addAll(
                SELECT.teacher.BySubjectsArray(frame.getSubjects()));

        dateBinding();
    }

    public static void dateBinding(){

        frame.getCourses().forEach(f ->{
            f.setSubject(
                    frame.getSubjects()
                            .firstFind(s ->
                                    s.getSubject_id() == f.getSubject_id()));
            f.setStudy_group(
                    frame.getStudy_groups()
                            .firstFind(s ->
                                    s.getGroup_id() == f.getGroup_id()));
        });


        frame.getJournals().forEach(f -> {
            f.setLab(
                    frame.getLabs()
                            .firstFind(s ->
                                    s.getLab_id() == f.getLab_id()));
            f.setStudent(
                    frame.getStudents()
                            .firstFind(s ->
                                    s.getStudent_id() ==f.getStudent_id()));
        });


        frame.getLabs().forEach(f -> {
            f.setSubject(
                    frame.getSubjects()
                            .firstFind(s ->
                                    s.getSubject_id() == f.getSubject_id()));
            f.getJournals().addAll(
                    frame.getJournals()
                            .findAll(s ->
                                    s.getLab_id() == f.getLab_id()));
        });


        frame.getStudents().forEach(f -> {
            f.setStudy_group(
                    frame.getStudy_groups()
                            .firstFind(s ->
                                    s.getGroup_id() == f.getGroup_id()));
            f.getJournals().addAll(
                    frame.getJournals()
                            .findAll(s ->
                                    s.getStudent_id() == f.getStudent_id()));
        });


        frame.getStudy_groups().forEach(f -> {
            f.getCourses().addAll(
                    frame.getCourses()
                            .findAll(s ->
                                    s.getGroup_id() == f.getGroup_id()));
            f.getStudents().addAll(
                    frame.getStudents()
                            .findAll(s ->
                                    s.getGroup_id() == f.getGroup_id()));
        });


        frame.getSubjects().forEach(f -> {
            f.getCourses().addAll(
                    frame.getCourses()
                            .findAll(s ->
                                    s.getSubject_id() == f.getSubject_id()));
            f.getLabs().addAll(
                    frame.getLabs()
                            .findAll(s ->
                                    s.getSubject_id() == f.getSubject_id()));
            f.setTeachers(
                    frame.getTeachers()
                            .firstFind(s ->
                                    s.getTeacher_id() == f.getTeacher_id()));
        });


        frame.getTeachers().forEach(f ->
            f.getSubjects().addAll(
                    frame.getSubjects()
                            .findAll(s ->
                                    s.getTeacher_id() == f.getTeacher_id())));
    }
}

