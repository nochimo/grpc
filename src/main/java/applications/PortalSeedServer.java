/*
 * Copyright 2015 The gRPC Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package applications;


import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.dsproject.protobufGen.PortalGrpc;
import io.grpc.dsproject.protobufGen.mReply;
import io.grpc.dsproject.protobufGen.mRequest;
import io.grpc.dsproject.protobufGen.mSimpleRequest;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
import java.util.logging.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


/**
 * Server that manages startup/shutdown of a {@code Greeter} server.
 */
public class PortalSeedServer {
  private static final Logger logger = Logger.getLogger(PortalSeedServer.class.getName());

  private Server server;

  private void start() throws IOException {
    /* The port on which the server should run */
    int port = 50052;
    server = ServerBuilder.forPort(port)
        .addService(new PortalImpl())
        .build()
        .start();
    logger.info("Server started, listening on " + port);
    Runtime.getRuntime().addShutdownHook(new Thread() {
      @Override
      public void run() {
        // Use stderr here since the logger may have been reset by its JVM shutdown hook.
        System.err.println("*** shutting down gRPC server since JVM is shutting down");
        PortalSeedServer.this.stop();
        System.err.println("*** server shut down");
      }
    });
  }

  private void stop() {
    if (server != null) {
      server.shutdown();
    }
  }

  /**
   * Await termination on the main thread since the grpc library uses daemon threads.
   */
  private void blockUntilShutdown() throws InterruptedException {
    if (server != null) {
      server.awaitTermination();
    }
  }

  /**
   * Main launches the server from the command line.
   */
  public static void main(String[] args) throws IOException, InterruptedException {
    final PortalSeedServer server = new PortalSeedServer();
    server.start();
    server.blockUntilShutdown();
  }

  static class PortalImpl extends PortalGrpc.PortalImplBase {

    @Override
    public void registerVideo(mRequest req, StreamObserver<mReply> responseObserver) {
      boolean dbError = false;
      String exceptionMessage = "", replyMessage= "";

      System.out.println(req.getStreamName());
      //QuoteServer Mode
     {
         try{
           // create a mysql database connection
           String JDBC_DRIVER  = "com.mysql.cj.jdbc.Driver";
           String myUrl = "jdbc:mysql://localhost:3306/?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
         Class.forName(JDBC_DRIVER);
         System.out.print("\nConnecting to database...");
         Connection conn = DriverManager.getConnection(myUrl, "root", "root");
         System.out.println(" Connected!\n");
         String[] arrayEndPoint = req.getEndPoint().split(":",3);


         // the mysql insert statement
         String query = " insert into myschema.seeder (streamName, protocol, ip, port, bitrate, keywords)"
                                                         + "values ('"
                                                         + req.getStreamName() + "', '"
                                                         + arrayEndPoint[0]    + "', '"
                                                         + arrayEndPoint[1]    + "', '"
                                                         + arrayEndPoint[2]    + "', "
                                                         + req.getBitRate()    + ", '"
                                                         + req.getKeywords()   + "');";

         // create the mysql insert preparedstatement
         PreparedStatement preparedStmt = conn.prepareStatement(query);

         // execute the preparedstatement
           // preparedStmt.execute();
         System.out.println(preparedStmt.executeUpdate() + " Row(s) Inserted!\n");
         System.out.println("Closing DB Connection\n");
           conn.close();
           System.out.println("Connection Closed\n");
       }
    catch (Exception e) {
      dbError = true;
      exceptionMessage = e.getMessage();
      System.err.print("ERROR: MySQL exception! - ");
      System.err.println(e.getMessage());
    }
       mReply reply;
         if (dbError == true) {
          replyMessage = ("ERROR While inserting data on Database, detail: " + exceptionMessage);
         } else {
           replyMessage = ("Hi Client, I'm the Server, new Video Registered Successfully, " +
                   "StreamName: " + req.getStreamName() + ", " +
                   "EndPoint: " + req.getEndPoint() + ", " +
                   "VideoSize: " + req.getVideoSize() + ", " +
                   "Bitrate: " + req.getBitRate() + ", " +
                   "Keywords: " + req.getKeywords());

         }
         reply = mReply.newBuilder().setMessage(replyMessage).build();
         responseObserver.onNext(reply);
         responseObserver.onCompleted();
     }
    }

    @Override
    public void unregisterVideo(mSimpleRequest req, StreamObserver<mReply> responseObserver) {
      boolean dbError = false;
      String exceptionMessage = "", replyMessage= "";

      System.out.println(req.getStreamName());
      //QuoteServer Mode
      {
        try{
          // create a mysql database connection
          String JDBC_DRIVER  = "com.mysql.cj.jdbc.Driver";
          String myUrl = "jdbc:mysql://localhost:3306/?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
          Class.forName(JDBC_DRIVER);
          System.out.print("\nConnecting to database...");
          Connection conn = DriverManager.getConnection(myUrl, "root", "root");
          System.out.println(" Connected!\n");
          // the mysql insert statement
          String query = " delete from myschema.seeder WHERE streamName = '"+ req.getStreamName() + "';";
          // create the mysql insert preparedstatement
          PreparedStatement preparedStmt = conn.prepareStatement(query);

          // execute the preparedstatement
          // preparedStmt.execute();
          System.out.println(preparedStmt.executeUpdate() + " Row(s) Deleted!\n");
          System.out.println("Closing DB Connection\n");
          conn.close();
          System.out.println("Connection Closed\n");
        }
        catch (Exception e) {
          dbError = true;
          exceptionMessage = e.getMessage();
          System.err.print("ERROR: MySQL exception! - ");
          System.err.println(e.getMessage());
        }
        mReply reply;
        if (dbError == true) {
          replyMessage = ("ERROR While inserting data on Database, detail: " + exceptionMessage);
        } else {
          replyMessage = ("Hi Seed, I'm the Server,  Video Unregistered Successfully, " +
                  "StreamName: " + req.getStreamName());

        }
        reply = mReply.newBuilder().setMessage(replyMessage).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
      }
    }

  }
}

