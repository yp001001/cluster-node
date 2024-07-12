// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: dfs-client.proto

package com.dfs.common.model.client;

public interface MkdirRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.ruyuan.dfs.common.proto.MkdirRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>optional string path = 1;</code>
   */
  String getPath();
  /**
   * <code>optional string path = 1;</code>
   */
  com.google.protobuf.ByteString
      getPathBytes();

  /**
   * <code>map&lt;string, string&gt; attr = 2;</code>
   */
  int getAttrCount();
  /**
   * <code>map&lt;string, string&gt; attr = 2;</code>
   */
  boolean containsAttr(
      String key);
  /**
   * Use {@link #getAttrMap()} instead.
   */
  @Deprecated
  java.util.Map<String, String>
  getAttr();
  /**
   * <code>map&lt;string, string&gt; attr = 2;</code>
   */
  java.util.Map<String, String>
  getAttrMap();
  /**
   * <code>map&lt;string, string&gt; attr = 2;</code>
   */

  String getAttrOrDefault(
      String key,
      String defaultValue);
  /**
   * <code>map&lt;string, string&gt; attr = 2;</code>
   */

  String getAttrOrThrow(
      String key);
}
