// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: backupnode.proto

package com.dfs.common.model.backup;

public interface FetchEditsLogResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.ruyuan.dfs.common.proto.FetchEditsLogResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated .com.ruyuan.dfs.common.proto.EditLog editLogs = 1;</code>
   */
  java.util.List<com.dfs.common.model.backup.EditLog> 
      getEditLogsList();
  /**
   * <code>repeated .com.ruyuan.dfs.common.proto.EditLog editLogs = 1;</code>
   */
  com.dfs.common.model.backup.EditLog getEditLogs(int index);
  /**
   * <code>repeated .com.ruyuan.dfs.common.proto.EditLog editLogs = 1;</code>
   */
  int getEditLogsCount();
  /**
   * <code>repeated .com.ruyuan.dfs.common.proto.EditLog editLogs = 1;</code>
   */
  java.util.List<? extends com.dfs.common.model.backup.EditLogOrBuilder> 
      getEditLogsOrBuilderList();
  /**
   * <code>repeated .com.ruyuan.dfs.common.proto.EditLog editLogs = 1;</code>
   */
  com.dfs.common.model.backup.EditLogOrBuilder getEditLogsOrBuilder(
      int index);

  /**
   * <code>repeated .com.ruyuan.dfs.common.proto.UserEntity users = 2;</code>
   */
  java.util.List<com.dfs.common.model.namenode.UserEntity> 
      getUsersList();
  /**
   * <code>repeated .com.ruyuan.dfs.common.proto.UserEntity users = 2;</code>
   */
  com.dfs.common.model.namenode.UserEntity getUsers(int index);
  /**
   * <code>repeated .com.ruyuan.dfs.common.proto.UserEntity users = 2;</code>
   */
  int getUsersCount();
  /**
   * <code>repeated .com.ruyuan.dfs.common.proto.UserEntity users = 2;</code>
   */
  java.util.List<? extends com.dfs.common.model.namenode.UserEntityOrBuilder> 
      getUsersOrBuilderList();
  /**
   * <code>repeated .com.ruyuan.dfs.common.proto.UserEntity users = 2;</code>
   */
  com.dfs.common.model.namenode.UserEntityOrBuilder getUsersOrBuilder(
      int index);
}
