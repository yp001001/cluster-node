// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: dfs-client.proto

package com.dfs.common.model.client;

/**
 * Protobuf type {@code com.ruyuan.dfs.common.proto.GetDataNodeForFileResponse}
 */
public  final class GetDataNodeForFileResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.ruyuan.dfs.common.proto.GetDataNodeForFileResponse)
        GetDataNodeForFileResponseOrBuilder {
  // Use GetDataNodeForFileResponse.newBuilder() to construct.
  private GetDataNodeForFileResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private GetDataNodeForFileResponse() {
    realFileName_ = "";
  }

  @Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private GetDataNodeForFileResponse(
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
            com.dfs.common.model.common.DataNode.Builder subBuilder = null;
            if (dataNode_ != null) {
              subBuilder = dataNode_.toBuilder();
            }
            dataNode_ = input.readMessage(com.dfs.common.model.common.DataNode.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(dataNode_);
              dataNode_ = subBuilder.buildPartial();
            }

            break;
          }
          case 18: {
            String s = input.readStringRequireUtf8();

            realFileName_ = s;
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
    return com.dfs.common.model.client.DfsClient.internal_static_com_ruyuan_dfs_common_proto_GetDataNodeForFileResponse_descriptor;
  }

  protected FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.dfs.common.model.client.DfsClient.internal_static_com_ruyuan_dfs_common_proto_GetDataNodeForFileResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.dfs.common.model.client.GetDataNodeForFileResponse.class, com.dfs.common.model.client.GetDataNodeForFileResponse.Builder.class);
  }

  public static final int DATANODE_FIELD_NUMBER = 1;
  private com.dfs.common.model.common.DataNode dataNode_;
  /**
   * <code>optional .com.ruyuan.dfs.common.proto.DataNode dataNode = 1;</code>
   */
  public boolean hasDataNode() {
    return dataNode_ != null;
  }
  /**
   * <code>optional .com.ruyuan.dfs.common.proto.DataNode dataNode = 1;</code>
   */
  public com.dfs.common.model.common.DataNode getDataNode() {
    return dataNode_ == null ? com.dfs.common.model.common.DataNode.getDefaultInstance() : dataNode_;
  }
  /**
   * <code>optional .com.ruyuan.dfs.common.proto.DataNode dataNode = 1;</code>
   */
  public com.dfs.common.model.common.DataNodeOrBuilder getDataNodeOrBuilder() {
    return getDataNode();
  }

  public static final int REALFILENAME_FIELD_NUMBER = 2;
  private volatile Object realFileName_;
  /**
   * <code>optional string realFileName = 2;</code>
   */
  public String getRealFileName() {
    Object ref = realFileName_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      realFileName_ = s;
      return s;
    }
  }
  /**
   * <code>optional string realFileName = 2;</code>
   */
  public com.google.protobuf.ByteString
      getRealFileNameBytes() {
    Object ref = realFileName_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      realFileName_ = b;
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
    if (dataNode_ != null) {
      output.writeMessage(1, getDataNode());
    }
    if (!getRealFileNameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, realFileName_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (dataNode_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getDataNode());
    }
    if (!getRealFileNameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, realFileName_);
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
    if (!(obj instanceof com.dfs.common.model.client.GetDataNodeForFileResponse)) {
      return super.equals(obj);
    }
    com.dfs.common.model.client.GetDataNodeForFileResponse other = (com.dfs.common.model.client.GetDataNodeForFileResponse) obj;

    boolean result = true;
    result = result && (hasDataNode() == other.hasDataNode());
    if (hasDataNode()) {
      result = result && getDataNode()
          .equals(other.getDataNode());
    }
    result = result && getRealFileName()
        .equals(other.getRealFileName());
    return result;
  }

  @Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptorForType().hashCode();
    if (hasDataNode()) {
      hash = (37 * hash) + DATANODE_FIELD_NUMBER;
      hash = (53 * hash) + getDataNode().hashCode();
    }
    hash = (37 * hash) + REALFILENAME_FIELD_NUMBER;
    hash = (53 * hash) + getRealFileName().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.dfs.common.model.client.GetDataNodeForFileResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dfs.common.model.client.GetDataNodeForFileResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dfs.common.model.client.GetDataNodeForFileResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dfs.common.model.client.GetDataNodeForFileResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dfs.common.model.client.GetDataNodeForFileResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dfs.common.model.client.GetDataNodeForFileResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dfs.common.model.client.GetDataNodeForFileResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.dfs.common.model.client.GetDataNodeForFileResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dfs.common.model.client.GetDataNodeForFileResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dfs.common.model.client.GetDataNodeForFileResponse parseFrom(
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
  public static Builder newBuilder(com.dfs.common.model.client.GetDataNodeForFileResponse prototype) {
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
   * Protobuf type {@code com.ruyuan.dfs.common.proto.GetDataNodeForFileResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.ruyuan.dfs.common.proto.GetDataNodeForFileResponse)
      com.dfs.common.model.client.GetDataNodeForFileResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.dfs.common.model.client.DfsClient.internal_static_com_ruyuan_dfs_common_proto_GetDataNodeForFileResponse_descriptor;
    }

    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dfs.common.model.client.DfsClient.internal_static_com_ruyuan_dfs_common_proto_GetDataNodeForFileResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.dfs.common.model.client.GetDataNodeForFileResponse.class, com.dfs.common.model.client.GetDataNodeForFileResponse.Builder.class);
    }

    // Construct using com.dfs.common.model.client.GetDataNodeForFileResponse.newBuilder()
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
      if (dataNodeBuilder_ == null) {
        dataNode_ = null;
      } else {
        dataNode_ = null;
        dataNodeBuilder_ = null;
      }
      realFileName_ = "";

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.dfs.common.model.client.DfsClient.internal_static_com_ruyuan_dfs_common_proto_GetDataNodeForFileResponse_descriptor;
    }

    public com.dfs.common.model.client.GetDataNodeForFileResponse getDefaultInstanceForType() {
      return getDefaultInstance();
    }

    public com.dfs.common.model.client.GetDataNodeForFileResponse build() {
      com.dfs.common.model.client.GetDataNodeForFileResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.dfs.common.model.client.GetDataNodeForFileResponse buildPartial() {
      com.dfs.common.model.client.GetDataNodeForFileResponse result = new com.dfs.common.model.client.GetDataNodeForFileResponse(this);
      if (dataNodeBuilder_ == null) {
        result.dataNode_ = dataNode_;
      } else {
        result.dataNode_ = dataNodeBuilder_.build();
      }
      result.realFileName_ = realFileName_;
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
      if (other instanceof com.dfs.common.model.client.GetDataNodeForFileResponse) {
        return mergeFrom((com.dfs.common.model.client.GetDataNodeForFileResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.dfs.common.model.client.GetDataNodeForFileResponse other) {
      if (other == getDefaultInstance()) return this;
      if (other.hasDataNode()) {
        mergeDataNode(other.getDataNode());
      }
      if (!other.getRealFileName().isEmpty()) {
        realFileName_ = other.realFileName_;
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
      com.dfs.common.model.client.GetDataNodeForFileResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.dfs.common.model.client.GetDataNodeForFileResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private com.dfs.common.model.common.DataNode dataNode_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.dfs.common.model.common.DataNode, com.dfs.common.model.common.DataNode.Builder, com.dfs.common.model.common.DataNodeOrBuilder> dataNodeBuilder_;
    /**
     * <code>optional .com.ruyuan.dfs.common.proto.DataNode dataNode = 1;</code>
     */
    public boolean hasDataNode() {
      return dataNodeBuilder_ != null || dataNode_ != null;
    }
    /**
     * <code>optional .com.ruyuan.dfs.common.proto.DataNode dataNode = 1;</code>
     */
    public com.dfs.common.model.common.DataNode getDataNode() {
      if (dataNodeBuilder_ == null) {
        return dataNode_ == null ? com.dfs.common.model.common.DataNode.getDefaultInstance() : dataNode_;
      } else {
        return dataNodeBuilder_.getMessage();
      }
    }
    /**
     * <code>optional .com.ruyuan.dfs.common.proto.DataNode dataNode = 1;</code>
     */
    public Builder setDataNode(com.dfs.common.model.common.DataNode value) {
      if (dataNodeBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        dataNode_ = value;
        onChanged();
      } else {
        dataNodeBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>optional .com.ruyuan.dfs.common.proto.DataNode dataNode = 1;</code>
     */
    public Builder setDataNode(
        com.dfs.common.model.common.DataNode.Builder builderForValue) {
      if (dataNodeBuilder_ == null) {
        dataNode_ = builderForValue.build();
        onChanged();
      } else {
        dataNodeBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>optional .com.ruyuan.dfs.common.proto.DataNode dataNode = 1;</code>
     */
    public Builder mergeDataNode(com.dfs.common.model.common.DataNode value) {
      if (dataNodeBuilder_ == null) {
        if (dataNode_ != null) {
          dataNode_ =
            com.dfs.common.model.common.DataNode.newBuilder(dataNode_).mergeFrom(value).buildPartial();
        } else {
          dataNode_ = value;
        }
        onChanged();
      } else {
        dataNodeBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>optional .com.ruyuan.dfs.common.proto.DataNode dataNode = 1;</code>
     */
    public Builder clearDataNode() {
      if (dataNodeBuilder_ == null) {
        dataNode_ = null;
        onChanged();
      } else {
        dataNode_ = null;
        dataNodeBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>optional .com.ruyuan.dfs.common.proto.DataNode dataNode = 1;</code>
     */
    public com.dfs.common.model.common.DataNode.Builder getDataNodeBuilder() {
      
      onChanged();
      return getDataNodeFieldBuilder().getBuilder();
    }
    /**
     * <code>optional .com.ruyuan.dfs.common.proto.DataNode dataNode = 1;</code>
     */
    public com.dfs.common.model.common.DataNodeOrBuilder getDataNodeOrBuilder() {
      if (dataNodeBuilder_ != null) {
        return dataNodeBuilder_.getMessageOrBuilder();
      } else {
        return dataNode_ == null ?
            com.dfs.common.model.common.DataNode.getDefaultInstance() : dataNode_;
      }
    }
    /**
     * <code>optional .com.ruyuan.dfs.common.proto.DataNode dataNode = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.dfs.common.model.common.DataNode, com.dfs.common.model.common.DataNode.Builder, com.dfs.common.model.common.DataNodeOrBuilder> 
        getDataNodeFieldBuilder() {
      if (dataNodeBuilder_ == null) {
        dataNodeBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.dfs.common.model.common.DataNode, com.dfs.common.model.common.DataNode.Builder, com.dfs.common.model.common.DataNodeOrBuilder>(
                getDataNode(),
                getParentForChildren(),
                isClean());
        dataNode_ = null;
      }
      return dataNodeBuilder_;
    }

    private Object realFileName_ = "";
    /**
     * <code>optional string realFileName = 2;</code>
     */
    public String getRealFileName() {
      Object ref = realFileName_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        realFileName_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>optional string realFileName = 2;</code>
     */
    public com.google.protobuf.ByteString
        getRealFileNameBytes() {
      Object ref = realFileName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        realFileName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>optional string realFileName = 2;</code>
     */
    public Builder setRealFileName(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      realFileName_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional string realFileName = 2;</code>
     */
    public Builder clearRealFileName() {
      
      realFileName_ = getDefaultInstance().getRealFileName();
      onChanged();
      return this;
    }
    /**
     * <code>optional string realFileName = 2;</code>
     */
    public Builder setRealFileNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      realFileName_ = value;
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


    // @@protoc_insertion_point(builder_scope:com.ruyuan.dfs.common.proto.GetDataNodeForFileResponse)
  }

  // @@protoc_insertion_point(class_scope:com.ruyuan.dfs.common.proto.GetDataNodeForFileResponse)
  private static final com.dfs.common.model.client.GetDataNodeForFileResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.dfs.common.model.client.GetDataNodeForFileResponse();
  }

  public static com.dfs.common.model.client.GetDataNodeForFileResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<GetDataNodeForFileResponse>
      PARSER = new com.google.protobuf.AbstractParser<GetDataNodeForFileResponse>() {
    public GetDataNodeForFileResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new GetDataNodeForFileResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<GetDataNodeForFileResponse> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<GetDataNodeForFileResponse> getParserForType() {
    return PARSER;
  }

  public com.dfs.common.model.client.GetDataNodeForFileResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
