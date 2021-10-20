
package client;

import com.students_management.stubs.result.ResultRequest;
import com.students_management.stubs.result.ResultResponse;
import com.students_management.stubs.result.ResultServiceGrpc;
import io.grpc.Channel;

import java.util.ArrayList;
import java.util.List;

public class ResultClient {
    private ResultServiceGrpc.ResultServiceBlockingStub resultServiceBlockingStub;

    public ResultClient(Channel channel){
        resultServiceBlockingStub = ResultServiceGrpc.newBlockingStub(channel);
    }

    public List<String> getResults(String studentId){
        ResultRequest resultRequest = ResultRequest.newBuilder().setStudentId(studentId).build();
        ResultResponse resultResponse = resultServiceBlockingStub.getResultForStudent(resultRequest);

        List<String> results = new ArrayList<>();
        results.add(resultResponse.getSem().toString());
        results.add(resultResponse.getBilledkunst().toString());
        results.add(resultResponse.getGeografi().toString());
        results.add(resultResponse.getHaendarbejde().toString());

        return results;
    }
}