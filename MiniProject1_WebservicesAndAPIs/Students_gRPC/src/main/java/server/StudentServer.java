package server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import service.StudentServiceImpl;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentServer {
    private static final Logger logger = Logger.getLogger(ResultServer.class.getName());

    public static void main(String[] args) {
        Server server = ServerBuilder.forPort(8081)
                .addService(new StudentServiceImpl())
                .build();

        try {
            server.start();
            logger.log(Level.INFO, "RESULT SERVER STARTED ON PORT 8081");
            server.awaitTermination();
        } catch (IOException e) {
            logger.log(Level.SEVERE, "RESULT SERVER DID NOT START");
        } catch (InterruptedException e) {
            logger.log(Level.SEVERE, "SERVER SHUT DOWN ON INTERRUPTED");
        }

    }
}