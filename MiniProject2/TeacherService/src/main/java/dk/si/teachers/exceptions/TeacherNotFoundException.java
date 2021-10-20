package dk.si.teachers.exceptions;

public class TeacherNotFoundException extends RuntimeException{
    public TeacherNotFoundException(String exception) {
        super(exception);
    }
}
