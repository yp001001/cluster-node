// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: datanode.proto

package com.dfs.common.model.datanode;

public interface PeerNodeAwareRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.ruyuan.dfs.common.proto.PeerNodeAwareRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>optional string peerDataNode = 1;</code>
   */
  String getPeerDataNode();
  /**
   * <code>optional string peerDataNode = 1;</code>
   */
  com.google.protobuf.ByteString
      getPeerDataNodeBytes();

  /**
   * <code>optional int32 dataNodeId = 2;</code>
   */
  int getDataNodeId();
}
