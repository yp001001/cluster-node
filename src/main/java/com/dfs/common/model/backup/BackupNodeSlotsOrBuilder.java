// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: backupnode.proto

package com.dfs.common.model.backup;

public interface BackupNodeSlotsOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.ruyuan.dfs.common.proto.BackupNodeSlots)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>map&lt;int32, int32&gt; slots = 1;</code>
   */
  int getSlotsCount();
  /**
   * <code>map&lt;int32, int32&gt; slots = 1;</code>
   */
  boolean containsSlots(
      int key);
  /**
   * Use {@link #getSlotsMap()} instead.
   */
  @Deprecated
  java.util.Map<Integer, Integer>
  getSlots();
  /**
   * <code>map&lt;int32, int32&gt; slots = 1;</code>
   */
  java.util.Map<Integer, Integer>
  getSlotsMap();
  /**
   * <code>map&lt;int32, int32&gt; slots = 1;</code>
   */

  int getSlotsOrDefault(
      int key,
      int defaultValue);
  /**
   * <code>map&lt;int32, int32&gt; slots = 1;</code>
   */

  int getSlotsOrThrow(
      int key);
}
