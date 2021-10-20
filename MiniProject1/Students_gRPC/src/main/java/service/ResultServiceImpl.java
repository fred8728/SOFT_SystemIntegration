package service;

import com.students_management.stubs.result.*;
import dao.ResultDao;
import domain.Result;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;

import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ResultServiceImpl extends ResultServiceGrpc.ResultServiceImplBase {
    private ResultDao resultDao = new ResultDao();
    private static final Logger logger = Logger.getLogger(ResultServiceImpl.class.getName());

    @Override
    public void getResultForStudent(ResultRequest request, StreamObserver<ResultResponse> responseObserver) {
        String studentId = request.getStudentId();

        try {
            Result result = resultDao.findById(studentId);

            ResultResponse resultResponse = ResultResponse.newBuilder()
                    .setStudentId(studentId)
                    .setSem(Semester.valueOf(result.getSemester()))
                    .setBilledkunst(Grade.valueOf(result.getBilledekunst()))
                    .setGeografi(Grade.valueOf(result.getGeografi()))
                    .setGeografi(Grade.valueOf(result.getHaendarbejde()))
                    .build();

            responseObserver.onNext(resultResponse);
            responseObserver.onCompleted();

        } catch (NoSuchElementException e) {
            logger.log(Level.SEVERE, "NO RESULT FOUND WITH THE STUDENT ID :- " + studentId);

            responseObserver.onError(Status.NOT_FOUND.asRuntimeException());

        }


    }
}