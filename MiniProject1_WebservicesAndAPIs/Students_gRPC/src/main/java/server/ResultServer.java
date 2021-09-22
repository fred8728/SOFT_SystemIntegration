package server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import service.ResultServiceImpl;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ResultServer {
    // Let's use a logger to log everything that we want
    private static final Logger logger = Logger.getLogger(ResultServer.class.getName());

    // The good old main method is defined here :)
    public static void main(String[] args) {

        Server server = ServerBuilder.forPort(8080)
                .addService(new ResultServiceImpl())
                .build();

        try {
            server.start();
            logger.log(Level.INFO, "RESULT SERVER STARTED ON PORT 8080");

            // This awaitTermination method will help to remain the server, otherwise the server will shutdown quickly
            server.awaitTermination();
        } catch (IOException e) {
            logger.log(Level.SEVERE, "RESULT SERVER DID NOT START");
        } catch (InterruptedException e) {
            logger.log(Level.SEVERE, "SERVER SHUT DOWN ON INTERRUPTED");
        }

    }
}