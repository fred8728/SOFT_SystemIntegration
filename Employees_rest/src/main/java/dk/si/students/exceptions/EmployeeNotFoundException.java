package dk.si.students.exceptions;

public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException(String exception) {
        super(exception);
    }
}
