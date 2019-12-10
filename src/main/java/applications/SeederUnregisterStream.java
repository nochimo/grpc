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
import io.grpc.dsproject.protobufGen.mSimpleRequest;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A simple client that requests a greeting from the {@link PortalSeedServer}.
 */
public class SeederUnregisterStream {
  private static final Logger logger = Logger.getLogger(SeederUnregisterStream.class.getName());

  private final ManagedChannel channel;
  private final PortalGrpc.PortalBlockingStub blockingStub;

  /** Construct client connecting to server at {@code host:port}. */
  public SeederUnregisterStream(String host, int port) {
    this(ManagedChannelBuilder.forAddress(host, port)
        // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
        // needing certificates.
        .usePlaintext()
        .build());
  }

  /** Construct client for accessing server using the existing channel. */
  SeederUnregisterStream(ManagedChannel channel) {
    this.channel = channel;
    blockingStub = PortalGrpc.newBlockingStub(channel);
  }

  public void shutdown() throws InterruptedException {
    channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
  }

  /** @param vp*/
  public void sendMessage(SeederUnregisterStream.VideoProperties vp) {
    System.out.println("Requesting Unregistration of Video: " + vp.streamName + " " + "...");
    //HelloRequest.newBuilder().setStreamName(vp.streamName).setEndPoint(vp.endPoint).setVideoSize(vp.videoSize).setBitRate(vp.bitRate).setKeywords(1,vp.keywords[0]).build();
    mSimpleRequest request = mSimpleRequest.newBuilder().setStreamName(vp.streamName).build();
    mReply response;
    try {
      response = blockingStub.unregisterVideo(request);
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

    public VideoProperties(String a) {
      streamName = a;
    }
  }

  public static void main(String[] args) throws Exception {


    SeederUnregisterStream client = new SeederUnregisterStream("localhost", 50052);
    VideoProperties vp = new VideoProperties("night_of_the_living_deaddasdas.mpeg");
    try {
      client.sendMessage(vp);
    }
    finally {
      client.shutdown();
    }
  }
}
