package service;

import client.ResultClient;
import com.students_management.stubs.student.*;
import dao.StudentDao;
import domain.Student;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentServiceImpl extends StudentServiceGrpc.StudentServiceImplBase {
    private StudentDao studentDao = new StudentDao();
    private static final Logger logger = Logger.getLogger(StudentServiceImpl.class.getName());

    @Override
    public void getStudentInfo(StudentRequest request, StreamObserver<StudentResponse> responseObserver) {
        String studentId = request.getStudentId();

        try{
            Student student = studentDao.findById(studentId);
            List<String> resultResponse = getResults(studentId);
            StudentResponse studentResponse = StudentResponse.newBuilder()
                    .setStudentId(studentId)
                    .setName(student.getName())
                    .setAge(student.getAge())
                    .setGender(Gender.valueOf(student.getGender()))
                    .setSem(Semester.valueOf(resultResponse.get(0)))
                    .setBilledkunst(Grade.valueOf(resultResponse.get(1)))
                    .setGeografi(Grade.valueOf(resultResponse.get(2)))
                    .setGeografi(Grade.valueOf(resultResponse.get(3)))

                    .build();

            responseObserver.onNext(studentResponse);
            responseObserver.onCompleted();
        }catch (NoSuchElementException e){
            logger.log(Level.SEVERE, "NO STUDENT FOUND WITH THE STUDENT ID :- "+studentId);

            responseObserver.onError(Status.NOT_FOUND.asRuntimeException());
        }
    }

    public List<String> getResults(String studentId){

        ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:8080")
                .usePlaintext()
                .build();

        ResultClient resultClient = new ResultClient(channel);

        return resultClient.getResults(studentId);
    }
}