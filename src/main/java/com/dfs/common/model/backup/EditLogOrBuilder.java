// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: backupnode.proto

package com.dfs.common.model.backup;

public interface EditLogOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.ruyuan.dfs.common.proto.EditLog)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>optional int64 txId = 1;</code>
   */
  long getTxId();

  /**
   * <code>optional int32 opType = 2;</code>
   */
  int getOpType();

  /**
   * <code>optional string path = 3;</code>
   */
  String getPath();
  /**
   * <code>optional string path = 3;</code>
   */
  com.google.protobuf.ByteString
      getPathBytes();

  /**
   * <code>map&lt;string, string&gt; attr = 4;</code>
   */
  int getAttrCount();
  /**
   * <code>map&lt;string, string&gt; attr = 4;</code>
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
   * <code>map&lt;string, string&gt; attr = 4;</code>
   */
  java.util.Map<String, String>
  getAttrMap();
  /**
   * <code>map&lt;string, string&gt; attr = 4;</code>
   */

  String getAttrOrDefault(
      String key,
      String defaultValue);
  /**
   * <code>map&lt;string, string&gt; attr = 4;</code>
   */

  String getAttrOrThrow(
      String key);
}
