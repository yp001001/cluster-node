// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: commons.proto

package com.dfs.common.model.common;

public interface NettyPacketHeaderOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.ruyuan.dfs.common.proto.NettyPacketHeader)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>map&lt;string, string&gt; headers = 1;</code>
   */
  int getHeadersCount();
  /**
   * <code>map&lt;string, string&gt; headers = 1;</code>
   */
  boolean containsHeaders(
      String key);
  /**
   * Use {@link #getHeadersMap()} instead.
   */
  @Deprecated
  java.util.Map<String, String>
  getHeaders();
  /**
   * <code>map&lt;string, string&gt; headers = 1;</code>
   */
  java.util.Map<String, String>
  getHeadersMap();
  /**
   * <code>map&lt;string, string&gt; headers = 1;</code>
   */

  String getHeadersOrDefault(
      String key,
      String defaultValue);
  /**
   * <code>map&lt;string, string&gt; headers = 1;</code>
   */

  String getHeadersOrThrow(
      String key);
}
