// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: backupnode.proto

package com.dfs.common.model.backup;

public final class Backupnode {
  private Backupnode() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_ruyuan_dfs_common_proto_FetchEditsLogResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_ruyuan_dfs_common_proto_FetchEditsLogResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_ruyuan_dfs_common_proto_FetchEditsLogRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_ruyuan_dfs_common_proto_FetchEditsLogRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_ruyuan_dfs_common_proto_EditLog_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_ruyuan_dfs_common_proto_EditLog_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_ruyuan_dfs_common_proto_EditLog_AttrEntry_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_ruyuan_dfs_common_proto_EditLog_AttrEntry_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_ruyuan_dfs_common_proto_INode_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_ruyuan_dfs_common_proto_INode_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_ruyuan_dfs_common_proto_INode_AttrEntry_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_ruyuan_dfs_common_proto_INode_AttrEntry_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_ruyuan_dfs_common_proto_BackupNodeInfo_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_ruyuan_dfs_common_proto_BackupNodeInfo_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_ruyuan_dfs_common_proto_NameNodeConf_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_ruyuan_dfs_common_proto_NameNodeConf_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_ruyuan_dfs_common_proto_NameNodeConf_ValuesEntry_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_ruyuan_dfs_common_proto_NameNodeConf_ValuesEntry_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_ruyuan_dfs_common_proto_BackupNodeSlots_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_ruyuan_dfs_common_proto_BackupNodeSlots_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_ruyuan_dfs_common_proto_BackupNodeSlots_SlotsEntry_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_ruyuan_dfs_common_proto_BackupNodeSlots_SlotsEntry_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\020backupnode.proto\022\033com.ruyuan.dfs.commo" +
      "n.proto\032\016namenode.proto\"\207\001\n\025FetchEditsLo" +
      "gResponse\0226\n\010editLogs\030\001 \003(\0132$.com.ruyuan" +
      ".dfs.common.proto.EditLog\0226\n\005users\030\002 \003(\013" +
      "2\'.com.ruyuan.dfs.common.proto.UserEntit" +
      "y\"7\n\024FetchEditsLogRequest\022\014\n\004txId\030\001 \001(\003\022" +
      "\021\n\tneedSlots\030\002 \001(\010\"\240\001\n\007EditLog\022\014\n\004txId\030\001" +
      " \001(\003\022\016\n\006opType\030\002 \001(\005\022\014\n\004path\030\003 \001(\t\022<\n\004at" +
      "tr\030\004 \003(\0132..com.ruyuan.dfs.common.proto.E" +
      "ditLog.AttrEntry\032+\n\tAttrEntry\022\013\n\003key\030\001 \001",
      "(\t\022\r\n\005value\030\002 \001(\t:\0028\001\"\302\001\n\005INode\022\014\n\004path\030" +
      "\001 \001(\t\022\014\n\004type\030\002 \001(\005\0224\n\010children\030\003 \003(\0132\"." +
      "com.ruyuan.dfs.common.proto.INode\022:\n\004att" +
      "r\030\004 \003(\0132,.com.ruyuan.dfs.common.proto.IN" +
      "ode.AttrEntry\032+\n\tAttrEntry\022\013\n\003key\030\001 \001(\t\022" +
      "\r\n\005value\030\002 \001(\t:\0028\001\"0\n\016BackupNodeInfo\022\020\n\010" +
      "hostname\030\001 \001(\t\022\014\n\004port\030\002 \001(\005\"\204\001\n\014NameNod" +
      "eConf\022E\n\006values\030\001 \003(\01325.com.ruyuan.dfs.c" +
      "ommon.proto.NameNodeConf.ValuesEntry\032-\n\013" +
      "ValuesEntry\022\013\n\003key\030\001 \001(\t\022\r\n\005value\030\002 \001(\t:",
      "\0028\001\"\207\001\n\017BackupNodeSlots\022F\n\005slots\030\001 \003(\01327" +
      ".com.ruyuan.dfs.common.proto.BackupNodeS" +
      "lots.SlotsEntry\032,\n\nSlotsEntry\022\013\n\003key\030\001 \001" +
      "(\005\022\r\n\005value\030\002 \001(\005:\0028\001B\037\n\033com.ruyuan.dfs." +
      "model.backupP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.dfs.common.model.namenode.Namenode.getDescriptor(),
        }, assigner);
    internal_static_com_ruyuan_dfs_common_proto_FetchEditsLogResponse_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_ruyuan_dfs_common_proto_FetchEditsLogResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_ruyuan_dfs_common_proto_FetchEditsLogResponse_descriptor,
        new String[] { "EditLogs", "Users", });
    internal_static_com_ruyuan_dfs_common_proto_FetchEditsLogRequest_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_com_ruyuan_dfs_common_proto_FetchEditsLogRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_ruyuan_dfs_common_proto_FetchEditsLogRequest_descriptor,
        new String[] { "TxId", "NeedSlots", });
    internal_static_com_ruyuan_dfs_common_proto_EditLog_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_com_ruyuan_dfs_common_proto_EditLog_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_ruyuan_dfs_common_proto_EditLog_descriptor,
        new String[] { "TxId", "OpType", "Path", "Attr", });
    internal_static_com_ruyuan_dfs_common_proto_EditLog_AttrEntry_descriptor =
      internal_static_com_ruyuan_dfs_common_proto_EditLog_descriptor.getNestedTypes().get(0);
    internal_static_com_ruyuan_dfs_common_proto_EditLog_AttrEntry_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_ruyuan_dfs_common_proto_EditLog_AttrEntry_descriptor,
        new String[] { "Key", "Value", });
    internal_static_com_ruyuan_dfs_common_proto_INode_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_com_ruyuan_dfs_common_proto_INode_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_ruyuan_dfs_common_proto_INode_descriptor,
        new String[] { "Path", "Type", "Children", "Attr", });
    internal_static_com_ruyuan_dfs_common_proto_INode_AttrEntry_descriptor =
      internal_static_com_ruyuan_dfs_common_proto_INode_descriptor.getNestedTypes().get(0);
    internal_static_com_ruyuan_dfs_common_proto_INode_AttrEntry_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_ruyuan_dfs_common_proto_INode_AttrEntry_descriptor,
        new String[] { "Key", "Value", });
    internal_static_com_ruyuan_dfs_common_proto_BackupNodeInfo_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_com_ruyuan_dfs_common_proto_BackupNodeInfo_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_ruyuan_dfs_common_proto_BackupNodeInfo_descriptor,
        new String[] { "Hostname", "Port", });
    internal_static_com_ruyuan_dfs_common_proto_NameNodeConf_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_com_ruyuan_dfs_common_proto_NameNodeConf_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_ruyuan_dfs_common_proto_NameNodeConf_descriptor,
        new String[] { "Values", });
    internal_static_com_ruyuan_dfs_common_proto_NameNodeConf_ValuesEntry_descriptor =
      internal_static_com_ruyuan_dfs_common_proto_NameNodeConf_descriptor.getNestedTypes().get(0);
    internal_static_com_ruyuan_dfs_common_proto_NameNodeConf_ValuesEntry_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_ruyuan_dfs_common_proto_NameNodeConf_ValuesEntry_descriptor,
        new String[] { "Key", "Value", });
    internal_static_com_ruyuan_dfs_common_proto_BackupNodeSlots_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_com_ruyuan_dfs_common_proto_BackupNodeSlots_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_ruyuan_dfs_common_proto_BackupNodeSlots_descriptor,
        new String[] { "Slots", });
    internal_static_com_ruyuan_dfs_common_proto_BackupNodeSlots_SlotsEntry_descriptor =
      internal_static_com_ruyuan_dfs_common_proto_BackupNodeSlots_descriptor.getNestedTypes().get(0);
    internal_static_com_ruyuan_dfs_common_proto_BackupNodeSlots_SlotsEntry_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_ruyuan_dfs_common_proto_BackupNodeSlots_SlotsEntry_descriptor,
        new String[] { "Key", "Value", });
    com.dfs.common.model.namenode.Namenode.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
