// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: namenode.proto

package com.dfs.common.model.namenode;

/**
 * Protobuf type {@code com.ruyuan.dfs.common.proto.UserChangeEvent}
 */
public  final class UserChangeEvent extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.ruyuan.dfs.common.proto.UserChangeEvent)
        UserChangeEventOrBuilder {
  // Use UserChangeEvent.newBuilder() to construct.
  private UserChangeEvent(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private UserChangeEvent() {
    eventType_ = 0;
  }

  @Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private UserChangeEvent(
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
          case 8: {

            eventType_ = input.readInt32();
            break;
          }
          case 18: {
            com.dfs.common.model.namenode.UserEntity.Builder subBuilder = null;
            if (userEntity_ != null) {
              subBuilder = userEntity_.toBuilder();
            }
            userEntity_ = input.readMessage(com.dfs.common.model.namenode.UserEntity.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(userEntity_);
              userEntity_ = subBuilder.buildPartial();
            }

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
    return com.dfs.common.model.namenode.Namenode.internal_static_com_ruyuan_dfs_common_proto_UserChangeEvent_descriptor;
  }

  protected FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.dfs.common.model.namenode.Namenode.internal_static_com_ruyuan_dfs_common_proto_UserChangeEvent_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.dfs.common.model.namenode.UserChangeEvent.class, com.dfs.common.model.namenode.UserChangeEvent.Builder.class);
  }

  public static final int EVENTTYPE_FIELD_NUMBER = 1;
  private int eventType_;
  /**
   * <code>optional int32 eventType = 1;</code>
   */
  public int getEventType() {
    return eventType_;
  }

  public static final int USERENTITY_FIELD_NUMBER = 2;
  private com.dfs.common.model.namenode.UserEntity userEntity_;
  /**
   * <code>optional .com.ruyuan.dfs.common.proto.UserEntity userEntity = 2;</code>
   */
  public boolean hasUserEntity() {
    return userEntity_ != null;
  }
  /**
   * <code>optional .com.ruyuan.dfs.common.proto.UserEntity userEntity = 2;</code>
   */
  public com.dfs.common.model.namenode.UserEntity getUserEntity() {
    return userEntity_ == null ? com.dfs.common.model.namenode.UserEntity.getDefaultInstance() : userEntity_;
  }
  /**
   * <code>optional .com.ruyuan.dfs.common.proto.UserEntity userEntity = 2;</code>
   */
  public com.dfs.common.model.namenode.UserEntityOrBuilder getUserEntityOrBuilder() {
    return getUserEntity();
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
    if (eventType_ != 0) {
      output.writeInt32(1, eventType_);
    }
    if (userEntity_ != null) {
      output.writeMessage(2, getUserEntity());
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (eventType_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, eventType_);
    }
    if (userEntity_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getUserEntity());
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
    if (!(obj instanceof com.dfs.common.model.namenode.UserChangeEvent)) {
      return super.equals(obj);
    }
    com.dfs.common.model.namenode.UserChangeEvent other = (com.dfs.common.model.namenode.UserChangeEvent) obj;

    boolean result = true;
    result = result && (getEventType()
        == other.getEventType());
    result = result && (hasUserEntity() == other.hasUserEntity());
    if (hasUserEntity()) {
      result = result && getUserEntity()
          .equals(other.getUserEntity());
    }
    return result;
  }

  @Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptorForType().hashCode();
    hash = (37 * hash) + EVENTTYPE_FIELD_NUMBER;
    hash = (53 * hash) + getEventType();
    if (hasUserEntity()) {
      hash = (37 * hash) + USERENTITY_FIELD_NUMBER;
      hash = (53 * hash) + getUserEntity().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.dfs.common.model.namenode.UserChangeEvent parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dfs.common.model.namenode.UserChangeEvent parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dfs.common.model.namenode.UserChangeEvent parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dfs.common.model.namenode.UserChangeEvent parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dfs.common.model.namenode.UserChangeEvent parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dfs.common.model.namenode.UserChangeEvent parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dfs.common.model.namenode.UserChangeEvent parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.dfs.common.model.namenode.UserChangeEvent parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dfs.common.model.namenode.UserChangeEvent parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dfs.common.model.namenode.UserChangeEvent parseFrom(
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
  public static Builder newBuilder(com.dfs.common.model.namenode.UserChangeEvent prototype) {
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
   * Protobuf type {@code com.ruyuan.dfs.common.proto.UserChangeEvent}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.ruyuan.dfs.common.proto.UserChangeEvent)
      com.dfs.common.model.namenode.UserChangeEventOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.dfs.common.model.namenode.Namenode.internal_static_com_ruyuan_dfs_common_proto_UserChangeEvent_descriptor;
    }

    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dfs.common.model.namenode.Namenode.internal_static_com_ruyuan_dfs_common_proto_UserChangeEvent_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.dfs.common.model.namenode.UserChangeEvent.class, com.dfs.common.model.namenode.UserChangeEvent.Builder.class);
    }

    // Construct using com.dfs.common.model.namenode.UserChangeEvent.newBuilder()
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
      eventType_ = 0;

      if (userEntityBuilder_ == null) {
        userEntity_ = null;
      } else {
        userEntity_ = null;
        userEntityBuilder_ = null;
      }
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.dfs.common.model.namenode.Namenode.internal_static_com_ruyuan_dfs_common_proto_UserChangeEvent_descriptor;
    }

    public com.dfs.common.model.namenode.UserChangeEvent getDefaultInstanceForType() {
      return getDefaultInstance();
    }

    public com.dfs.common.model.namenode.UserChangeEvent build() {
      com.dfs.common.model.namenode.UserChangeEvent result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.dfs.common.model.namenode.UserChangeEvent buildPartial() {
      com.dfs.common.model.namenode.UserChangeEvent result = new com.dfs.common.model.namenode.UserChangeEvent(this);
      result.eventType_ = eventType_;
      if (userEntityBuilder_ == null) {
        result.userEntity_ = userEntity_;
      } else {
        result.userEntity_ = userEntityBuilder_.build();
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
      if (other instanceof com.dfs.common.model.namenode.UserChangeEvent) {
        return mergeFrom((com.dfs.common.model.namenode.UserChangeEvent)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.dfs.common.model.namenode.UserChangeEvent other) {
      if (other == getDefaultInstance()) return this;
      if (other.getEventType() != 0) {
        setEventType(other.getEventType());
      }
      if (other.hasUserEntity()) {
        mergeUserEntity(other.getUserEntity());
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
      com.dfs.common.model.namenode.UserChangeEvent parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.dfs.common.model.namenode.UserChangeEvent) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int eventType_ ;
    /**
     * <code>optional int32 eventType = 1;</code>
     */
    public int getEventType() {
      return eventType_;
    }
    /**
     * <code>optional int32 eventType = 1;</code>
     */
    public Builder setEventType(int value) {
      
      eventType_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int32 eventType = 1;</code>
     */
    public Builder clearEventType() {
      
      eventType_ = 0;
      onChanged();
      return this;
    }

    private com.dfs.common.model.namenode.UserEntity userEntity_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.dfs.common.model.namenode.UserEntity, com.dfs.common.model.namenode.UserEntity.Builder, com.dfs.common.model.namenode.UserEntityOrBuilder> userEntityBuilder_;
    /**
     * <code>optional .com.ruyuan.dfs.common.proto.UserEntity userEntity = 2;</code>
     */
    public boolean hasUserEntity() {
      return userEntityBuilder_ != null || userEntity_ != null;
    }
    /**
     * <code>optional .com.ruyuan.dfs.common.proto.UserEntity userEntity = 2;</code>
     */
    public com.dfs.common.model.namenode.UserEntity getUserEntity() {
      if (userEntityBuilder_ == null) {
        return userEntity_ == null ? com.dfs.common.model.namenode.UserEntity.getDefaultInstance() : userEntity_;
      } else {
        return userEntityBuilder_.getMessage();
      }
    }
    /**
     * <code>optional .com.ruyuan.dfs.common.proto.UserEntity userEntity = 2;</code>
     */
    public Builder setUserEntity(com.dfs.common.model.namenode.UserEntity value) {
      if (userEntityBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        userEntity_ = value;
        onChanged();
      } else {
        userEntityBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>optional .com.ruyuan.dfs.common.proto.UserEntity userEntity = 2;</code>
     */
    public Builder setUserEntity(
        com.dfs.common.model.namenode.UserEntity.Builder builderForValue) {
      if (userEntityBuilder_ == null) {
        userEntity_ = builderForValue.build();
        onChanged();
      } else {
        userEntityBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>optional .com.ruyuan.dfs.common.proto.UserEntity userEntity = 2;</code>
     */
    public Builder mergeUserEntity(com.dfs.common.model.namenode.UserEntity value) {
      if (userEntityBuilder_ == null) {
        if (userEntity_ != null) {
          userEntity_ =
            com.dfs.common.model.namenode.UserEntity.newBuilder(userEntity_).mergeFrom(value).buildPartial();
        } else {
          userEntity_ = value;
        }
        onChanged();
      } else {
        userEntityBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>optional .com.ruyuan.dfs.common.proto.UserEntity userEntity = 2;</code>
     */
    public Builder clearUserEntity() {
      if (userEntityBuilder_ == null) {
        userEntity_ = null;
        onChanged();
      } else {
        userEntity_ = null;
        userEntityBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>optional .com.ruyuan.dfs.common.proto.UserEntity userEntity = 2;</code>
     */
    public com.dfs.common.model.namenode.UserEntity.Builder getUserEntityBuilder() {
      
      onChanged();
      return getUserEntityFieldBuilder().getBuilder();
    }
    /**
     * <code>optional .com.ruyuan.dfs.common.proto.UserEntity userEntity = 2;</code>
     */
    public com.dfs.common.model.namenode.UserEntityOrBuilder getUserEntityOrBuilder() {
      if (userEntityBuilder_ != null) {
        return userEntityBuilder_.getMessageOrBuilder();
      } else {
        return userEntity_ == null ?
            com.dfs.common.model.namenode.UserEntity.getDefaultInstance() : userEntity_;
      }
    }
    /**
     * <code>optional .com.ruyuan.dfs.common.proto.UserEntity userEntity = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.dfs.common.model.namenode.UserEntity, com.dfs.common.model.namenode.UserEntity.Builder, com.dfs.common.model.namenode.UserEntityOrBuilder> 
        getUserEntityFieldBuilder() {
      if (userEntityBuilder_ == null) {
        userEntityBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.dfs.common.model.namenode.UserEntity, com.dfs.common.model.namenode.UserEntity.Builder, com.dfs.common.model.namenode.UserEntityOrBuilder>(
                getUserEntity(),
                getParentForChildren(),
                isClean());
        userEntity_ = null;
      }
      return userEntityBuilder_;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:com.ruyuan.dfs.common.proto.UserChangeEvent)
  }

  // @@protoc_insertion_point(class_scope:com.ruyuan.dfs.common.proto.UserChangeEvent)
  private static final com.dfs.common.model.namenode.UserChangeEvent DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.dfs.common.model.namenode.UserChangeEvent();
  }

  public static com.dfs.common.model.namenode.UserChangeEvent getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<UserChangeEvent>
      PARSER = new com.google.protobuf.AbstractParser<UserChangeEvent>() {
    public UserChangeEvent parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new UserChangeEvent(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<UserChangeEvent> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<UserChangeEvent> getParserForType() {
    return PARSER;
  }

  public com.dfs.common.model.namenode.UserChangeEvent getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

