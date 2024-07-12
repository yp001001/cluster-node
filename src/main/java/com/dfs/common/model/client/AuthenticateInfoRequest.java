// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: dfs-client.proto

package com.dfs.common.model.client;

/**
 * Protobuf type {@code com.ruyuan.dfs.common.proto.AuthenticateInfoRequest}
 */
public  final class AuthenticateInfoRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.ruyuan.dfs.common.proto.AuthenticateInfoRequest)
        AuthenticateInfoRequestOrBuilder {
  // Use AuthenticateInfoRequest.newBuilder() to construct.
  private AuthenticateInfoRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private AuthenticateInfoRequest() {
    authenticateInfo_ = "";
  }

  @Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private AuthenticateInfoRequest(
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

            authenticateInfo_ = s;
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
    return com.dfs.common.model.client.DfsClient.internal_static_com_ruyuan_dfs_common_proto_AuthenticateInfoRequest_descriptor;
  }

  protected FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.dfs.common.model.client.DfsClient.internal_static_com_ruyuan_dfs_common_proto_AuthenticateInfoRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.dfs.common.model.client.AuthenticateInfoRequest.class, com.dfs.common.model.client.AuthenticateInfoRequest.Builder.class);
  }

  public static final int AUTHENTICATEINFO_FIELD_NUMBER = 1;
  private volatile Object authenticateInfo_;
  /**
   * <code>optional string authenticateInfo = 1;</code>
   */
  public String getAuthenticateInfo() {
    Object ref = authenticateInfo_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      authenticateInfo_ = s;
      return s;
    }
  }
  /**
   * <code>optional string authenticateInfo = 1;</code>
   */
  public com.google.protobuf.ByteString
      getAuthenticateInfoBytes() {
    Object ref = authenticateInfo_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      authenticateInfo_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
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
    if (!getAuthenticateInfoBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, authenticateInfo_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getAuthenticateInfoBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, authenticateInfo_);
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
    if (!(obj instanceof com.dfs.common.model.client.AuthenticateInfoRequest)) {
      return super.equals(obj);
    }
    com.dfs.common.model.client.AuthenticateInfoRequest other = (com.dfs.common.model.client.AuthenticateInfoRequest) obj;

    boolean result = true;
    result = result && getAuthenticateInfo()
        .equals(other.getAuthenticateInfo());
    return result;
  }

  @Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptorForType().hashCode();
    hash = (37 * hash) + AUTHENTICATEINFO_FIELD_NUMBER;
    hash = (53 * hash) + getAuthenticateInfo().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.dfs.common.model.client.AuthenticateInfoRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dfs.common.model.client.AuthenticateInfoRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dfs.common.model.client.AuthenticateInfoRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dfs.common.model.client.AuthenticateInfoRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dfs.common.model.client.AuthenticateInfoRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dfs.common.model.client.AuthenticateInfoRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dfs.common.model.client.AuthenticateInfoRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.dfs.common.model.client.AuthenticateInfoRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dfs.common.model.client.AuthenticateInfoRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dfs.common.model.client.AuthenticateInfoRequest parseFrom(
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
  public static Builder newBuilder(com.dfs.common.model.client.AuthenticateInfoRequest prototype) {
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
   * Protobuf type {@code com.ruyuan.dfs.common.proto.AuthenticateInfoRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.ruyuan.dfs.common.proto.AuthenticateInfoRequest)
      com.dfs.common.model.client.AuthenticateInfoRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.dfs.common.model.client.DfsClient.internal_static_com_ruyuan_dfs_common_proto_AuthenticateInfoRequest_descriptor;
    }

    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dfs.common.model.client.DfsClient.internal_static_com_ruyuan_dfs_common_proto_AuthenticateInfoRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.dfs.common.model.client.AuthenticateInfoRequest.class, com.dfs.common.model.client.AuthenticateInfoRequest.Builder.class);
    }

    // Construct using com.dfs.common.model.client.AuthenticateInfoRequest.newBuilder()
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
      authenticateInfo_ = "";

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.dfs.common.model.client.DfsClient.internal_static_com_ruyuan_dfs_common_proto_AuthenticateInfoRequest_descriptor;
    }

    public com.dfs.common.model.client.AuthenticateInfoRequest getDefaultInstanceForType() {
      return getDefaultInstance();
    }

    public com.dfs.common.model.client.AuthenticateInfoRequest build() {
      com.dfs.common.model.client.AuthenticateInfoRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.dfs.common.model.client.AuthenticateInfoRequest buildPartial() {
      com.dfs.common.model.client.AuthenticateInfoRequest result = new com.dfs.common.model.client.AuthenticateInfoRequest(this);
      result.authenticateInfo_ = authenticateInfo_;
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
      if (other instanceof com.dfs.common.model.client.AuthenticateInfoRequest) {
        return mergeFrom((com.dfs.common.model.client.AuthenticateInfoRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.dfs.common.model.client.AuthenticateInfoRequest other) {
      if (other == getDefaultInstance()) return this;
      if (!other.getAuthenticateInfo().isEmpty()) {
        authenticateInfo_ = other.authenticateInfo_;
        onChanged();
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
      com.dfs.common.model.client.AuthenticateInfoRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.dfs.common.model.client.AuthenticateInfoRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private Object authenticateInfo_ = "";
    /**
     * <code>optional string authenticateInfo = 1;</code>
     */
    public String getAuthenticateInfo() {
      Object ref = authenticateInfo_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        authenticateInfo_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>optional string authenticateInfo = 1;</code>
     */
    public com.google.protobuf.ByteString
        getAuthenticateInfoBytes() {
      Object ref = authenticateInfo_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        authenticateInfo_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>optional string authenticateInfo = 1;</code>
     */
    public Builder setAuthenticateInfo(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      authenticateInfo_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional string authenticateInfo = 1;</code>
     */
    public Builder clearAuthenticateInfo() {
      
      authenticateInfo_ = getDefaultInstance().getAuthenticateInfo();
      onChanged();
      return this;
    }
    /**
     * <code>optional string authenticateInfo = 1;</code>
     */
    public Builder setAuthenticateInfoBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      authenticateInfo_ = value;
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


    // @@protoc_insertion_point(builder_scope:com.ruyuan.dfs.common.proto.AuthenticateInfoRequest)
  }

  // @@protoc_insertion_point(class_scope:com.ruyuan.dfs.common.proto.AuthenticateInfoRequest)
  private static final com.dfs.common.model.client.AuthenticateInfoRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.dfs.common.model.client.AuthenticateInfoRequest();
  }

  public static com.dfs.common.model.client.AuthenticateInfoRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<AuthenticateInfoRequest>
      PARSER = new com.google.protobuf.AbstractParser<AuthenticateInfoRequest>() {
    public AuthenticateInfoRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new AuthenticateInfoRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<AuthenticateInfoRequest> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<AuthenticateInfoRequest> getParserForType() {
    return PARSER;
  }

  public com.dfs.common.model.client.AuthenticateInfoRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

