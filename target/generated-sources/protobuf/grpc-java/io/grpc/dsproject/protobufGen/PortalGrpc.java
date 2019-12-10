package io.grpc.dsproject.protobufGen;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * The  service definition.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.24.0)",
    comments = "Source: dsProject.proto")
public final class PortalGrpc {

  private PortalGrpc() {}

  public static final String SERVICE_NAME = "Portal";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<io.grpc.dsproject.protobufGen.mRequest,
      io.grpc.dsproject.protobufGen.mReply> getRegisterVideoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RegisterVideo",
      requestType = io.grpc.dsproject.protobufGen.mRequest.class,
      responseType = io.grpc.dsproject.protobufGen.mReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.grpc.dsproject.protobufGen.mRequest,
      io.grpc.dsproject.protobufGen.mReply> getRegisterVideoMethod() {
    io.grpc.MethodDescriptor<io.grpc.dsproject.protobufGen.mRequest, io.grpc.dsproject.protobufGen.mReply> getRegisterVideoMethod;
    if ((getRegisterVideoMethod = PortalGrpc.getRegisterVideoMethod) == null) {
      synchronized (PortalGrpc.class) {
        if ((getRegisterVideoMethod = PortalGrpc.getRegisterVideoMethod) == null) {
          PortalGrpc.getRegisterVideoMethod = getRegisterVideoMethod =
              io.grpc.MethodDescriptor.<io.grpc.dsproject.protobufGen.mRequest, io.grpc.dsproject.protobufGen.mReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RegisterVideo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.dsproject.protobufGen.mRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.dsproject.protobufGen.mReply.getDefaultInstance()))
              .setSchemaDescriptor(new PortalMethodDescriptorSupplier("RegisterVideo"))
              .build();
        }
      }
    }
    return getRegisterVideoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.grpc.dsproject.protobufGen.mSimpleRequest,
      io.grpc.dsproject.protobufGen.mReply> getUnregisterVideoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UnregisterVideo",
      requestType = io.grpc.dsproject.protobufGen.mSimpleRequest.class,
      responseType = io.grpc.dsproject.protobufGen.mReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.grpc.dsproject.protobufGen.mSimpleRequest,
      io.grpc.dsproject.protobufGen.mReply> getUnregisterVideoMethod() {
    io.grpc.MethodDescriptor<io.grpc.dsproject.protobufGen.mSimpleRequest, io.grpc.dsproject.protobufGen.mReply> getUnregisterVideoMethod;
    if ((getUnregisterVideoMethod = PortalGrpc.getUnregisterVideoMethod) == null) {
      synchronized (PortalGrpc.class) {
        if ((getUnregisterVideoMethod = PortalGrpc.getUnregisterVideoMethod) == null) {
          PortalGrpc.getUnregisterVideoMethod = getUnregisterVideoMethod =
              io.grpc.MethodDescriptor.<io.grpc.dsproject.protobufGen.mSimpleRequest, io.grpc.dsproject.protobufGen.mReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UnregisterVideo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.dsproject.protobufGen.mSimpleRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.dsproject.protobufGen.mReply.getDefaultInstance()))
              .setSchemaDescriptor(new PortalMethodDescriptorSupplier("UnregisterVideo"))
              .build();
        }
      }
    }
    return getUnregisterVideoMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PortalStub newStub(io.grpc.Channel channel) {
    return new PortalStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PortalBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new PortalBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PortalFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new PortalFutureStub(channel);
  }

  /**
   * <pre>
   * The  service definition.
   * </pre>
   */
  public static abstract class PortalImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Sends a message
     * </pre>
     */
    public void registerVideo(io.grpc.dsproject.protobufGen.mRequest request,
        io.grpc.stub.StreamObserver<io.grpc.dsproject.protobufGen.mReply> responseObserver) {
      asyncUnimplementedUnaryCall(getRegisterVideoMethod(), responseObserver);
    }

    /**
     */
    public void unregisterVideo(io.grpc.dsproject.protobufGen.mSimpleRequest request,
        io.grpc.stub.StreamObserver<io.grpc.dsproject.protobufGen.mReply> responseObserver) {
      asyncUnimplementedUnaryCall(getUnregisterVideoMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getRegisterVideoMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                io.grpc.dsproject.protobufGen.mRequest,
                io.grpc.dsproject.protobufGen.mReply>(
                  this, METHODID_REGISTER_VIDEO)))
          .addMethod(
            getUnregisterVideoMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                io.grpc.dsproject.protobufGen.mSimpleRequest,
                io.grpc.dsproject.protobufGen.mReply>(
                  this, METHODID_UNREGISTER_VIDEO)))
          .build();
    }
  }

  /**
   * <pre>
   * The  service definition.
   * </pre>
   */
  public static final class PortalStub extends io.grpc.stub.AbstractStub<PortalStub> {
    private PortalStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PortalStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PortalStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PortalStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a message
     * </pre>
     */
    public void registerVideo(io.grpc.dsproject.protobufGen.mRequest request,
        io.grpc.stub.StreamObserver<io.grpc.dsproject.protobufGen.mReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRegisterVideoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void unregisterVideo(io.grpc.dsproject.protobufGen.mSimpleRequest request,
        io.grpc.stub.StreamObserver<io.grpc.dsproject.protobufGen.mReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUnregisterVideoMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The  service definition.
   * </pre>
   */
  public static final class PortalBlockingStub extends io.grpc.stub.AbstractStub<PortalBlockingStub> {
    private PortalBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PortalBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PortalBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PortalBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a message
     * </pre>
     */
    public io.grpc.dsproject.protobufGen.mReply registerVideo(io.grpc.dsproject.protobufGen.mRequest request) {
      return blockingUnaryCall(
          getChannel(), getRegisterVideoMethod(), getCallOptions(), request);
    }

    /**
     */
    public io.grpc.dsproject.protobufGen.mReply unregisterVideo(io.grpc.dsproject.protobufGen.mSimpleRequest request) {
      return blockingUnaryCall(
          getChannel(), getUnregisterVideoMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The  service definition.
   * </pre>
   */
  public static final class PortalFutureStub extends io.grpc.stub.AbstractStub<PortalFutureStub> {
    private PortalFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PortalFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PortalFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PortalFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a message
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grpc.dsproject.protobufGen.mReply> registerVideo(
        io.grpc.dsproject.protobufGen.mRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getRegisterVideoMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grpc.dsproject.protobufGen.mReply> unregisterVideo(
        io.grpc.dsproject.protobufGen.mSimpleRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUnregisterVideoMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_REGISTER_VIDEO = 0;
  private static final int METHODID_UNREGISTER_VIDEO = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PortalImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PortalImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REGISTER_VIDEO:
          serviceImpl.registerVideo((io.grpc.dsproject.protobufGen.mRequest) request,
              (io.grpc.stub.StreamObserver<io.grpc.dsproject.protobufGen.mReply>) responseObserver);
          break;
        case METHODID_UNREGISTER_VIDEO:
          serviceImpl.unregisterVideo((io.grpc.dsproject.protobufGen.mSimpleRequest) request,
              (io.grpc.stub.StreamObserver<io.grpc.dsproject.protobufGen.mReply>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class PortalBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PortalBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return io.grpc.dsproject.protobufGen.dsProjectProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Portal");
    }
  }

  private static final class PortalFileDescriptorSupplier
      extends PortalBaseDescriptorSupplier {
    PortalFileDescriptorSupplier() {}
  }

  private static final class PortalMethodDescriptorSupplier
      extends PortalBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PortalMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (PortalGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PortalFileDescriptorSupplier())
              .addMethod(getRegisterVideoMethod())
              .addMethod(getUnregisterVideoMethod())
              .build();
        }
      }
    }
    return result;
  }
}
