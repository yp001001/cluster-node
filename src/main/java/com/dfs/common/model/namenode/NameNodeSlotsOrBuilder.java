// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: namenode.proto

package com.dfs.common.model.namenode;

public interface NameNodeSlotsOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.ruyuan.dfs.common.proto.NameNodeSlots)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>map&lt;int32, int32&gt; oldSlots = 1;</code>
   */
  int getOldSlotsCount();
  /**
   * <code>map&lt;int32, int32&gt; oldSlots = 1;</code>
   */
  boolean containsOldSlots(
      int key);
  /**
   * Use {@link #getOldSlotsMap()} instead.
   */
  @Deprecated
  java.util.Map<Integer, Integer>
  getOldSlots();
  /**
   * <code>map&lt;int32, int32&gt; oldSlots = 1;</code>
   */
  java.util.Map<Integer, Integer>
  getOldSlotsMap();
  /**
   * <code>map&lt;int32, int32&gt; oldSlots = 1;</code>
   */

  int getOldSlotsOrDefault(
      int key,
      int defaultValue);
  /**
   * <code>map&lt;int32, int32&gt; oldSlots = 1;</code>
   */

  int getOldSlotsOrThrow(
      int key);

  /**
   * <code>map&lt;int32, int32&gt; newSlots = 2;</code>
   */
  int getNewSlotsCount();
  /**
   * <code>map&lt;int32, int32&gt; newSlots = 2;</code>
   */
  boolean containsNewSlots(
      int key);
  /**
   * Use {@link #getNewSlotsMap()} instead.
   */
  @Deprecated
  java.util.Map<Integer, Integer>
  getNewSlots();
  /**
   * <code>map&lt;int32, int32&gt; newSlots = 2;</code>
   */
  java.util.Map<Integer, Integer>
  getNewSlotsMap();
  /**
   * <code>map&lt;int32, int32&gt; newSlots = 2;</code>
   */

  int getNewSlotsOrDefault(
      int key,
      int defaultValue);
  /**
   * <code>map&lt;int32, int32&gt; newSlots = 2;</code>
   */

  int getNewSlotsOrThrow(
      int key);

  /**
   * <code>optional bool rebalance = 3;</code>
   */
  boolean getRebalance();

  /**
   * <code>optional int32 rebalanceNodeId = 4;</code>
   */
  int getRebalanceNodeId();
}
