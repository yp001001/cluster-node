// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: namenode.proto

package com.dfs.common.model.namenode;

/**
 * Protobuf type {@code com.ruyuan.dfs.common.proto.ControllerVote}
 */
public  final class ControllerVote extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.ruyuan.dfs.common.proto.ControllerVote)
        ControllerVoteOrBuilder {
  // Use ControllerVote.newBuilder() to construct.
  private ControllerVote(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ControllerVote() {
    voterNodeId_ = 0;
    controllerNodeId_ = 0;
    voteRound_ = 0;
    force_ = false;
  }

  @Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private ControllerVote(
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

            voterNodeId_ = input.readInt32();
            break;
          }
          case 16: {

            controllerNodeId_ = input.readInt32();
            break;
          }
          case 24: {

            voteRound_ = input.readInt32();
            break;
          }
          case 32: {

            force_ = input.readBool();
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
    return com.dfs.common.model.namenode.Namenode.internal_static_com_ruyuan_dfs_common_proto_ControllerVote_descriptor;
  }

  protected FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.dfs.common.model.namenode.Namenode.internal_static_com_ruyuan_dfs_common_proto_ControllerVote_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.dfs.common.model.namenode.ControllerVote.class, com.dfs.common.model.namenode.ControllerVote.Builder.class);
  }

  public static final int VOTERNODEID_FIELD_NUMBER = 1;
  private int voterNodeId_;
  /**
   * <code>optional int32 voterNodeId = 1;</code>
   */
  public int getVoterNodeId() {
    return voterNodeId_;
  }

  public static final int CONTROLLERNODEID_FIELD_NUMBER = 2;
  private int controllerNodeId_;
  /**
   * <code>optional int32 controllerNodeId = 2;</code>
   */
  public int getControllerNodeId() {
    return controllerNodeId_;
  }

  public static final int VOTEROUND_FIELD_NUMBER = 3;
  private int voteRound_;
  /**
   * <code>optional int32 voteRound = 3;</code>
   */
  public int getVoteRound() {
    return voteRound_;
  }

  public static final int FORCE_FIELD_NUMBER = 4;
  private boolean force_;
  /**
   * <code>optional bool force = 4;</code>
   */
  public boolean getForce() {
    return force_;
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
    if (voterNodeId_ != 0) {
      output.writeInt32(1, voterNodeId_);
    }
    if (controllerNodeId_ != 0) {
      output.writeInt32(2, controllerNodeId_);
    }
    if (voteRound_ != 0) {
      output.writeInt32(3, voteRound_);
    }
    if (force_ != false) {
      output.writeBool(4, force_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (voterNodeId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, voterNodeId_);
    }
    if (controllerNodeId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, controllerNodeId_);
    }
    if (voteRound_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, voteRound_);
    }
    if (force_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(4, force_);
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
    if (!(obj instanceof com.dfs.common.model.namenode.ControllerVote)) {
      return super.equals(obj);
    }
    com.dfs.common.model.namenode.ControllerVote other = (com.dfs.common.model.namenode.ControllerVote) obj;

    boolean result = true;
    result = result && (getVoterNodeId()
        == other.getVoterNodeId());
    result = result && (getControllerNodeId()
        == other.getControllerNodeId());
    result = result && (getVoteRound()
        == other.getVoteRound());
    result = result && (getForce()
        == other.getForce());
    return result;
  }

  @Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptorForType().hashCode();
    hash = (37 * hash) + VOTERNODEID_FIELD_NUMBER;
    hash = (53 * hash) + getVoterNodeId();
    hash = (37 * hash) + CONTROLLERNODEID_FIELD_NUMBER;
    hash = (53 * hash) + getControllerNodeId();
    hash = (37 * hash) + VOTEROUND_FIELD_NUMBER;
    hash = (53 * hash) + getVoteRound();
    hash = (37 * hash) + FORCE_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getForce());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.dfs.common.model.namenode.ControllerVote parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dfs.common.model.namenode.ControllerVote parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dfs.common.model.namenode.ControllerVote parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dfs.common.model.namenode.ControllerVote parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dfs.common.model.namenode.ControllerVote parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dfs.common.model.namenode.ControllerVote parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dfs.common.model.namenode.ControllerVote parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.dfs.common.model.namenode.ControllerVote parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dfs.common.model.namenode.ControllerVote parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dfs.common.model.namenode.ControllerVote parseFrom(
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
  public static Builder newBuilder(com.dfs.common.model.namenode.ControllerVote prototype) {
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
   * Protobuf type {@code com.ruyuan.dfs.common.proto.ControllerVote}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.ruyuan.dfs.common.proto.ControllerVote)
      com.dfs.common.model.namenode.ControllerVoteOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.dfs.common.model.namenode.Namenode.internal_static_com_ruyuan_dfs_common_proto_ControllerVote_descriptor;
    }

    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dfs.common.model.namenode.Namenode.internal_static_com_ruyuan_dfs_common_proto_ControllerVote_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.dfs.common.model.namenode.ControllerVote.class, com.dfs.common.model.namenode.ControllerVote.Builder.class);
    }

    // Construct using com.dfs.common.model.namenode.ControllerVote.newBuilder()
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
      voterNodeId_ = 0;

      controllerNodeId_ = 0;

      voteRound_ = 0;

      force_ = false;

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.dfs.common.model.namenode.Namenode.internal_static_com_ruyuan_dfs_common_proto_ControllerVote_descriptor;
    }

    public com.dfs.common.model.namenode.ControllerVote getDefaultInstanceForType() {
      return getDefaultInstance();
    }

    public com.dfs.common.model.namenode.ControllerVote build() {
      com.dfs.common.model.namenode.ControllerVote result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.dfs.common.model.namenode.ControllerVote buildPartial() {
      com.dfs.common.model.namenode.ControllerVote result = new com.dfs.common.model.namenode.ControllerVote(this);
      result.voterNodeId_ = voterNodeId_;
      result.controllerNodeId_ = controllerNodeId_;
      result.voteRound_ = voteRound_;
      result.force_ = force_;
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
      if (other instanceof com.dfs.common.model.namenode.ControllerVote) {
        return mergeFrom((com.dfs.common.model.namenode.ControllerVote)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.dfs.common.model.namenode.ControllerVote other) {
      if (other == getDefaultInstance()) return this;
      if (other.getVoterNodeId() != 0) {
        setVoterNodeId(other.getVoterNodeId());
      }
      if (other.getControllerNodeId() != 0) {
        setControllerNodeId(other.getControllerNodeId());
      }
      if (other.getVoteRound() != 0) {
        setVoteRound(other.getVoteRound());
      }
      if (other.getForce() != false) {
        setForce(other.getForce());
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
      com.dfs.common.model.namenode.ControllerVote parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.dfs.common.model.namenode.ControllerVote) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int voterNodeId_ ;
    /**
     * <code>optional int32 voterNodeId = 1;</code>
     */
    public int getVoterNodeId() {
      return voterNodeId_;
    }
    /**
     * <code>optional int32 voterNodeId = 1;</code>
     */
    public Builder setVoterNodeId(int value) {
      
      voterNodeId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int32 voterNodeId = 1;</code>
     */
    public Builder clearVoterNodeId() {
      
      voterNodeId_ = 0;
      onChanged();
      return this;
    }

    private int controllerNodeId_ ;
    /**
     * <code>optional int32 controllerNodeId = 2;</code>
     */
    public int getControllerNodeId() {
      return controllerNodeId_;
    }
    /**
     * <code>optional int32 controllerNodeId = 2;</code>
     */
    public Builder setControllerNodeId(int value) {
      
      controllerNodeId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int32 controllerNodeId = 2;</code>
     */
    public Builder clearControllerNodeId() {
      
      controllerNodeId_ = 0;
      onChanged();
      return this;
    }

    private int voteRound_ ;
    /**
     * <code>optional int32 voteRound = 3;</code>
     */
    public int getVoteRound() {
      return voteRound_;
    }
    /**
     * <code>optional int32 voteRound = 3;</code>
     */
    public Builder setVoteRound(int value) {
      
      voteRound_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int32 voteRound = 3;</code>
     */
    public Builder clearVoteRound() {
      
      voteRound_ = 0;
      onChanged();
      return this;
    }

    private boolean force_ ;
    /**
     * <code>optional bool force = 4;</code>
     */
    public boolean getForce() {
      return force_;
    }
    /**
     * <code>optional bool force = 4;</code>
     */
    public Builder setForce(boolean value) {
      
      force_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional bool force = 4;</code>
     */
    public Builder clearForce() {
      
      force_ = false;
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


    // @@protoc_insertion_point(builder_scope:com.ruyuan.dfs.common.proto.ControllerVote)
  }

  // @@protoc_insertion_point(class_scope:com.ruyuan.dfs.common.proto.ControllerVote)
  private static final com.dfs.common.model.namenode.ControllerVote DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.dfs.common.model.namenode.ControllerVote();
  }

  public static com.dfs.common.model.namenode.ControllerVote getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ControllerVote>
      PARSER = new com.google.protobuf.AbstractParser<ControllerVote>() {
    public ControllerVote parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new ControllerVote(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ControllerVote> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<ControllerVote> getParserForType() {
    return PARSER;
  }

  public com.dfs.common.model.namenode.ControllerVote getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

