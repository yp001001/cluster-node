// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: datanode.proto

package com.dfs.common.model.datanode;

/**
 * Protobuf type {@code com.ruyuan.dfs.common.proto.HeartbeatResponse}
 */
public  final class HeartbeatResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.ruyuan.dfs.common.proto.HeartbeatResponse)
        HeartbeatResponseOrBuilder {
  // Use HeartbeatResponse.newBuilder() to construct.
  private HeartbeatResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private HeartbeatResponse() {
    commands_ = java.util.Collections.emptyList();
  }

  @Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private HeartbeatResponse(
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
            if (!((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
              commands_ = new java.util.ArrayList<com.dfs.common.model.datanode.ReplicaCommand>();
              mutable_bitField0_ |= 0x00000001;
            }
            commands_.add(
                input.readMessage(com.dfs.common.model.datanode.ReplicaCommand.parser(), extensionRegistry));
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
      if (((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
        commands_ = java.util.Collections.unmodifiableList(commands_);
      }
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.dfs.common.model.datanode.Datanode.internal_static_com_ruyuan_dfs_common_proto_HeartbeatResponse_descriptor;
  }

  protected FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.dfs.common.model.datanode.Datanode.internal_static_com_ruyuan_dfs_common_proto_HeartbeatResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.dfs.common.model.datanode.HeartbeatResponse.class, com.dfs.common.model.datanode.HeartbeatResponse.Builder.class);
  }

  public static final int COMMANDS_FIELD_NUMBER = 1;
  private java.util.List<com.dfs.common.model.datanode.ReplicaCommand> commands_;
  /**
   * <code>repeated .com.ruyuan.dfs.common.proto.ReplicaCommand commands = 1;</code>
   */
  public java.util.List<com.dfs.common.model.datanode.ReplicaCommand> getCommandsList() {
    return commands_;
  }
  /**
   * <code>repeated .com.ruyuan.dfs.common.proto.ReplicaCommand commands = 1;</code>
   */
  public java.util.List<? extends com.dfs.common.model.datanode.ReplicaCommandOrBuilder> 
      getCommandsOrBuilderList() {
    return commands_;
  }
  /**
   * <code>repeated .com.ruyuan.dfs.common.proto.ReplicaCommand commands = 1;</code>
   */
  public int getCommandsCount() {
    return commands_.size();
  }
  /**
   * <code>repeated .com.ruyuan.dfs.common.proto.ReplicaCommand commands = 1;</code>
   */
  public com.dfs.common.model.datanode.ReplicaCommand getCommands(int index) {
    return commands_.get(index);
  }
  /**
   * <code>repeated .com.ruyuan.dfs.common.proto.ReplicaCommand commands = 1;</code>
   */
  public com.dfs.common.model.datanode.ReplicaCommandOrBuilder getCommandsOrBuilder(
      int index) {
    return commands_.get(index);
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
    for (int i = 0; i < commands_.size(); i++) {
      output.writeMessage(1, commands_.get(i));
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < commands_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, commands_.get(i));
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
    if (!(obj instanceof com.dfs.common.model.datanode.HeartbeatResponse)) {
      return super.equals(obj);
    }
    com.dfs.common.model.datanode.HeartbeatResponse other = (com.dfs.common.model.datanode.HeartbeatResponse) obj;

    boolean result = true;
    result = result && getCommandsList()
        .equals(other.getCommandsList());
    return result;
  }

  @Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptorForType().hashCode();
    if (getCommandsCount() > 0) {
      hash = (37 * hash) + COMMANDS_FIELD_NUMBER;
      hash = (53 * hash) + getCommandsList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.dfs.common.model.datanode.HeartbeatResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dfs.common.model.datanode.HeartbeatResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dfs.common.model.datanode.HeartbeatResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dfs.common.model.datanode.HeartbeatResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dfs.common.model.datanode.HeartbeatResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dfs.common.model.datanode.HeartbeatResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dfs.common.model.datanode.HeartbeatResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.dfs.common.model.datanode.HeartbeatResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dfs.common.model.datanode.HeartbeatResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dfs.common.model.datanode.HeartbeatResponse parseFrom(
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
  public static Builder newBuilder(com.dfs.common.model.datanode.HeartbeatResponse prototype) {
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
   * Protobuf type {@code com.ruyuan.dfs.common.proto.HeartbeatResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.ruyuan.dfs.common.proto.HeartbeatResponse)
      com.dfs.common.model.datanode.HeartbeatResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.dfs.common.model.datanode.Datanode.internal_static_com_ruyuan_dfs_common_proto_HeartbeatResponse_descriptor;
    }

    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dfs.common.model.datanode.Datanode.internal_static_com_ruyuan_dfs_common_proto_HeartbeatResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.dfs.common.model.datanode.HeartbeatResponse.class, com.dfs.common.model.datanode.HeartbeatResponse.Builder.class);
    }

    // Construct using com.dfs.common.model.datanode.HeartbeatResponse.newBuilder()
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
        getCommandsFieldBuilder();
      }
    }
    public Builder clear() {
      super.clear();
      if (commandsBuilder_ == null) {
        commands_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        commandsBuilder_.clear();
      }
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.dfs.common.model.datanode.Datanode.internal_static_com_ruyuan_dfs_common_proto_HeartbeatResponse_descriptor;
    }

    public com.dfs.common.model.datanode.HeartbeatResponse getDefaultInstanceForType() {
      return getDefaultInstance();
    }

    public com.dfs.common.model.datanode.HeartbeatResponse build() {
      com.dfs.common.model.datanode.HeartbeatResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.dfs.common.model.datanode.HeartbeatResponse buildPartial() {
      com.dfs.common.model.datanode.HeartbeatResponse result = new com.dfs.common.model.datanode.HeartbeatResponse(this);
      int from_bitField0_ = bitField0_;
      if (commandsBuilder_ == null) {
        if (((bitField0_ & 0x00000001) == 0x00000001)) {
          commands_ = java.util.Collections.unmodifiableList(commands_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.commands_ = commands_;
      } else {
        result.commands_ = commandsBuilder_.build();
      }
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
      if (other instanceof com.dfs.common.model.datanode.HeartbeatResponse) {
        return mergeFrom((com.dfs.common.model.datanode.HeartbeatResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.dfs.common.model.datanode.HeartbeatResponse other) {
      if (other == getDefaultInstance()) return this;
      if (commandsBuilder_ == null) {
        if (!other.commands_.isEmpty()) {
          if (commands_.isEmpty()) {
            commands_ = other.commands_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureCommandsIsMutable();
            commands_.addAll(other.commands_);
          }
          onChanged();
        }
      } else {
        if (!other.commands_.isEmpty()) {
          if (commandsBuilder_.isEmpty()) {
            commandsBuilder_.dispose();
            commandsBuilder_ = null;
            commands_ = other.commands_;
            bitField0_ = (bitField0_ & ~0x00000001);
            commandsBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getCommandsFieldBuilder() : null;
          } else {
            commandsBuilder_.addAllMessages(other.commands_);
          }
        }
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
      com.dfs.common.model.datanode.HeartbeatResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.dfs.common.model.datanode.HeartbeatResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<com.dfs.common.model.datanode.ReplicaCommand> commands_ =
      java.util.Collections.emptyList();
    private void ensureCommandsIsMutable() {
      if (!((bitField0_ & 0x00000001) == 0x00000001)) {
        commands_ = new java.util.ArrayList<com.dfs.common.model.datanode.ReplicaCommand>(commands_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.dfs.common.model.datanode.ReplicaCommand, com.dfs.common.model.datanode.ReplicaCommand.Builder, com.dfs.common.model.datanode.ReplicaCommandOrBuilder> commandsBuilder_;

    /**
     * <code>repeated .com.ruyuan.dfs.common.proto.ReplicaCommand commands = 1;</code>
     */
    public java.util.List<com.dfs.common.model.datanode.ReplicaCommand> getCommandsList() {
      if (commandsBuilder_ == null) {
        return java.util.Collections.unmodifiableList(commands_);
      } else {
        return commandsBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .com.ruyuan.dfs.common.proto.ReplicaCommand commands = 1;</code>
     */
    public int getCommandsCount() {
      if (commandsBuilder_ == null) {
        return commands_.size();
      } else {
        return commandsBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .com.ruyuan.dfs.common.proto.ReplicaCommand commands = 1;</code>
     */
    public com.dfs.common.model.datanode.ReplicaCommand getCommands(int index) {
      if (commandsBuilder_ == null) {
        return commands_.get(index);
      } else {
        return commandsBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .com.ruyuan.dfs.common.proto.ReplicaCommand commands = 1;</code>
     */
    public Builder setCommands(
        int index, com.dfs.common.model.datanode.ReplicaCommand value) {
      if (commandsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureCommandsIsMutable();
        commands_.set(index, value);
        onChanged();
      } else {
        commandsBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .com.ruyuan.dfs.common.proto.ReplicaCommand commands = 1;</code>
     */
    public Builder setCommands(
        int index, com.dfs.common.model.datanode.ReplicaCommand.Builder builderForValue) {
      if (commandsBuilder_ == null) {
        ensureCommandsIsMutable();
        commands_.set(index, builderForValue.build());
        onChanged();
      } else {
        commandsBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .com.ruyuan.dfs.common.proto.ReplicaCommand commands = 1;</code>
     */
    public Builder addCommands(com.dfs.common.model.datanode.ReplicaCommand value) {
      if (commandsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureCommandsIsMutable();
        commands_.add(value);
        onChanged();
      } else {
        commandsBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .com.ruyuan.dfs.common.proto.ReplicaCommand commands = 1;</code>
     */
    public Builder addCommands(
        int index, com.dfs.common.model.datanode.ReplicaCommand value) {
      if (commandsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureCommandsIsMutable();
        commands_.add(index, value);
        onChanged();
      } else {
        commandsBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .com.ruyuan.dfs.common.proto.ReplicaCommand commands = 1;</code>
     */
    public Builder addCommands(
        com.dfs.common.model.datanode.ReplicaCommand.Builder builderForValue) {
      if (commandsBuilder_ == null) {
        ensureCommandsIsMutable();
        commands_.add(builderForValue.build());
        onChanged();
      } else {
        commandsBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .com.ruyuan.dfs.common.proto.ReplicaCommand commands = 1;</code>
     */
    public Builder addCommands(
        int index, com.dfs.common.model.datanode.ReplicaCommand.Builder builderForValue) {
      if (commandsBuilder_ == null) {
        ensureCommandsIsMutable();
        commands_.add(index, builderForValue.build());
        onChanged();
      } else {
        commandsBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .com.ruyuan.dfs.common.proto.ReplicaCommand commands = 1;</code>
     */
    public Builder addAllCommands(
        Iterable<? extends com.dfs.common.model.datanode.ReplicaCommand> values) {
      if (commandsBuilder_ == null) {
        ensureCommandsIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, commands_);
        onChanged();
      } else {
        commandsBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .com.ruyuan.dfs.common.proto.ReplicaCommand commands = 1;</code>
     */
    public Builder clearCommands() {
      if (commandsBuilder_ == null) {
        commands_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        commandsBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .com.ruyuan.dfs.common.proto.ReplicaCommand commands = 1;</code>
     */
    public Builder removeCommands(int index) {
      if (commandsBuilder_ == null) {
        ensureCommandsIsMutable();
        commands_.remove(index);
        onChanged();
      } else {
        commandsBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .com.ruyuan.dfs.common.proto.ReplicaCommand commands = 1;</code>
     */
    public com.dfs.common.model.datanode.ReplicaCommand.Builder getCommandsBuilder(
        int index) {
      return getCommandsFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .com.ruyuan.dfs.common.proto.ReplicaCommand commands = 1;</code>
     */
    public com.dfs.common.model.datanode.ReplicaCommandOrBuilder getCommandsOrBuilder(
        int index) {
      if (commandsBuilder_ == null) {
        return commands_.get(index);  } else {
        return commandsBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .com.ruyuan.dfs.common.proto.ReplicaCommand commands = 1;</code>
     */
    public java.util.List<? extends com.dfs.common.model.datanode.ReplicaCommandOrBuilder> 
         getCommandsOrBuilderList() {
      if (commandsBuilder_ != null) {
        return commandsBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(commands_);
      }
    }
    /**
     * <code>repeated .com.ruyuan.dfs.common.proto.ReplicaCommand commands = 1;</code>
     */
    public com.dfs.common.model.datanode.ReplicaCommand.Builder addCommandsBuilder() {
      return getCommandsFieldBuilder().addBuilder(
          com.dfs.common.model.datanode.ReplicaCommand.getDefaultInstance());
    }
    /**
     * <code>repeated .com.ruyuan.dfs.common.proto.ReplicaCommand commands = 1;</code>
     */
    public com.dfs.common.model.datanode.ReplicaCommand.Builder addCommandsBuilder(
        int index) {
      return getCommandsFieldBuilder().addBuilder(
          index, com.dfs.common.model.datanode.ReplicaCommand.getDefaultInstance());
    }
    /**
     * <code>repeated .com.ruyuan.dfs.common.proto.ReplicaCommand commands = 1;</code>
     */
    public java.util.List<com.dfs.common.model.datanode.ReplicaCommand.Builder> 
         getCommandsBuilderList() {
      return getCommandsFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.dfs.common.model.datanode.ReplicaCommand, com.dfs.common.model.datanode.ReplicaCommand.Builder, com.dfs.common.model.datanode.ReplicaCommandOrBuilder> 
        getCommandsFieldBuilder() {
      if (commandsBuilder_ == null) {
        commandsBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            com.dfs.common.model.datanode.ReplicaCommand, com.dfs.common.model.datanode.ReplicaCommand.Builder, com.dfs.common.model.datanode.ReplicaCommandOrBuilder>(
                commands_,
                ((bitField0_ & 0x00000001) == 0x00000001),
                getParentForChildren(),
                isClean());
        commands_ = null;
      }
      return commandsBuilder_;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:com.ruyuan.dfs.common.proto.HeartbeatResponse)
  }

  // @@protoc_insertion_point(class_scope:com.ruyuan.dfs.common.proto.HeartbeatResponse)
  private static final com.dfs.common.model.datanode.HeartbeatResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.dfs.common.model.datanode.HeartbeatResponse();
  }

  public static com.dfs.common.model.datanode.HeartbeatResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<HeartbeatResponse>
      PARSER = new com.google.protobuf.AbstractParser<HeartbeatResponse>() {
    public HeartbeatResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new HeartbeatResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<HeartbeatResponse> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<HeartbeatResponse> getParserForType() {
    return PARSER;
  }

  public com.dfs.common.model.datanode.HeartbeatResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

