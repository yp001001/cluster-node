// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: namenode.proto

package com.dfs.common.model.namenode;

/**
 * Protobuf type {@code com.ruyuan.dfs.common.proto.NewPeerNodeInfo}
 */
public  final class NewPeerNodeInfo extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.ruyuan.dfs.common.proto.NewPeerNodeInfo)
        NewPeerNodeInfoOrBuilder {
  // Use NewPeerNodeInfo.newBuilder() to construct.
  private NewPeerNodeInfo(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private NewPeerNodeInfo() {
    requests_ = java.util.Collections.emptyList();
    users_ = java.util.Collections.emptyList();
  }

  @Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private NewPeerNodeInfo(
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
              requests_ = new java.util.ArrayList<com.dfs.common.model.datanode.RegisterRequest>();
              mutable_bitField0_ |= 0x00000001;
            }
            requests_.add(
                input.readMessage(com.dfs.common.model.datanode.RegisterRequest.parser(), extensionRegistry));
            break;
          }
          case 18: {
            if (!((mutable_bitField0_ & 0x00000002) == 0x00000002)) {
              users_ = new java.util.ArrayList<com.dfs.common.model.namenode.UserEntity>();
              mutable_bitField0_ |= 0x00000002;
            }
            users_.add(
                input.readMessage(com.dfs.common.model.namenode.UserEntity.parser(), extensionRegistry));
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
        requests_ = java.util.Collections.unmodifiableList(requests_);
      }
      if (((mutable_bitField0_ & 0x00000002) == 0x00000002)) {
        users_ = java.util.Collections.unmodifiableList(users_);
      }
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.dfs.common.model.namenode.Namenode.internal_static_com_ruyuan_dfs_common_proto_NewPeerNodeInfo_descriptor;
  }

  protected FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.dfs.common.model.namenode.Namenode.internal_static_com_ruyuan_dfs_common_proto_NewPeerNodeInfo_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.dfs.common.model.namenode.NewPeerNodeInfo.class, com.dfs.common.model.namenode.NewPeerNodeInfo.Builder.class);
  }

  public static final int REQUESTS_FIELD_NUMBER = 1;
  private java.util.List<com.dfs.common.model.datanode.RegisterRequest> requests_;
  /**
   * <code>repeated .com.ruyuan.dfs.common.proto.RegisterRequest requests = 1;</code>
   */
  public java.util.List<com.dfs.common.model.datanode.RegisterRequest> getRequestsList() {
    return requests_;
  }
  /**
   * <code>repeated .com.ruyuan.dfs.common.proto.RegisterRequest requests = 1;</code>
   */
  public java.util.List<? extends com.dfs.common.model.datanode.RegisterRequestOrBuilder> 
      getRequestsOrBuilderList() {
    return requests_;
  }
  /**
   * <code>repeated .com.ruyuan.dfs.common.proto.RegisterRequest requests = 1;</code>
   */
  public int getRequestsCount() {
    return requests_.size();
  }
  /**
   * <code>repeated .com.ruyuan.dfs.common.proto.RegisterRequest requests = 1;</code>
   */
  public com.dfs.common.model.datanode.RegisterRequest getRequests(int index) {
    return requests_.get(index);
  }
  /**
   * <code>repeated .com.ruyuan.dfs.common.proto.RegisterRequest requests = 1;</code>
   */
  public com.dfs.common.model.datanode.RegisterRequestOrBuilder getRequestsOrBuilder(
      int index) {
    return requests_.get(index);
  }

  public static final int USERS_FIELD_NUMBER = 2;
  private java.util.List<com.dfs.common.model.namenode.UserEntity> users_;
  /**
   * <code>repeated .com.ruyuan.dfs.common.proto.UserEntity users = 2;</code>
   */
  public java.util.List<com.dfs.common.model.namenode.UserEntity> getUsersList() {
    return users_;
  }
  /**
   * <code>repeated .com.ruyuan.dfs.common.proto.UserEntity users = 2;</code>
   */
  public java.util.List<? extends com.dfs.common.model.namenode.UserEntityOrBuilder> 
      getUsersOrBuilderList() {
    return users_;
  }
  /**
   * <code>repeated .com.ruyuan.dfs.common.proto.UserEntity users = 2;</code>
   */
  public int getUsersCount() {
    return users_.size();
  }
  /**
   * <code>repeated .com.ruyuan.dfs.common.proto.UserEntity users = 2;</code>
   */
  public com.dfs.common.model.namenode.UserEntity getUsers(int index) {
    return users_.get(index);
  }
  /**
   * <code>repeated .com.ruyuan.dfs.common.proto.UserEntity users = 2;</code>
   */
  public com.dfs.common.model.namenode.UserEntityOrBuilder getUsersOrBuilder(
      int index) {
    return users_.get(index);
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
    for (int i = 0; i < requests_.size(); i++) {
      output.writeMessage(1, requests_.get(i));
    }
    for (int i = 0; i < users_.size(); i++) {
      output.writeMessage(2, users_.get(i));
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < requests_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, requests_.get(i));
    }
    for (int i = 0; i < users_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, users_.get(i));
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
    if (!(obj instanceof com.dfs.common.model.namenode.NewPeerNodeInfo)) {
      return super.equals(obj);
    }
    com.dfs.common.model.namenode.NewPeerNodeInfo other = (com.dfs.common.model.namenode.NewPeerNodeInfo) obj;

    boolean result = true;
    result = result && getRequestsList()
        .equals(other.getRequestsList());
    result = result && getUsersList()
        .equals(other.getUsersList());
    return result;
  }

  @Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptorForType().hashCode();
    if (getRequestsCount() > 0) {
      hash = (37 * hash) + REQUESTS_FIELD_NUMBER;
      hash = (53 * hash) + getRequestsList().hashCode();
    }
    if (getUsersCount() > 0) {
      hash = (37 * hash) + USERS_FIELD_NUMBER;
      hash = (53 * hash) + getUsersList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.dfs.common.model.namenode.NewPeerNodeInfo parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dfs.common.model.namenode.NewPeerNodeInfo parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dfs.common.model.namenode.NewPeerNodeInfo parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dfs.common.model.namenode.NewPeerNodeInfo parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dfs.common.model.namenode.NewPeerNodeInfo parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dfs.common.model.namenode.NewPeerNodeInfo parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dfs.common.model.namenode.NewPeerNodeInfo parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.dfs.common.model.namenode.NewPeerNodeInfo parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dfs.common.model.namenode.NewPeerNodeInfo parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dfs.common.model.namenode.NewPeerNodeInfo parseFrom(
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
  public static Builder newBuilder(com.dfs.common.model.namenode.NewPeerNodeInfo prototype) {
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
   * Protobuf type {@code com.ruyuan.dfs.common.proto.NewPeerNodeInfo}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.ruyuan.dfs.common.proto.NewPeerNodeInfo)
      com.dfs.common.model.namenode.NewPeerNodeInfoOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.dfs.common.model.namenode.Namenode.internal_static_com_ruyuan_dfs_common_proto_NewPeerNodeInfo_descriptor;
    }

    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dfs.common.model.namenode.Namenode.internal_static_com_ruyuan_dfs_common_proto_NewPeerNodeInfo_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.dfs.common.model.namenode.NewPeerNodeInfo.class, com.dfs.common.model.namenode.NewPeerNodeInfo.Builder.class);
    }

    // Construct using com.dfs.common.model.namenode.NewPeerNodeInfo.newBuilder()
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
        getRequestsFieldBuilder();
        getUsersFieldBuilder();
      }
    }
    public Builder clear() {
      super.clear();
      if (requestsBuilder_ == null) {
        requests_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        requestsBuilder_.clear();
      }
      if (usersBuilder_ == null) {
        users_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000002);
      } else {
        usersBuilder_.clear();
      }
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.dfs.common.model.namenode.Namenode.internal_static_com_ruyuan_dfs_common_proto_NewPeerNodeInfo_descriptor;
    }

    public com.dfs.common.model.namenode.NewPeerNodeInfo getDefaultInstanceForType() {
      return getDefaultInstance();
    }

    public com.dfs.common.model.namenode.NewPeerNodeInfo build() {
      com.dfs.common.model.namenode.NewPeerNodeInfo result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.dfs.common.model.namenode.NewPeerNodeInfo buildPartial() {
      com.dfs.common.model.namenode.NewPeerNodeInfo result = new com.dfs.common.model.namenode.NewPeerNodeInfo(this);
      int from_bitField0_ = bitField0_;
      if (requestsBuilder_ == null) {
        if (((bitField0_ & 0x00000001) == 0x00000001)) {
          requests_ = java.util.Collections.unmodifiableList(requests_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.requests_ = requests_;
      } else {
        result.requests_ = requestsBuilder_.build();
      }
      if (usersBuilder_ == null) {
        if (((bitField0_ & 0x00000002) == 0x00000002)) {
          users_ = java.util.Collections.unmodifiableList(users_);
          bitField0_ = (bitField0_ & ~0x00000002);
        }
        result.users_ = users_;
      } else {
        result.users_ = usersBuilder_.build();
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
      if (other instanceof com.dfs.common.model.namenode.NewPeerNodeInfo) {
        return mergeFrom((com.dfs.common.model.namenode.NewPeerNodeInfo)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.dfs.common.model.namenode.NewPeerNodeInfo other) {
      if (other == getDefaultInstance()) return this;
      if (requestsBuilder_ == null) {
        if (!other.requests_.isEmpty()) {
          if (requests_.isEmpty()) {
            requests_ = other.requests_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureRequestsIsMutable();
            requests_.addAll(other.requests_);
          }
          onChanged();
        }
      } else {
        if (!other.requests_.isEmpty()) {
          if (requestsBuilder_.isEmpty()) {
            requestsBuilder_.dispose();
            requestsBuilder_ = null;
            requests_ = other.requests_;
            bitField0_ = (bitField0_ & ~0x00000001);
            requestsBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getRequestsFieldBuilder() : null;
          } else {
            requestsBuilder_.addAllMessages(other.requests_);
          }
        }
      }
      if (usersBuilder_ == null) {
        if (!other.users_.isEmpty()) {
          if (users_.isEmpty()) {
            users_ = other.users_;
            bitField0_ = (bitField0_ & ~0x00000002);
          } else {
            ensureUsersIsMutable();
            users_.addAll(other.users_);
          }
          onChanged();
        }
      } else {
        if (!other.users_.isEmpty()) {
          if (usersBuilder_.isEmpty()) {
            usersBuilder_.dispose();
            usersBuilder_ = null;
            users_ = other.users_;
            bitField0_ = (bitField0_ & ~0x00000002);
            usersBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getUsersFieldBuilder() : null;
          } else {
            usersBuilder_.addAllMessages(other.users_);
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
      com.dfs.common.model.namenode.NewPeerNodeInfo parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.dfs.common.model.namenode.NewPeerNodeInfo) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<com.dfs.common.model.datanode.RegisterRequest> requests_ =
      java.util.Collections.emptyList();
    private void ensureRequestsIsMutable() {
      if (!((bitField0_ & 0x00000001) == 0x00000001)) {
        requests_ = new java.util.ArrayList<com.dfs.common.model.datanode.RegisterRequest>(requests_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.dfs.common.model.datanode.RegisterRequest, com.dfs.common.model.datanode.RegisterRequest.Builder, com.dfs.common.model.datanode.RegisterRequestOrBuilder> requestsBuilder_;

    /**
     * <code>repeated .com.ruyuan.dfs.common.proto.RegisterRequest requests = 1;</code>
     */
    public java.util.List<com.dfs.common.model.datanode.RegisterRequest> getRequestsList() {
      if (requestsBuilder_ == null) {
        return java.util.Collections.unmodifiableList(requests_);
      } else {
        return requestsBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .com.ruyuan.dfs.common.proto.RegisterRequest requests = 1;</code>
     */
    public int getRequestsCount() {
      if (requestsBuilder_ == null) {
        return requests_.size();
      } else {
        return requestsBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .com.ruyuan.dfs.common.proto.RegisterRequest requests = 1;</code>
     */
    public com.dfs.common.model.datanode.RegisterRequest getRequests(int index) {
      if (requestsBuilder_ == null) {
        return requests_.get(index);
      } else {
        return requestsBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .com.ruyuan.dfs.common.proto.RegisterRequest requests = 1;</code>
     */
    public Builder setRequests(
        int index, com.dfs.common.model.datanode.RegisterRequest value) {
      if (requestsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureRequestsIsMutable();
        requests_.set(index, value);
        onChanged();
      } else {
        requestsBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .com.ruyuan.dfs.common.proto.RegisterRequest requests = 1;</code>
     */
    public Builder setRequests(
        int index, com.dfs.common.model.datanode.RegisterRequest.Builder builderForValue) {
      if (requestsBuilder_ == null) {
        ensureRequestsIsMutable();
        requests_.set(index, builderForValue.build());
        onChanged();
      } else {
        requestsBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .com.ruyuan.dfs.common.proto.RegisterRequest requests = 1;</code>
     */
    public Builder addRequests(com.dfs.common.model.datanode.RegisterRequest value) {
      if (requestsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureRequestsIsMutable();
        requests_.add(value);
        onChanged();
      } else {
        requestsBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .com.ruyuan.dfs.common.proto.RegisterRequest requests = 1;</code>
     */
    public Builder addRequests(
        int index, com.dfs.common.model.datanode.RegisterRequest value) {
      if (requestsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureRequestsIsMutable();
        requests_.add(index, value);
        onChanged();
      } else {
        requestsBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .com.ruyuan.dfs.common.proto.RegisterRequest requests = 1;</code>
     */
    public Builder addRequests(
        com.dfs.common.model.datanode.RegisterRequest.Builder builderForValue) {
      if (requestsBuilder_ == null) {
        ensureRequestsIsMutable();
        requests_.add(builderForValue.build());
        onChanged();
      } else {
        requestsBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .com.ruyuan.dfs.common.proto.RegisterRequest requests = 1;</code>
     */
    public Builder addRequests(
        int index, com.dfs.common.model.datanode.RegisterRequest.Builder builderForValue) {
      if (requestsBuilder_ == null) {
        ensureRequestsIsMutable();
        requests_.add(index, builderForValue.build());
        onChanged();
      } else {
        requestsBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .com.ruyuan.dfs.common.proto.RegisterRequest requests = 1;</code>
     */
    public Builder addAllRequests(
        Iterable<? extends com.dfs.common.model.datanode.RegisterRequest> values) {
      if (requestsBuilder_ == null) {
        ensureRequestsIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, requests_);
        onChanged();
      } else {
        requestsBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .com.ruyuan.dfs.common.proto.RegisterRequest requests = 1;</code>
     */
    public Builder clearRequests() {
      if (requestsBuilder_ == null) {
        requests_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        requestsBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .com.ruyuan.dfs.common.proto.RegisterRequest requests = 1;</code>
     */
    public Builder removeRequests(int index) {
      if (requestsBuilder_ == null) {
        ensureRequestsIsMutable();
        requests_.remove(index);
        onChanged();
      } else {
        requestsBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .com.ruyuan.dfs.common.proto.RegisterRequest requests = 1;</code>
     */
    public com.dfs.common.model.datanode.RegisterRequest.Builder getRequestsBuilder(
        int index) {
      return getRequestsFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .com.ruyuan.dfs.common.proto.RegisterRequest requests = 1;</code>
     */
    public com.dfs.common.model.datanode.RegisterRequestOrBuilder getRequestsOrBuilder(
        int index) {
      if (requestsBuilder_ == null) {
        return requests_.get(index);  } else {
        return requestsBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .com.ruyuan.dfs.common.proto.RegisterRequest requests = 1;</code>
     */
    public java.util.List<? extends com.dfs.common.model.datanode.RegisterRequestOrBuilder> 
         getRequestsOrBuilderList() {
      if (requestsBuilder_ != null) {
        return requestsBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(requests_);
      }
    }
    /**
     * <code>repeated .com.ruyuan.dfs.common.proto.RegisterRequest requests = 1;</code>
     */
    public com.dfs.common.model.datanode.RegisterRequest.Builder addRequestsBuilder() {
      return getRequestsFieldBuilder().addBuilder(
          com.dfs.common.model.datanode.RegisterRequest.getDefaultInstance());
    }
    /**
     * <code>repeated .com.ruyuan.dfs.common.proto.RegisterRequest requests = 1;</code>
     */
    public com.dfs.common.model.datanode.RegisterRequest.Builder addRequestsBuilder(
        int index) {
      return getRequestsFieldBuilder().addBuilder(
          index, com.dfs.common.model.datanode.RegisterRequest.getDefaultInstance());
    }
    /**
     * <code>repeated .com.ruyuan.dfs.common.proto.RegisterRequest requests = 1;</code>
     */
    public java.util.List<com.dfs.common.model.datanode.RegisterRequest.Builder> 
         getRequestsBuilderList() {
      return getRequestsFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.dfs.common.model.datanode.RegisterRequest, com.dfs.common.model.datanode.RegisterRequest.Builder, com.dfs.common.model.datanode.RegisterRequestOrBuilder> 
        getRequestsFieldBuilder() {
      if (requestsBuilder_ == null) {
        requestsBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            com.dfs.common.model.datanode.RegisterRequest, com.dfs.common.model.datanode.RegisterRequest.Builder, com.dfs.common.model.datanode.RegisterRequestOrBuilder>(
                requests_,
                ((bitField0_ & 0x00000001) == 0x00000001),
                getParentForChildren(),
                isClean());
        requests_ = null;
      }
      return requestsBuilder_;
    }

    private java.util.List<com.dfs.common.model.namenode.UserEntity> users_ =
      java.util.Collections.emptyList();
    private void ensureUsersIsMutable() {
      if (!((bitField0_ & 0x00000002) == 0x00000002)) {
        users_ = new java.util.ArrayList<com.dfs.common.model.namenode.UserEntity>(users_);
        bitField0_ |= 0x00000002;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.dfs.common.model.namenode.UserEntity, com.dfs.common.model.namenode.UserEntity.Builder, com.dfs.common.model.namenode.UserEntityOrBuilder> usersBuilder_;

    /**
     * <code>repeated .com.ruyuan.dfs.common.proto.UserEntity users = 2;</code>
     */
    public java.util.List<com.dfs.common.model.namenode.UserEntity> getUsersList() {
      if (usersBuilder_ == null) {
        return java.util.Collections.unmodifiableList(users_);
      } else {
        return usersBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .com.ruyuan.dfs.common.proto.UserEntity users = 2;</code>
     */
    public int getUsersCount() {
      if (usersBuilder_ == null) {
        return users_.size();
      } else {
        return usersBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .com.ruyuan.dfs.common.proto.UserEntity users = 2;</code>
     */
    public com.dfs.common.model.namenode.UserEntity getUsers(int index) {
      if (usersBuilder_ == null) {
        return users_.get(index);
      } else {
        return usersBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .com.ruyuan.dfs.common.proto.UserEntity users = 2;</code>
     */
    public Builder setUsers(
        int index, com.dfs.common.model.namenode.UserEntity value) {
      if (usersBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureUsersIsMutable();
        users_.set(index, value);
        onChanged();
      } else {
        usersBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .com.ruyuan.dfs.common.proto.UserEntity users = 2;</code>
     */
    public Builder setUsers(
        int index, com.dfs.common.model.namenode.UserEntity.Builder builderForValue) {
      if (usersBuilder_ == null) {
        ensureUsersIsMutable();
        users_.set(index, builderForValue.build());
        onChanged();
      } else {
        usersBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .com.ruyuan.dfs.common.proto.UserEntity users = 2;</code>
     */
    public Builder addUsers(com.dfs.common.model.namenode.UserEntity value) {
      if (usersBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureUsersIsMutable();
        users_.add(value);
        onChanged();
      } else {
        usersBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .com.ruyuan.dfs.common.proto.UserEntity users = 2;</code>
     */
    public Builder addUsers(
        int index, com.dfs.common.model.namenode.UserEntity value) {
      if (usersBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureUsersIsMutable();
        users_.add(index, value);
        onChanged();
      } else {
        usersBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .com.ruyuan.dfs.common.proto.UserEntity users = 2;</code>
     */
    public Builder addUsers(
        com.dfs.common.model.namenode.UserEntity.Builder builderForValue) {
      if (usersBuilder_ == null) {
        ensureUsersIsMutable();
        users_.add(builderForValue.build());
        onChanged();
      } else {
        usersBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .com.ruyuan.dfs.common.proto.UserEntity users = 2;</code>
     */
    public Builder addUsers(
        int index, com.dfs.common.model.namenode.UserEntity.Builder builderForValue) {
      if (usersBuilder_ == null) {
        ensureUsersIsMutable();
        users_.add(index, builderForValue.build());
        onChanged();
      } else {
        usersBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .com.ruyuan.dfs.common.proto.UserEntity users = 2;</code>
     */
    public Builder addAllUsers(
        Iterable<? extends com.dfs.common.model.namenode.UserEntity> values) {
      if (usersBuilder_ == null) {
        ensureUsersIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, users_);
        onChanged();
      } else {
        usersBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .com.ruyuan.dfs.common.proto.UserEntity users = 2;</code>
     */
    public Builder clearUsers() {
      if (usersBuilder_ == null) {
        users_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000002);
        onChanged();
      } else {
        usersBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .com.ruyuan.dfs.common.proto.UserEntity users = 2;</code>
     */
    public Builder removeUsers(int index) {
      if (usersBuilder_ == null) {
        ensureUsersIsMutable();
        users_.remove(index);
        onChanged();
      } else {
        usersBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .com.ruyuan.dfs.common.proto.UserEntity users = 2;</code>
     */
    public com.dfs.common.model.namenode.UserEntity.Builder getUsersBuilder(
        int index) {
      return getUsersFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .com.ruyuan.dfs.common.proto.UserEntity users = 2;</code>
     */
    public com.dfs.common.model.namenode.UserEntityOrBuilder getUsersOrBuilder(
        int index) {
      if (usersBuilder_ == null) {
        return users_.get(index);  } else {
        return usersBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .com.ruyuan.dfs.common.proto.UserEntity users = 2;</code>
     */
    public java.util.List<? extends com.dfs.common.model.namenode.UserEntityOrBuilder> 
         getUsersOrBuilderList() {
      if (usersBuilder_ != null) {
        return usersBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(users_);
      }
    }
    /**
     * <code>repeated .com.ruyuan.dfs.common.proto.UserEntity users = 2;</code>
     */
    public com.dfs.common.model.namenode.UserEntity.Builder addUsersBuilder() {
      return getUsersFieldBuilder().addBuilder(
          com.dfs.common.model.namenode.UserEntity.getDefaultInstance());
    }
    /**
     * <code>repeated .com.ruyuan.dfs.common.proto.UserEntity users = 2;</code>
     */
    public com.dfs.common.model.namenode.UserEntity.Builder addUsersBuilder(
        int index) {
      return getUsersFieldBuilder().addBuilder(
          index, com.dfs.common.model.namenode.UserEntity.getDefaultInstance());
    }
    /**
     * <code>repeated .com.ruyuan.dfs.common.proto.UserEntity users = 2;</code>
     */
    public java.util.List<com.dfs.common.model.namenode.UserEntity.Builder> 
         getUsersBuilderList() {
      return getUsersFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.dfs.common.model.namenode.UserEntity, com.dfs.common.model.namenode.UserEntity.Builder, com.dfs.common.model.namenode.UserEntityOrBuilder> 
        getUsersFieldBuilder() {
      if (usersBuilder_ == null) {
        usersBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            com.dfs.common.model.namenode.UserEntity, com.dfs.common.model.namenode.UserEntity.Builder, com.dfs.common.model.namenode.UserEntityOrBuilder>(
                users_,
                ((bitField0_ & 0x00000002) == 0x00000002),
                getParentForChildren(),
                isClean());
        users_ = null;
      }
      return usersBuilder_;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:com.ruyuan.dfs.common.proto.NewPeerNodeInfo)
  }

  // @@protoc_insertion_point(class_scope:com.ruyuan.dfs.common.proto.NewPeerNodeInfo)
  private static final com.dfs.common.model.namenode.NewPeerNodeInfo DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.dfs.common.model.namenode.NewPeerNodeInfo();
  }

  public static com.dfs.common.model.namenode.NewPeerNodeInfo getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<NewPeerNodeInfo>
      PARSER = new com.google.protobuf.AbstractParser<NewPeerNodeInfo>() {
    public NewPeerNodeInfo parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new NewPeerNodeInfo(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<NewPeerNodeInfo> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<NewPeerNodeInfo> getParserForType() {
    return PARSER;
  }

  public com.dfs.common.model.namenode.NewPeerNodeInfo getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

