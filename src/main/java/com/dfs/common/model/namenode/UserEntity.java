// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: namenode.proto

package com.dfs.common.model.namenode;

/**
 * Protobuf type {@code com.ruyuan.dfs.common.proto.UserEntity}
 */
public  final class UserEntity extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.ruyuan.dfs.common.proto.UserEntity)
        UserEntityOrBuilder {
  // Use UserEntity.newBuilder() to construct.
  private UserEntity(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private UserEntity() {
    username_ = "";
    secret_ = "";
    createTime_ = 0L;
  }

  @Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private UserEntity(
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

            username_ = s;
            break;
          }
          case 18: {
            String s = input.readStringRequireUtf8();

            secret_ = s;
            break;
          }
          case 26: {
            com.dfs.common.model.namenode.UserStorageEntity.Builder subBuilder = null;
            if (storage_ != null) {
              subBuilder = storage_.toBuilder();
            }
            storage_ = input.readMessage(com.dfs.common.model.namenode.UserStorageEntity.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(storage_);
              storage_ = subBuilder.buildPartial();
            }

            break;
          }
          case 32: {

            createTime_ = input.readInt64();
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
    return com.dfs.common.model.namenode.Namenode.internal_static_com_ruyuan_dfs_common_proto_UserEntity_descriptor;
  }

  protected FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.dfs.common.model.namenode.Namenode.internal_static_com_ruyuan_dfs_common_proto_UserEntity_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.dfs.common.model.namenode.UserEntity.class, com.dfs.common.model.namenode.UserEntity.Builder.class);
  }

  public static final int USERNAME_FIELD_NUMBER = 1;
  private volatile Object username_;
  /**
   * <code>optional string username = 1;</code>
   */
  public String getUsername() {
    Object ref = username_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      username_ = s;
      return s;
    }
  }
  /**
   * <code>optional string username = 1;</code>
   */
  public com.google.protobuf.ByteString
      getUsernameBytes() {
    Object ref = username_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      username_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int SECRET_FIELD_NUMBER = 2;
  private volatile Object secret_;
  /**
   * <code>optional string secret = 2;</code>
   */
  public String getSecret() {
    Object ref = secret_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      secret_ = s;
      return s;
    }
  }
  /**
   * <code>optional string secret = 2;</code>
   */
  public com.google.protobuf.ByteString
      getSecretBytes() {
    Object ref = secret_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      secret_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int STORAGE_FIELD_NUMBER = 3;
  private com.dfs.common.model.namenode.UserStorageEntity storage_;
  /**
   * <code>optional .com.ruyuan.dfs.common.proto.UserStorageEntity storage = 3;</code>
   */
  public boolean hasStorage() {
    return storage_ != null;
  }
  /**
   * <code>optional .com.ruyuan.dfs.common.proto.UserStorageEntity storage = 3;</code>
   */
  public com.dfs.common.model.namenode.UserStorageEntity getStorage() {
    return storage_ == null ? com.dfs.common.model.namenode.UserStorageEntity.getDefaultInstance() : storage_;
  }
  /**
   * <code>optional .com.ruyuan.dfs.common.proto.UserStorageEntity storage = 3;</code>
   */
  public com.dfs.common.model.namenode.UserStorageEntityOrBuilder getStorageOrBuilder() {
    return getStorage();
  }

  public static final int CREATETIME_FIELD_NUMBER = 4;
  private long createTime_;
  /**
   * <code>optional int64 createTime = 4;</code>
   */
  public long getCreateTime() {
    return createTime_;
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
    if (!getUsernameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, username_);
    }
    if (!getSecretBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, secret_);
    }
    if (storage_ != null) {
      output.writeMessage(3, getStorage());
    }
    if (createTime_ != 0L) {
      output.writeInt64(4, createTime_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getUsernameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, username_);
    }
    if (!getSecretBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, secret_);
    }
    if (storage_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(3, getStorage());
    }
    if (createTime_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(4, createTime_);
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
    if (!(obj instanceof com.dfs.common.model.namenode.UserEntity)) {
      return super.equals(obj);
    }
    com.dfs.common.model.namenode.UserEntity other = (com.dfs.common.model.namenode.UserEntity) obj;

    boolean result = true;
    result = result && getUsername()
        .equals(other.getUsername());
    result = result && getSecret()
        .equals(other.getSecret());
    result = result && (hasStorage() == other.hasStorage());
    if (hasStorage()) {
      result = result && getStorage()
          .equals(other.getStorage());
    }
    result = result && (getCreateTime()
        == other.getCreateTime());
    return result;
  }

  @Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptorForType().hashCode();
    hash = (37 * hash) + USERNAME_FIELD_NUMBER;
    hash = (53 * hash) + getUsername().hashCode();
    hash = (37 * hash) + SECRET_FIELD_NUMBER;
    hash = (53 * hash) + getSecret().hashCode();
    if (hasStorage()) {
      hash = (37 * hash) + STORAGE_FIELD_NUMBER;
      hash = (53 * hash) + getStorage().hashCode();
    }
    hash = (37 * hash) + CREATETIME_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getCreateTime());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.dfs.common.model.namenode.UserEntity parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dfs.common.model.namenode.UserEntity parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dfs.common.model.namenode.UserEntity parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dfs.common.model.namenode.UserEntity parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dfs.common.model.namenode.UserEntity parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dfs.common.model.namenode.UserEntity parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dfs.common.model.namenode.UserEntity parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.dfs.common.model.namenode.UserEntity parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dfs.common.model.namenode.UserEntity parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dfs.common.model.namenode.UserEntity parseFrom(
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
  public static Builder newBuilder(com.dfs.common.model.namenode.UserEntity prototype) {
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
   * Protobuf type {@code com.ruyuan.dfs.common.proto.UserEntity}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.ruyuan.dfs.common.proto.UserEntity)
      com.dfs.common.model.namenode.UserEntityOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.dfs.common.model.namenode.Namenode.internal_static_com_ruyuan_dfs_common_proto_UserEntity_descriptor;
    }

    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dfs.common.model.namenode.Namenode.internal_static_com_ruyuan_dfs_common_proto_UserEntity_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.dfs.common.model.namenode.UserEntity.class, com.dfs.common.model.namenode.UserEntity.Builder.class);
    }

    // Construct using com.dfs.common.model.namenode.UserEntity.newBuilder()
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
      username_ = "";

      secret_ = "";

      if (storageBuilder_ == null) {
        storage_ = null;
      } else {
        storage_ = null;
        storageBuilder_ = null;
      }
      createTime_ = 0L;

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.dfs.common.model.namenode.Namenode.internal_static_com_ruyuan_dfs_common_proto_UserEntity_descriptor;
    }

    public com.dfs.common.model.namenode.UserEntity getDefaultInstanceForType() {
      return getDefaultInstance();
    }

    public com.dfs.common.model.namenode.UserEntity build() {
      com.dfs.common.model.namenode.UserEntity result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.dfs.common.model.namenode.UserEntity buildPartial() {
      com.dfs.common.model.namenode.UserEntity result = new com.dfs.common.model.namenode.UserEntity(this);
      result.username_ = username_;
      result.secret_ = secret_;
      if (storageBuilder_ == null) {
        result.storage_ = storage_;
      } else {
        result.storage_ = storageBuilder_.build();
      }
      result.createTime_ = createTime_;
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
      if (other instanceof com.dfs.common.model.namenode.UserEntity) {
        return mergeFrom((com.dfs.common.model.namenode.UserEntity)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.dfs.common.model.namenode.UserEntity other) {
      if (other == getDefaultInstance()) return this;
      if (!other.getUsername().isEmpty()) {
        username_ = other.username_;
        onChanged();
      }
      if (!other.getSecret().isEmpty()) {
        secret_ = other.secret_;
        onChanged();
      }
      if (other.hasStorage()) {
        mergeStorage(other.getStorage());
      }
      if (other.getCreateTime() != 0L) {
        setCreateTime(other.getCreateTime());
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
      com.dfs.common.model.namenode.UserEntity parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.dfs.common.model.namenode.UserEntity) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private Object username_ = "";
    /**
     * <code>optional string username = 1;</code>
     */
    public String getUsername() {
      Object ref = username_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        username_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>optional string username = 1;</code>
     */
    public com.google.protobuf.ByteString
        getUsernameBytes() {
      Object ref = username_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        username_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>optional string username = 1;</code>
     */
    public Builder setUsername(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      username_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional string username = 1;</code>
     */
    public Builder clearUsername() {
      
      username_ = getDefaultInstance().getUsername();
      onChanged();
      return this;
    }
    /**
     * <code>optional string username = 1;</code>
     */
    public Builder setUsernameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      username_ = value;
      onChanged();
      return this;
    }

    private Object secret_ = "";
    /**
     * <code>optional string secret = 2;</code>
     */
    public String getSecret() {
      Object ref = secret_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        secret_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>optional string secret = 2;</code>
     */
    public com.google.protobuf.ByteString
        getSecretBytes() {
      Object ref = secret_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        secret_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>optional string secret = 2;</code>
     */
    public Builder setSecret(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      secret_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional string secret = 2;</code>
     */
    public Builder clearSecret() {
      
      secret_ = getDefaultInstance().getSecret();
      onChanged();
      return this;
    }
    /**
     * <code>optional string secret = 2;</code>
     */
    public Builder setSecretBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      secret_ = value;
      onChanged();
      return this;
    }

    private com.dfs.common.model.namenode.UserStorageEntity storage_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.dfs.common.model.namenode.UserStorageEntity, com.dfs.common.model.namenode.UserStorageEntity.Builder, com.dfs.common.model.namenode.UserStorageEntityOrBuilder> storageBuilder_;
    /**
     * <code>optional .com.ruyuan.dfs.common.proto.UserStorageEntity storage = 3;</code>
     */
    public boolean hasStorage() {
      return storageBuilder_ != null || storage_ != null;
    }
    /**
     * <code>optional .com.ruyuan.dfs.common.proto.UserStorageEntity storage = 3;</code>
     */
    public com.dfs.common.model.namenode.UserStorageEntity getStorage() {
      if (storageBuilder_ == null) {
        return storage_ == null ? com.dfs.common.model.namenode.UserStorageEntity.getDefaultInstance() : storage_;
      } else {
        return storageBuilder_.getMessage();
      }
    }
    /**
     * <code>optional .com.ruyuan.dfs.common.proto.UserStorageEntity storage = 3;</code>
     */
    public Builder setStorage(com.dfs.common.model.namenode.UserStorageEntity value) {
      if (storageBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        storage_ = value;
        onChanged();
      } else {
        storageBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>optional .com.ruyuan.dfs.common.proto.UserStorageEntity storage = 3;</code>
     */
    public Builder setStorage(
        com.dfs.common.model.namenode.UserStorageEntity.Builder builderForValue) {
      if (storageBuilder_ == null) {
        storage_ = builderForValue.build();
        onChanged();
      } else {
        storageBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>optional .com.ruyuan.dfs.common.proto.UserStorageEntity storage = 3;</code>
     */
    public Builder mergeStorage(com.dfs.common.model.namenode.UserStorageEntity value) {
      if (storageBuilder_ == null) {
        if (storage_ != null) {
          storage_ =
            com.dfs.common.model.namenode.UserStorageEntity.newBuilder(storage_).mergeFrom(value).buildPartial();
        } else {
          storage_ = value;
        }
        onChanged();
      } else {
        storageBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>optional .com.ruyuan.dfs.common.proto.UserStorageEntity storage = 3;</code>
     */
    public Builder clearStorage() {
      if (storageBuilder_ == null) {
        storage_ = null;
        onChanged();
      } else {
        storage_ = null;
        storageBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>optional .com.ruyuan.dfs.common.proto.UserStorageEntity storage = 3;</code>
     */
    public com.dfs.common.model.namenode.UserStorageEntity.Builder getStorageBuilder() {
      
      onChanged();
      return getStorageFieldBuilder().getBuilder();
    }
    /**
     * <code>optional .com.ruyuan.dfs.common.proto.UserStorageEntity storage = 3;</code>
     */
    public com.dfs.common.model.namenode.UserStorageEntityOrBuilder getStorageOrBuilder() {
      if (storageBuilder_ != null) {
        return storageBuilder_.getMessageOrBuilder();
      } else {
        return storage_ == null ?
            com.dfs.common.model.namenode.UserStorageEntity.getDefaultInstance() : storage_;
      }
    }
    /**
     * <code>optional .com.ruyuan.dfs.common.proto.UserStorageEntity storage = 3;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.dfs.common.model.namenode.UserStorageEntity, com.dfs.common.model.namenode.UserStorageEntity.Builder, com.dfs.common.model.namenode.UserStorageEntityOrBuilder> 
        getStorageFieldBuilder() {
      if (storageBuilder_ == null) {
        storageBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.dfs.common.model.namenode.UserStorageEntity, com.dfs.common.model.namenode.UserStorageEntity.Builder, com.dfs.common.model.namenode.UserStorageEntityOrBuilder>(
                getStorage(),
                getParentForChildren(),
                isClean());
        storage_ = null;
      }
      return storageBuilder_;
    }

    private long createTime_ ;
    /**
     * <code>optional int64 createTime = 4;</code>
     */
    public long getCreateTime() {
      return createTime_;
    }
    /**
     * <code>optional int64 createTime = 4;</code>
     */
    public Builder setCreateTime(long value) {
      
      createTime_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int64 createTime = 4;</code>
     */
    public Builder clearCreateTime() {
      
      createTime_ = 0L;
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


    // @@protoc_insertion_point(builder_scope:com.ruyuan.dfs.common.proto.UserEntity)
  }

  // @@protoc_insertion_point(class_scope:com.ruyuan.dfs.common.proto.UserEntity)
  private static final com.dfs.common.model.namenode.UserEntity DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.dfs.common.model.namenode.UserEntity();
  }

  public static com.dfs.common.model.namenode.UserEntity getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<UserEntity>
      PARSER = new com.google.protobuf.AbstractParser<UserEntity>() {
    public UserEntity parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new UserEntity(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<UserEntity> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<UserEntity> getParserForType() {
    return PARSER;
  }

  public com.dfs.common.model.namenode.UserEntity getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

