// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: commons.proto

package com.dfs.common.model.common;

/**
 * Protobuf type {@code com.ruyuan.dfs.common.proto.NettyPacketHeader}
 */
public  final class NettyPacketHeader extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.ruyuan.dfs.common.proto.NettyPacketHeader)
        NettyPacketHeaderOrBuilder {
  // Use NettyPacketHeader.newBuilder() to construct.
  private NettyPacketHeader(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private NettyPacketHeader() {
  }

  @Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private NettyPacketHeader(
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
              headers_ = com.google.protobuf.MapField.newMapField(
                  HeadersDefaultEntryHolder.defaultEntry);
              mutable_bitField0_ |= 0x00000001;
            }
            com.google.protobuf.MapEntry<String, String>
            headers__ = input.readMessage(
                HeadersDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
            headers_.getMutableMap().put(
                headers__.getKey(), headers__.getValue());
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
    return com.dfs.common.model.common.Commons.internal_static_com_ruyuan_dfs_common_proto_NettyPacketHeader_descriptor;
  }

  @SuppressWarnings({"rawtypes"})
  protected com.google.protobuf.MapField internalGetMapField(
      int number) {
    switch (number) {
      case 1:
        return internalGetHeaders();
      default:
        throw new RuntimeException(
            "Invalid map field number: " + number);
    }
  }
  protected FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.dfs.common.model.common.Commons.internal_static_com_ruyuan_dfs_common_proto_NettyPacketHeader_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.dfs.common.model.common.NettyPacketHeader.class, com.dfs.common.model.common.NettyPacketHeader.Builder.class);
  }

  public static final int HEADERS_FIELD_NUMBER = 1;
  private static final class HeadersDefaultEntryHolder {
    static final com.google.protobuf.MapEntry<
        String, String> defaultEntry =
            com.google.protobuf.MapEntry
            .<String, String>newDefaultInstance(
                com.dfs.common.model.common.Commons.internal_static_com_ruyuan_dfs_common_proto_NettyPacketHeader_HeadersEntry_descriptor, 
                com.google.protobuf.WireFormat.FieldType.STRING,
                "",
                com.google.protobuf.WireFormat.FieldType.STRING,
                "");
  }
  private com.google.protobuf.MapField<
      String, String> headers_;
  private com.google.protobuf.MapField<String, String>
  internalGetHeaders() {
    if (headers_ == null) {
      return com.google.protobuf.MapField.emptyMapField(
          HeadersDefaultEntryHolder.defaultEntry);
    }
    return headers_;
  }

  public int getHeadersCount() {
    return internalGetHeaders().getMap().size();
  }
  /**
   * <code>map&lt;string, string&gt; headers = 1;</code>
   */

  public boolean containsHeaders(
      String key) {
    if (key == null) { throw new NullPointerException(); }
    return internalGetHeaders().getMap().containsKey(key);
  }
  /**
   * Use {@link #getHeadersMap()} instead.
   */
  @Deprecated
  public java.util.Map<String, String> getHeaders() {
    return getHeadersMap();
  }
  /**
   * <code>map&lt;string, string&gt; headers = 1;</code>
   */

  public java.util.Map<String, String> getHeadersMap() {
    return internalGetHeaders().getMap();
  }
  /**
   * <code>map&lt;string, string&gt; headers = 1;</code>
   */

  public String getHeadersOrDefault(
      String key,
      String defaultValue) {
    if (key == null) { throw new NullPointerException(); }
    java.util.Map<String, String> map =
        internalGetHeaders().getMap();
    return map.containsKey(key) ? map.get(key) : defaultValue;
  }
  /**
   * <code>map&lt;string, string&gt; headers = 1;</code>
   */

  public String getHeadersOrThrow(
      String key) {
    if (key == null) { throw new NullPointerException(); }
    java.util.Map<String, String> map =
        internalGetHeaders().getMap();
    if (!map.containsKey(key)) {
      throw new IllegalArgumentException();
    }
    return map.get(key);
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
    com.google.protobuf.GeneratedMessageV3
      .serializeStringMapTo(
        output,
        internalGetHeaders(),
        HeadersDefaultEntryHolder.defaultEntry,
        1);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (java.util.Map.Entry<String, String> entry
         : internalGetHeaders().getMap().entrySet()) {
      com.google.protobuf.MapEntry<String, String>
      headers__ = HeadersDefaultEntryHolder.defaultEntry.newBuilderForType()
          .setKey(entry.getKey())
          .setValue(entry.getValue())
          .build();
      size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(1, headers__);
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
    if (!(obj instanceof com.dfs.common.model.common.NettyPacketHeader)) {
      return super.equals(obj);
    }
    com.dfs.common.model.common.NettyPacketHeader other = (com.dfs.common.model.common.NettyPacketHeader) obj;

    boolean result = true;
    result = result && internalGetHeaders().equals(
        other.internalGetHeaders());
    return result;
  }

  @Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptorForType().hashCode();
    if (!internalGetHeaders().getMap().isEmpty()) {
      hash = (37 * hash) + HEADERS_FIELD_NUMBER;
      hash = (53 * hash) + internalGetHeaders().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.dfs.common.model.common.NettyPacketHeader parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dfs.common.model.common.NettyPacketHeader parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dfs.common.model.common.NettyPacketHeader parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dfs.common.model.common.NettyPacketHeader parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dfs.common.model.common.NettyPacketHeader parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dfs.common.model.common.NettyPacketHeader parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dfs.common.model.common.NettyPacketHeader parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.dfs.common.model.common.NettyPacketHeader parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dfs.common.model.common.NettyPacketHeader parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dfs.common.model.common.NettyPacketHeader parseFrom(
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
  public static Builder newBuilder(com.dfs.common.model.common.NettyPacketHeader prototype) {
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
   * Protobuf type {@code com.ruyuan.dfs.common.proto.NettyPacketHeader}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.ruyuan.dfs.common.proto.NettyPacketHeader)
      com.dfs.common.model.common.NettyPacketHeaderOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.dfs.common.model.common.Commons.internal_static_com_ruyuan_dfs_common_proto_NettyPacketHeader_descriptor;
    }

    @SuppressWarnings({"rawtypes"})
    protected com.google.protobuf.MapField internalGetMapField(
        int number) {
      switch (number) {
        case 1:
          return internalGetHeaders();
        default:
          throw new RuntimeException(
              "Invalid map field number: " + number);
      }
    }
    @SuppressWarnings({"rawtypes"})
    protected com.google.protobuf.MapField internalGetMutableMapField(
        int number) {
      switch (number) {
        case 1:
          return internalGetMutableHeaders();
        default:
          throw new RuntimeException(
              "Invalid map field number: " + number);
      }
    }
    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dfs.common.model.common.Commons.internal_static_com_ruyuan_dfs_common_proto_NettyPacketHeader_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.dfs.common.model.common.NettyPacketHeader.class, com.dfs.common.model.common.NettyPacketHeader.Builder.class);
    }

    // Construct using com.dfs.common.model.common.NettyPacketHeader.newBuilder()
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
      internalGetMutableHeaders().clear();
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.dfs.common.model.common.Commons.internal_static_com_ruyuan_dfs_common_proto_NettyPacketHeader_descriptor;
    }

    public com.dfs.common.model.common.NettyPacketHeader getDefaultInstanceForType() {
      return getDefaultInstance();
    }

    public com.dfs.common.model.common.NettyPacketHeader build() {
      com.dfs.common.model.common.NettyPacketHeader result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.dfs.common.model.common.NettyPacketHeader buildPartial() {
      com.dfs.common.model.common.NettyPacketHeader result = new com.dfs.common.model.common.NettyPacketHeader(this);
      int from_bitField0_ = bitField0_;
      result.headers_ = internalGetHeaders();
      result.headers_.makeImmutable();
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
      if (other instanceof com.dfs.common.model.common.NettyPacketHeader) {
        return mergeFrom((com.dfs.common.model.common.NettyPacketHeader)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.dfs.common.model.common.NettyPacketHeader other) {
      if (other == getDefaultInstance()) return this;
      internalGetMutableHeaders().mergeFrom(
          other.internalGetHeaders());
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
      com.dfs.common.model.common.NettyPacketHeader parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.dfs.common.model.common.NettyPacketHeader) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private com.google.protobuf.MapField<
        String, String> headers_;
    private com.google.protobuf.MapField<String, String>
    internalGetHeaders() {
      if (headers_ == null) {
        return com.google.protobuf.MapField.emptyMapField(
            HeadersDefaultEntryHolder.defaultEntry);
      }
      return headers_;
    }
    private com.google.protobuf.MapField<String, String>
    internalGetMutableHeaders() {
      onChanged();;
      if (headers_ == null) {
        headers_ = com.google.protobuf.MapField.newMapField(
            HeadersDefaultEntryHolder.defaultEntry);
      }
      if (!headers_.isMutable()) {
        headers_ = headers_.copy();
      }
      return headers_;
    }

    public int getHeadersCount() {
      return internalGetHeaders().getMap().size();
    }
    /**
     * <code>map&lt;string, string&gt; headers = 1;</code>
     */

    public boolean containsHeaders(
        String key) {
      if (key == null) { throw new NullPointerException(); }
      return internalGetHeaders().getMap().containsKey(key);
    }
    /**
     * Use {@link #getHeadersMap()} instead.
     */
    @Deprecated
    public java.util.Map<String, String> getHeaders() {
      return getHeadersMap();
    }
    /**
     * <code>map&lt;string, string&gt; headers = 1;</code>
     */

    public java.util.Map<String, String> getHeadersMap() {
      return internalGetHeaders().getMap();
    }
    /**
     * <code>map&lt;string, string&gt; headers = 1;</code>
     */

    public String getHeadersOrDefault(
        String key,
        String defaultValue) {
      if (key == null) { throw new NullPointerException(); }
      java.util.Map<String, String> map =
          internalGetHeaders().getMap();
      return map.containsKey(key) ? map.get(key) : defaultValue;
    }
    /**
     * <code>map&lt;string, string&gt; headers = 1;</code>
     */

    public String getHeadersOrThrow(
        String key) {
      if (key == null) { throw new NullPointerException(); }
      java.util.Map<String, String> map =
          internalGetHeaders().getMap();
      if (!map.containsKey(key)) {
        throw new IllegalArgumentException();
      }
      return map.get(key);
    }

    public Builder clearHeaders() {
      getMutableHeaders().clear();
      return this;
    }
    /**
     * <code>map&lt;string, string&gt; headers = 1;</code>
     */

    public Builder removeHeaders(
        String key) {
      if (key == null) { throw new NullPointerException(); }
      getMutableHeaders().remove(key);
      return this;
    }
    /**
     * Use alternate mutation accessors instead.
     */
    @Deprecated
    public java.util.Map<String, String>
    getMutableHeaders() {
      return internalGetMutableHeaders().getMutableMap();
    }
    /**
     * <code>map&lt;string, string&gt; headers = 1;</code>
     */
    public Builder putHeaders(
        String key,
        String value) {
      if (key == null) { throw new NullPointerException(); }
      if (value == null) { throw new NullPointerException(); }
      getMutableHeaders().put(key, value);
      return this;
    }
    /**
     * <code>map&lt;string, string&gt; headers = 1;</code>
     */

    public Builder putAllHeaders(
        java.util.Map<String, String> values) {
      getMutableHeaders().putAll(values);
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


    // @@protoc_insertion_point(builder_scope:com.ruyuan.dfs.common.proto.NettyPacketHeader)
  }

  // @@protoc_insertion_point(class_scope:com.ruyuan.dfs.common.proto.NettyPacketHeader)
  private static final com.dfs.common.model.common.NettyPacketHeader DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.dfs.common.model.common.NettyPacketHeader();
  }

  public static com.dfs.common.model.common.NettyPacketHeader getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<NettyPacketHeader>
      PARSER = new com.google.protobuf.AbstractParser<NettyPacketHeader>() {
    public NettyPacketHeader parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new NettyPacketHeader(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<NettyPacketHeader> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<NettyPacketHeader> getParserForType() {
    return PARSER;
  }

  public com.dfs.common.model.common.NettyPacketHeader getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

