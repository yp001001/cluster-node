// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: namenode.proto

package com.dfs.common.model.namenode;

/**
 * Protobuf type {@code com.ruyuan.dfs.common.proto.RemoveFileOrDirRequest}
 */
public  final class RemoveFileOrDirRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.ruyuan.dfs.common.proto.RemoveFileOrDirRequest)
        RemoveFileOrDirRequestOrBuilder {
  // Use RemoveFileOrDirRequest.newBuilder() to construct.
  private RemoveFileOrDirRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private RemoveFileOrDirRequest() {
    files_ = com.google.protobuf.LazyStringArrayList.EMPTY;
  }

  @Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private RemoveFileOrDirRequest(
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
            if (!((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
              files_ = new com.google.protobuf.LazyStringArrayList();
              mutable_bitField0_ |= 0x00000001;
            }
            files_.add(s);
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
        files_ = files_.getUnmodifiableView();
      }
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.dfs.common.model.namenode.Namenode.internal_static_com_ruyuan_dfs_common_proto_RemoveFileOrDirRequest_descriptor;
  }

  protected FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.dfs.common.model.namenode.Namenode.internal_static_com_ruyuan_dfs_common_proto_RemoveFileOrDirRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.dfs.common.model.namenode.RemoveFileOrDirRequest.class, com.dfs.common.model.namenode.RemoveFileOrDirRequest.Builder.class);
  }

  public static final int FILES_FIELD_NUMBER = 1;
  private com.google.protobuf.LazyStringList files_;
  /**
   * <code>repeated string files = 1;</code>
   */
  public com.google.protobuf.ProtocolStringList
      getFilesList() {
    return files_;
  }
  /**
   * <code>repeated string files = 1;</code>
   */
  public int getFilesCount() {
    return files_.size();
  }
  /**
   * <code>repeated string files = 1;</code>
   */
  public String getFiles(int index) {
    return files_.get(index);
  }
  /**
   * <code>repeated string files = 1;</code>
   */
  public com.google.protobuf.ByteString
      getFilesBytes(int index) {
    return files_.getByteString(index);
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
    for (int i = 0; i < files_.size(); i++) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, files_.getRaw(i));
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    {
      int dataSize = 0;
      for (int i = 0; i < files_.size(); i++) {
        dataSize += computeStringSizeNoTag(files_.getRaw(i));
      }
      size += dataSize;
      size += 1 * getFilesList().size();
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
    if (!(obj instanceof com.dfs.common.model.namenode.RemoveFileOrDirRequest)) {
      return super.equals(obj);
    }
    com.dfs.common.model.namenode.RemoveFileOrDirRequest other = (com.dfs.common.model.namenode.RemoveFileOrDirRequest) obj;

    boolean result = true;
    result = result && getFilesList()
        .equals(other.getFilesList());
    return result;
  }

  @Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptorForType().hashCode();
    if (getFilesCount() > 0) {
      hash = (37 * hash) + FILES_FIELD_NUMBER;
      hash = (53 * hash) + getFilesList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.dfs.common.model.namenode.RemoveFileOrDirRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dfs.common.model.namenode.RemoveFileOrDirRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dfs.common.model.namenode.RemoveFileOrDirRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dfs.common.model.namenode.RemoveFileOrDirRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dfs.common.model.namenode.RemoveFileOrDirRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dfs.common.model.namenode.RemoveFileOrDirRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dfs.common.model.namenode.RemoveFileOrDirRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.dfs.common.model.namenode.RemoveFileOrDirRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dfs.common.model.namenode.RemoveFileOrDirRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dfs.common.model.namenode.RemoveFileOrDirRequest parseFrom(
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
  public static Builder newBuilder(com.dfs.common.model.namenode.RemoveFileOrDirRequest prototype) {
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
   * Protobuf type {@code com.ruyuan.dfs.common.proto.RemoveFileOrDirRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.ruyuan.dfs.common.proto.RemoveFileOrDirRequest)
      com.dfs.common.model.namenode.RemoveFileOrDirRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.dfs.common.model.namenode.Namenode.internal_static_com_ruyuan_dfs_common_proto_RemoveFileOrDirRequest_descriptor;
    }

    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dfs.common.model.namenode.Namenode.internal_static_com_ruyuan_dfs_common_proto_RemoveFileOrDirRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.dfs.common.model.namenode.RemoveFileOrDirRequest.class, com.dfs.common.model.namenode.RemoveFileOrDirRequest.Builder.class);
    }

    // Construct using com.dfs.common.model.namenode.RemoveFileOrDirRequest.newBuilder()
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
      files_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.dfs.common.model.namenode.Namenode.internal_static_com_ruyuan_dfs_common_proto_RemoveFileOrDirRequest_descriptor;
    }

    public com.dfs.common.model.namenode.RemoveFileOrDirRequest getDefaultInstanceForType() {
      return getDefaultInstance();
    }

    public com.dfs.common.model.namenode.RemoveFileOrDirRequest build() {
      com.dfs.common.model.namenode.RemoveFileOrDirRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.dfs.common.model.namenode.RemoveFileOrDirRequest buildPartial() {
      com.dfs.common.model.namenode.RemoveFileOrDirRequest result = new com.dfs.common.model.namenode.RemoveFileOrDirRequest(this);
      int from_bitField0_ = bitField0_;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        files_ = files_.getUnmodifiableView();
        bitField0_ = (bitField0_ & ~0x00000001);
      }
      result.files_ = files_;
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
      if (other instanceof com.dfs.common.model.namenode.RemoveFileOrDirRequest) {
        return mergeFrom((com.dfs.common.model.namenode.RemoveFileOrDirRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.dfs.common.model.namenode.RemoveFileOrDirRequest other) {
      if (other == getDefaultInstance()) return this;
      if (!other.files_.isEmpty()) {
        if (files_.isEmpty()) {
          files_ = other.files_;
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          ensureFilesIsMutable();
          files_.addAll(other.files_);
        }
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
      com.dfs.common.model.namenode.RemoveFileOrDirRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.dfs.common.model.namenode.RemoveFileOrDirRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private com.google.protobuf.LazyStringList files_ = com.google.protobuf.LazyStringArrayList.EMPTY;
    private void ensureFilesIsMutable() {
      if (!((bitField0_ & 0x00000001) == 0x00000001)) {
        files_ = new com.google.protobuf.LazyStringArrayList(files_);
        bitField0_ |= 0x00000001;
       }
    }
    /**
     * <code>repeated string files = 1;</code>
     */
    public com.google.protobuf.ProtocolStringList
        getFilesList() {
      return files_.getUnmodifiableView();
    }
    /**
     * <code>repeated string files = 1;</code>
     */
    public int getFilesCount() {
      return files_.size();
    }
    /**
     * <code>repeated string files = 1;</code>
     */
    public String getFiles(int index) {
      return files_.get(index);
    }
    /**
     * <code>repeated string files = 1;</code>
     */
    public com.google.protobuf.ByteString
        getFilesBytes(int index) {
      return files_.getByteString(index);
    }
    /**
     * <code>repeated string files = 1;</code>
     */
    public Builder setFiles(
        int index, String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureFilesIsMutable();
      files_.set(index, value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string files = 1;</code>
     */
    public Builder addFiles(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureFilesIsMutable();
      files_.add(value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string files = 1;</code>
     */
    public Builder addAllFiles(
        Iterable<String> values) {
      ensureFilesIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, files_);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string files = 1;</code>
     */
    public Builder clearFiles() {
      files_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string files = 1;</code>
     */
    public Builder addFilesBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      ensureFilesIsMutable();
      files_.add(value);
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


    // @@protoc_insertion_point(builder_scope:com.ruyuan.dfs.common.proto.RemoveFileOrDirRequest)
  }

  // @@protoc_insertion_point(class_scope:com.ruyuan.dfs.common.proto.RemoveFileOrDirRequest)
  private static final com.dfs.common.model.namenode.RemoveFileOrDirRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.dfs.common.model.namenode.RemoveFileOrDirRequest();
  }

  public static com.dfs.common.model.namenode.RemoveFileOrDirRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<RemoveFileOrDirRequest>
      PARSER = new com.google.protobuf.AbstractParser<RemoveFileOrDirRequest>() {
    public RemoveFileOrDirRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new RemoveFileOrDirRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<RemoveFileOrDirRequest> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<RemoveFileOrDirRequest> getParserForType() {
    return PARSER;
  }

  public com.dfs.common.model.namenode.RemoveFileOrDirRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

