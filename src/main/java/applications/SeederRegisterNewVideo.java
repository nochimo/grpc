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


import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.dsproject.protobufGen.PortalGrpc;
import io.grpc.dsproject.protobufGen.mReply;
import io.grpc.dsproject.protobufGen.mRequest;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A simple client that requests a greeting from the {@link PortalSeedServer}.
 */
public class SeederRegisterNewVideo {
  private static final Logger logger = Logger.getLogger(SeederRegisterNewVideo.class.getName());

  private final ManagedChannel channel;
  private final PortalGrpc.PortalBlockingStub blockingStub;

  /** Construct client connecting to server at {@code host:port}. */
  public SeederRegisterNewVideo(String host, int port) {
    this(ManagedChannelBuilder.forAddress(host, port)
        // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
        // needing certificates.
        .usePlaintext()
        .build());
  }

  /** Construct client for accessing server using the existing channel. */
  SeederRegisterNewVideo(ManagedChannel channel) {
    this.channel = channel;
    blockingStub = PortalGrpc.newBlockingStub(channel);
  }

  public void shutdown() throws InterruptedException {
    channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
  }

  /** @param vp*/
  public void sendMessage(SeederRegisterNewVideo.VideoProperties vp) {
    System.out.println("Requesting Registration of Video: " + vp.streamName + " " + "...");
    //HelloRequest.newBuilder().setStreamName(vp.streamName).setEndPoint(vp.endPoint).setVideoSize(vp.videoSize).setBitRate(vp.bitRate).setKeywords(1,vp.keywords[0]).build();
    mRequest request = mRequest.newBuilder().setStreamName(vp.streamName).setEndPoint(vp.endPoint).setVideoSize(vp.videoSize).setBitRate(vp.bitRate).setKeywords(vp.keywords).build();
    mReply response;
    try {
      response = blockingStub.registerVideo(request);
    } catch (StatusRuntimeException e) {
      logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
      return;
    }
    logger.info(response.getMessage());
  }
  public static class VideoProperties {
    public String streamName  = "";
    public String endPoint  = "";
    public String videoSize  = "";
    public int bitRate  = 0;
    public String keywords = "";
    //constructor
    public VideoProperties(String a, String b, String c, int d, String e) {
      streamName = a;
      endPoint = b;
      videoSize = c;
      bitRate = d;
      keywords = e;
    }
  }

  public static void main(String[] args) throws Exception {


    SeederRegisterNewVideo client = new SeederRegisterNewVideo("localhost", 50052);
    VideoProperties vp = new VideoProperties("night_of_the_living_deaddasdas.mpeg", "TCP:127.0.0.1:8000", "400x800", 80, "Comedy, Animation");
    try {
      client.sendMessage(vp);
    }
    finally {
      client.shutdown();
    }
  }
}
