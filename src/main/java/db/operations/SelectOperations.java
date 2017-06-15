package db.operations;

import db.operations.select.*;

/**
 * Created by root on 15.06.17.
 */
public class SelectOperations {

    public static StudentSelectOperations
            student = new StudentSelectOperations();
    public static StudyGroupsSelectOperations
            study_groups = new StudyGroupsSelectOperations();
    public static CourseSelectOperations
            course = new CourseSelectOperations();
    public static SubjectSelectOperation
            subject = new SubjectSelectOperation();
    public static LabSelectOperation
            lab = new LabSelectOperation();
    public static JournalSelectOperation
            journal = new JournalSelectOperation();
    public static TeacherSelectOperation
            teacher = new TeacherSelectOperation();

}

