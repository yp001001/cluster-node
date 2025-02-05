// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: datanode.proto

package com.dfs.common.model.datanode;

/**
 * Protobuf type {@code com.ruyuan.dfs.common.proto.ReplicaCommand}
 */
public  final class ReplicaCommand extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.ruyuan.dfs.common.proto.ReplicaCommand)
        ReplicaCommandOrBuilder {
  // Use ReplicaCommand.newBuilder() to construct.
  private ReplicaCommand(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ReplicaCommand() {
    filename_ = "";
    hostname_ = "";
    port_ = 0;
    command_ = 0;
  }

  @Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private ReplicaCommand(
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

            filename_ = s;
            break;
          }
          case 18: {
            String s = input.readStringRequireUtf8();

            hostname_ = s;
            break;
          }
          case 24: {

            port_ = input.readInt32();
            break;
          }
          case 32: {

            command_ = input.readInt32();
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
    return com.dfs.common.model.datanode.Datanode.internal_static_com_ruyuan_dfs_common_proto_ReplicaCommand_descriptor;
  }

  protected FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.dfs.common.model.datanode.Datanode.internal_static_com_ruyuan_dfs_common_proto_ReplicaCommand_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.dfs.common.model.datanode.ReplicaCommand.class, com.dfs.common.model.datanode.ReplicaCommand.Builder.class);
  }

  public static final int FILENAME_FIELD_NUMBER = 1;
  private volatile Object filename_;
  /**
   * <code>optional string filename = 1;</code>
   */
  public String getFilename() {
    Object ref = filename_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      filename_ = s;
      return s;
    }
  }
  /**
   * <code>optional string filename = 1;</code>
   */
  public com.google.protobuf.ByteString
      getFilenameBytes() {
    Object ref = filename_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      filename_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int HOSTNAME_FIELD_NUMBER = 2;
  private volatile Object hostname_;
  /**
   * <code>optional string hostname = 2;</code>
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
   * <code>optional string hostname = 2;</code>
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

  public static final int PORT_FIELD_NUMBER = 3;
  private int port_;
  /**
   * <code>optional int32 port = 3;</code>
   */
  public int getPort() {
    return port_;
  }

  public static final int COMMAND_FIELD_NUMBER = 4;
  private int command_;
  /**
   * <code>optional int32 command = 4;</code>
   */
  public int getCommand() {
    return command_;
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
    if (!getFilenameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, filename_);
    }
    if (!getHostnameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, hostname_);
    }
    if (port_ != 0) {
      output.writeInt32(3, port_);
    }
    if (command_ != 0) {
      output.writeInt32(4, command_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getFilenameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, filename_);
    }
    if (!getHostnameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, hostname_);
    }
    if (port_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, port_);
    }
    if (command_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(4, command_);
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
    if (!(obj instanceof com.dfs.common.model.datanode.ReplicaCommand)) {
      return super.equals(obj);
    }
    com.dfs.common.model.datanode.ReplicaCommand other = (com.dfs.common.model.datanode.ReplicaCommand) obj;

    boolean result = true;
    result = result && getFilename()
        .equals(other.getFilename());
    result = result && getHostname()
        .equals(other.getHostname());
    result = result && (getPort()
        == other.getPort());
    result = result && (getCommand()
        == other.getCommand());
    return result;
  }

  @Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptorForType().hashCode();
    hash = (37 * hash) + FILENAME_FIELD_NUMBER;
    hash = (53 * hash) + getFilename().hashCode();
    hash = (37 * hash) + HOSTNAME_FIELD_NUMBER;
    hash = (53 * hash) + getHostname().hashCode();
    hash = (37 * hash) + PORT_FIELD_NUMBER;
    hash = (53 * hash) + getPort();
    hash = (37 * hash) + COMMAND_FIELD_NUMBER;
    hash = (53 * hash) + getCommand();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.dfs.common.model.datanode.ReplicaCommand parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dfs.common.model.datanode.ReplicaCommand parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dfs.common.model.datanode.ReplicaCommand parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dfs.common.model.datanode.ReplicaCommand parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dfs.common.model.datanode.ReplicaCommand parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dfs.common.model.datanode.ReplicaCommand parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dfs.common.model.datanode.ReplicaCommand parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.dfs.common.model.datanode.ReplicaCommand parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dfs.common.model.datanode.ReplicaCommand parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dfs.common.model.datanode.ReplicaCommand parseFrom(
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
  public static Builder newBuilder(com.dfs.common.model.datanode.ReplicaCommand prototype) {
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
   * Protobuf type {@code com.ruyuan.dfs.common.proto.ReplicaCommand}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.ruyuan.dfs.common.proto.ReplicaCommand)
      com.dfs.common.model.datanode.ReplicaCommandOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.dfs.common.model.datanode.Datanode.internal_static_com_ruyuan_dfs_common_proto_ReplicaCommand_descriptor;
    }

    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dfs.common.model.datanode.Datanode.internal_static_com_ruyuan_dfs_common_proto_ReplicaCommand_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.dfs.common.model.datanode.ReplicaCommand.class, com.dfs.common.model.datanode.ReplicaCommand.Builder.class);
    }

    // Construct using com.dfs.common.model.datanode.ReplicaCommand.newBuilder()
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
      filename_ = "";

      hostname_ = "";

      port_ = 0;

      command_ = 0;

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.dfs.common.model.datanode.Datanode.internal_static_com_ruyuan_dfs_common_proto_ReplicaCommand_descriptor;
    }

    public com.dfs.common.model.datanode.ReplicaCommand getDefaultInstanceForType() {
      return getDefaultInstance();
    }

    public com.dfs.common.model.datanode.ReplicaCommand build() {
      com.dfs.common.model.datanode.ReplicaCommand result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.dfs.common.model.datanode.ReplicaCommand buildPartial() {
      com.dfs.common.model.datanode.ReplicaCommand result = new com.dfs.common.model.datanode.ReplicaCommand(this);
      result.filename_ = filename_;
      result.hostname_ = hostname_;
      result.port_ = port_;
      result.command_ = command_;
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
      if (other instanceof com.dfs.common.model.datanode.ReplicaCommand) {
        return mergeFrom((com.dfs.common.model.datanode.ReplicaCommand)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.dfs.common.model.datanode.ReplicaCommand other) {
      if (other == getDefaultInstance()) return this;
      if (!other.getFilename().isEmpty()) {
        filename_ = other.filename_;
        onChanged();
      }
      if (!other.getHostname().isEmpty()) {
        hostname_ = other.hostname_;
        onChanged();
      }
      if (other.getPort() != 0) {
        setPort(other.getPort());
      }
      if (other.getCommand() != 0) {
        setCommand(other.getCommand());
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
      com.dfs.common.model.datanode.ReplicaCommand parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.dfs.common.model.datanode.ReplicaCommand) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private Object filename_ = "";
    /**
     * <code>optional string filename = 1;</code>
     */
    public String getFilename() {
      Object ref = filename_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        filename_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>optional string filename = 1;</code>
     */
    public com.google.protobuf.ByteString
        getFilenameBytes() {
      Object ref = filename_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        filename_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>optional string filename = 1;</code>
     */
    public Builder setFilename(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      filename_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional string filename = 1;</code>
     */
    public Builder clearFilename() {
      
      filename_ = getDefaultInstance().getFilename();
      onChanged();
      return this;
    }
    /**
     * <code>optional string filename = 1;</code>
     */
    public Builder setFilenameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      filename_ = value;
      onChanged();
      return this;
    }

    private Object hostname_ = "";
    /**
     * <code>optional string hostname = 2;</code>
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
     * <code>optional string hostname = 2;</code>
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
     * <code>optional string hostname = 2;</code>
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
     * <code>optional string hostname = 2;</code>
     */
    public Builder clearHostname() {
      
      hostname_ = getDefaultInstance().getHostname();
      onChanged();
      return this;
    }
    /**
     * <code>optional string hostname = 2;</code>
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

    private int port_ ;
    /**
     * <code>optional int32 port = 3;</code>
     */
    public int getPort() {
      return port_;
    }
    /**
     * <code>optional int32 port = 3;</code>
     */
    public Builder setPort(int value) {
      
      port_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int32 port = 3;</code>
     */
    public Builder clearPort() {
      
      port_ = 0;
      onChanged();
      return this;
    }

    private int command_ ;
    /**
     * <code>optional int32 command = 4;</code>
     */
    public int getCommand() {
      return command_;
    }
    /**
     * <code>optional int32 command = 4;</code>
     */
    public Builder setCommand(int value) {
      
      command_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int32 command = 4;</code>
     */
    public Builder clearCommand() {
      
      command_ = 0;
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


    // @@protoc_insertion_point(builder_scope:com.ruyuan.dfs.common.proto.ReplicaCommand)
  }

  // @@protoc_insertion_point(class_scope:com.ruyuan.dfs.common.proto.ReplicaCommand)
  private static final com.dfs.common.model.datanode.ReplicaCommand DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.dfs.common.model.datanode.ReplicaCommand();
  }

  public static com.dfs.common.model.datanode.ReplicaCommand getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ReplicaCommand>
      PARSER = new com.google.protobuf.AbstractParser<ReplicaCommand>() {
    public ReplicaCommand parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new ReplicaCommand(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ReplicaCommand> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<ReplicaCommand> getParserForType() {
    return PARSER;
  }

  public com.dfs.common.model.datanode.ReplicaCommand getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

