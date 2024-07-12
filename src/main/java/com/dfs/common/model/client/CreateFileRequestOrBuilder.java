// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: dfs-client.proto

package com.dfs.common.model.client;

public interface CreateFileRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.ruyuan.dfs.common.proto.CreateFileRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>optional string filename = 1;</code>
   */
  String getFilename();
  /**
   * <code>optional string filename = 1;</code>
   */
  com.google.protobuf.ByteString
      getFilenameBytes();

  /**
   * <code>optional int64 fileSize = 2;</code>
   */
  long getFileSize();

  /**
   * <code>map&lt;string, string&gt; attr = 3;</code>
   */
  int getAttrCount();
  /**
   * <code>map&lt;string, string&gt; attr = 3;</code>
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
   * <code>map&lt;string, string&gt; attr = 3;</code>
   */
  java.util.Map<String, String>
  getAttrMap();
  /**
   * <code>map&lt;string, string&gt; attr = 3;</code>
   */

  String getAttrOrDefault(
      String key,
      String defaultValue);
  /**
   * <code>map&lt;string, string&gt; attr = 3;</code>
   */

  String getAttrOrThrow(
      String key);
}
