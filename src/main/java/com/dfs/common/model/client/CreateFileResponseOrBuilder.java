// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: dfs-client.proto

package com.dfs.common.model.client;

public interface CreateFileResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.ruyuan.dfs.common.proto.CreateFileResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated .com.ruyuan.dfs.common.proto.DataNode dataNodes = 1;</code>
   */
  java.util.List<com.dfs.common.model.common.DataNode> 
      getDataNodesList();
  /**
   * <code>repeated .com.ruyuan.dfs.common.proto.DataNode dataNodes = 1;</code>
   */
  com.dfs.common.model.common.DataNode getDataNodes(int index);
  /**
   * <code>repeated .com.ruyuan.dfs.common.proto.DataNode dataNodes = 1;</code>
   */
  int getDataNodesCount();
  /**
   * <code>repeated .com.ruyuan.dfs.common.proto.DataNode dataNodes = 1;</code>
   */
  java.util.List<? extends com.dfs.common.model.common.DataNodeOrBuilder> 
      getDataNodesOrBuilderList();
  /**
   * <code>repeated .com.ruyuan.dfs.common.proto.DataNode dataNodes = 1;</code>
   */
  com.dfs.common.model.common.DataNodeOrBuilder getDataNodesOrBuilder(
      int index);

  /**
   * <code>optional string realFileName = 2;</code>
   */
  String getRealFileName();
  /**
   * <code>optional string realFileName = 2;</code>
   */
  com.google.protobuf.ByteString
      getRealFileNameBytes();
}
