// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: datanode.proto

package com.dfs.common.model.datanode;

/**
 * Protobuf type {@code com.ruyuan.dfs.common.proto.RegisterRequest}
 */
public  final class RegisterRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.ruyuan.dfs.common.proto.RegisterRequest)
        RegisterRequestOrBuilder {
  // Use RegisterRequest.newBuilder() to construct.
  private RegisterRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private RegisterRequest() {
    hostname_ = "";
    nioPort_ = 0;
    httpPort_ = 0;
    storedDataSize_ = 0L;
    freeSpace_ = 0L;
    nodeId_ = 0;
  }

  @Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private RegisterRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    int mutable_bitField0_ = 0;
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!input.skipField(tag)) {
              done = true;
            }
            break;
          }
          case 10: {
            String s = input.readStringRequireUtf8();

            hostname_ = s;
            break;
          }
          case 16: {

            nioPort_ = input.readInt32();
            break;
          }
          case 24: {

            httpPort_ = input.readInt32();
            break;
          }
          case 32: {

            storedDataSize_ = input.readInt64();
            break;
          }
          case 40: {

            freeSpace_ = input.readInt64();
            break;
          }
          case 48: {

            nodeId_ = input.readInt32();
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.dfs.common.model.datanode.Datanode.internal_static_com_ruyuan_dfs_common_proto_RegisterRequest_descriptor;
  }

  protected FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.dfs.common.model.datanode.Datanode.internal_static_com_ruyuan_dfs_common_proto_RegisterRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.dfs.common.model.datanode.RegisterRequest.class, com.dfs.common.model.datanode.RegisterRequest.Builder.class);
  }

  public static final int HOSTNAME_FIELD_NUMBER = 1;
  private volatile Object hostname_;
  /**
   * <code>optional string hostname = 1;</code>
   */
  public String getHostname() {
    Object ref = hostname_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      hostname_ = s;
      return s;
    }
  }
  /**
   * <code>optional string hostname = 1;</code>
   */
  public com.google.protobuf.ByteString
      getHostnameBytes() {
    Object ref = hostname_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      hostname_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int NIOPORT_FIELD_NUMBER = 2;
  private int nioPort_;
  /**
   * <code>optional int32 nioPort = 2;</code>
   */
  public int getNioPort() {
    return nioPort_;
  }

  public static final int HTTPPORT_FIELD_NUMBER = 3;
  private int httpPort_;
  /**
   * <code>optional int32 httpPort = 3;</code>
   */
  public int getHttpPort() {
    return httpPort_;
  }

  public static final int STOREDDATASIZE_FIELD_NUMBER = 4;
  private long storedDataSize_;
  /**
   * <code>optional int64 storedDataSize = 4;</code>
   */
  public long getStoredDataSize() {
    return storedDataSize_;
  }

  public static final int FREESPACE_FIELD_NUMBER = 5;
  private long freeSpace_;
  /**
   * <code>optional int64 freeSpace = 5;</code>
   */
  public long getFreeSpace() {
    return freeSpace_;
  }

  public static final int NODEID_FIELD_NUMBER = 6;
  private int nodeId_;
  /**
   * <code>optional int32 nodeId = 6;</code>
   */
  public int getNodeId() {
    return nodeId_;
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getHostnameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, hostname_);
    }
    if (nioPort_ != 0) {
      output.writeInt32(2, nioPort_);
    }
    if (httpPort_ != 0) {
      output.writeInt32(3, httpPort_);
    }
    if (storedDataSize_ != 0L) {
      output.writeInt64(4, storedDataSize_);
    }
    if (freeSpace_ != 0L) {
      output.writeInt64(5, freeSpace_);
    }
    if (nodeId_ != 0) {
      output.writeInt32(6, nodeId_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getHostnameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, hostname_);
    }
    if (nioPort_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, nioPort_);
    }
    if (httpPort_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, httpPort_);
    }
    if (storedDataSize_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(4, storedDataSize_);
    }
    if (freeSpace_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(5, freeSpace_);
    }
    if (nodeId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(6, nodeId_);
    }
    memoizedSize = size;
    return size;
  }

  private static final long serialVersionUID = 0L;
  @Override
  public boolean equals(final Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.dfs.common.model.datanode.RegisterRequest)) {
      return super.equals(obj);
    }
    com.dfs.common.model.datanode.RegisterRequest other = (com.dfs.common.model.datanode.RegisterRequest) obj;

    boolean result = true;
    result = result && getHostname()
        .equals(other.getHostname());
    result = result && (getNioPort()
        == other.getNioPort());
    result = result && (getHttpPort()
        == other.getHttpPort());
    result = result && (getStoredDataSize()
        == other.getStoredDataSize());
    result = result && (getFreeSpace()
        == other.getFreeSpace());
    result = result && (getNodeId()
        == other.getNodeId());
    return result;
  }

  @Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptorForType().hashCode();
    hash = (37 * hash) + HOSTNAME_FIELD_NUMBER;
    hash = (53 * hash) + getHostname().hashCode();
    hash = (37 * hash) + NIOPORT_FIELD_NUMBER;
    hash = (53 * hash) + getNioPort();
    hash = (37 * hash) + HTTPPORT_FIELD_NUMBER;
    hash = (53 * hash) + getHttpPort();
    hash = (37 * hash) + STOREDDATASIZE_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getStoredDataSize());
    hash = (37 * hash) + FREESPACE_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getFreeSpace());
    hash = (37 * hash) + NODEID_FIELD_NUMBER;
    hash = (53 * hash) + getNodeId();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.dfs.common.model.datanode.RegisterRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dfs.common.model.datanode.RegisterRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dfs.common.model.datanode.RegisterRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dfs.common.model.datanode.RegisterRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dfs.common.model.datanode.RegisterRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dfs.common.model.datanode.RegisterRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dfs.common.model.datanode.RegisterRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.dfs.common.model.datanode.RegisterRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dfs.common.model.datanode.RegisterRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dfs.common.model.datanode.RegisterRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.dfs.common.model.datanode.RegisterRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @Override
  protected Builder newBuilderForType(
      BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code com.ruyuan.dfs.common.proto.RegisterRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.ruyuan.dfs.common.proto.RegisterRequest)
      com.dfs.common.model.datanode.RegisterRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.dfs.common.model.datanode.Datanode.internal_static_com_ruyuan_dfs_common_proto_RegisterRequest_descriptor;
    }

    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dfs.common.model.datanode.Datanode.internal_static_com_ruyuan_dfs_common_proto_RegisterRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.dfs.common.model.datanode.RegisterRequest.class, com.dfs.common.model.datanode.RegisterRequest.Builder.class);
    }

    // Construct using com.dfs.common.model.datanode.RegisterRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    public Builder clear() {
      super.clear();
      hostname_ = "";

      nioPort_ = 0;

      httpPort_ = 0;

      storedDataSize_ = 0L;

      freeSpace_ = 0L;

      nodeId_ = 0;

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.dfs.common.model.datanode.Datanode.internal_static_com_ruyuan_dfs_common_proto_RegisterRequest_descriptor;
    }

    public com.dfs.common.model.datanode.RegisterRequest getDefaultInstanceForType() {
      return getDefaultInstance();
    }

    public com.dfs.common.model.datanode.RegisterRequest build() {
      com.dfs.common.model.datanode.RegisterRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.dfs.common.model.datanode.RegisterRequest buildPartial() {
      com.dfs.common.model.datanode.RegisterRequest result = new com.dfs.common.model.datanode.RegisterRequest(this);
      result.hostname_ = hostname_;
      result.nioPort_ = nioPort_;
      result.httpPort_ = httpPort_;
      result.storedDataSize_ = storedDataSize_;
      result.freeSpace_ = freeSpace_;
      result.nodeId_ = nodeId_;
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.dfs.common.model.datanode.RegisterRequest) {
        return mergeFrom((com.dfs.common.model.datanode.RegisterRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.dfs.common.model.datanode.RegisterRequest other) {
      if (other == getDefaultInstance()) return this;
      if (!other.getHostname().isEmpty()) {
        hostname_ = other.hostname_;
        onChanged();
      }
      if (other.getNioPort() != 0) {
        setNioPort(other.getNioPort());
      }
      if (other.getHttpPort() != 0) {
        setHttpPort(other.getHttpPort());
      }
      if (other.getStoredDataSize() != 0L) {
        setStoredDataSize(other.getStoredDataSize());
      }
      if (other.getFreeSpace() != 0L) {
        setFreeSpace(other.getFreeSpace());
      }
      if (other.getNodeId() != 0) {
        setNodeId(other.getNodeId());
      }
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.dfs.common.model.datanode.RegisterRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.dfs.common.model.datanode.RegisterRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private Object hostname_ = "";
    /**
     * <code>optional string hostname = 1;</code>
     */
    public String getHostname() {
      Object ref = hostname_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        hostname_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>optional string hostname = 1;</code>
     */
    public com.google.protobuf.ByteString
        getHostnameBytes() {
      Object ref = hostname_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        hostname_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>optional string hostname = 1;</code>
     */
    public Builder setHostname(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      hostname_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional string hostname = 1;</code>
     */
    public Builder clearHostname() {
      
      hostname_ = getDefaultInstance().getHostname();
      onChanged();
      return this;
    }
    /**
     * <code>optional string hostname = 1;</code>
     */
    public Builder setHostnameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      hostname_ = value;
      onChanged();
      return this;
    }

    private int nioPort_ ;
    /**
     * <code>optional int32 nioPort = 2;</code>
     */
    public int getNioPort() {
      return nioPort_;
    }
    /**
     * <code>optional int32 nioPort = 2;</code>
     */
    public Builder setNioPort(int value) {
      
      nioPort_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int32 nioPort = 2;</code>
     */
    public Builder clearNioPort() {
      
      nioPort_ = 0;
      onChanged();
      return this;
    }

    private int httpPort_ ;
    /**
     * <code>optional int32 httpPort = 3;</code>
     */
    public int getHttpPort() {
      return httpPort_;
    }
    /**
     * <code>optional int32 httpPort = 3;</code>
     */
    public Builder setHttpPort(int value) {
      
      httpPort_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int32 httpPort = 3;</code>
     */
    public Builder clearHttpPort() {
      
      httpPort_ = 0;
      onChanged();
      return this;
    }

    private long storedDataSize_ ;
    /**
     * <code>optional int64 storedDataSize = 4;</code>
     */
    public long getStoredDataSize() {
      return storedDataSize_;
    }
    /**
     * <code>optional int64 storedDataSize = 4;</code>
     */
    public Builder setStoredDataSize(long value) {
      
      storedDataSize_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int64 storedDataSize = 4;</code>
     */
    public Builder clearStoredDataSize() {
      
      storedDataSize_ = 0L;
      onChanged();
      return this;
    }

    private long freeSpace_ ;
    /**
     * <code>optional int64 freeSpace = 5;</code>
     */
    public long getFreeSpace() {
      return freeSpace_;
    }
    /**
     * <code>optional int64 freeSpace = 5;</code>
     */
    public Builder setFreeSpace(long value) {
      
      freeSpace_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int64 freeSpace = 5;</code>
     */
    public Builder clearFreeSpace() {
      
      freeSpace_ = 0L;
      onChanged();
      return this;
    }

    private int nodeId_ ;
    /**
     * <code>optional int32 nodeId = 6;</code>
     */
    public int getNodeId() {
      return nodeId_;
    }
    /**
     * <code>optional int32 nodeId = 6;</code>
     */
    public Builder setNodeId(int value) {
      
      nodeId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int32 nodeId = 6;</code>
     */
    public Builder clearNodeId() {
      
      nodeId_ = 0;
      onChanged();
      return this;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:com.ruyuan.dfs.common.proto.RegisterRequest)
  }

  // @@protoc_insertion_point(class_scope:com.ruyuan.dfs.common.proto.RegisterRequest)
  private static final com.dfs.common.model.datanode.RegisterRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.dfs.common.model.datanode.RegisterRequest();
  }

  public static com.dfs.common.model.datanode.RegisterRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<RegisterRequest>
      PARSER = new com.google.protobuf.AbstractParser<RegisterRequest>() {
    public RegisterRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new RegisterRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<RegisterRequest> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<RegisterRequest> getParserForType() {
    return PARSER;
  }

  public com.dfs.common.model.datanode.RegisterRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

