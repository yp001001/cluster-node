// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: commons.proto

package com.dfs.common.model.common;

public final class Commons {
  private Commons() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_ruyuan_dfs_common_proto_DataNode_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_ruyuan_dfs_common_proto_DataNode_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_ruyuan_dfs_common_proto_GetFileRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_ruyuan_dfs_common_proto_GetFileRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_ruyuan_dfs_common_proto_NettyPacketHeader_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_ruyuan_dfs_common_proto_NettyPacketHeader_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_ruyuan_dfs_common_proto_NettyPacketHeader_HeadersEntry_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_ruyuan_dfs_common_proto_NettyPacketHeader_HeadersEntry_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\rcommons.proto\022\033com.ruyuan.dfs.common.p" +
      "roto\"?\n\010DataNode\022\020\n\010hostname\030\001 \001(\t\022\017\n\007ni" +
      "oPort\030\002 \001(\005\022\020\n\010httpPort\030\003 \001(\005\"\"\n\016GetFile" +
      "Request\022\020\n\010filename\030\001 \001(\t\"\221\001\n\021NettyPacke" +
      "tHeader\022L\n\007headers\030\001 \003(\0132;.com.ruyuan.df" +
      "s.common.proto.NettyPacketHeader.Headers" +
      "Entry\032.\n\014HeadersEntry\022\013\n\003key\030\001 \001(\t\022\r\n\005va" +
      "lue\030\002 \001(\t:\0028\001B\037\n\033com.ruyuan.dfs.model.co" +
      "mmonP\001b\006proto3"
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
        }, assigner);
    internal_static_com_ruyuan_dfs_common_proto_DataNode_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_ruyuan_dfs_common_proto_DataNode_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_ruyuan_dfs_common_proto_DataNode_descriptor,
        new String[] { "Hostname", "NioPort", "HttpPort", });
    internal_static_com_ruyuan_dfs_common_proto_GetFileRequest_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_com_ruyuan_dfs_common_proto_GetFileRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_ruyuan_dfs_common_proto_GetFileRequest_descriptor,
        new String[] { "Filename", });
    internal_static_com_ruyuan_dfs_common_proto_NettyPacketHeader_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_com_ruyuan_dfs_common_proto_NettyPacketHeader_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_ruyuan_dfs_common_proto_NettyPacketHeader_descriptor,
        new String[] { "Headers", });
    internal_static_com_ruyuan_dfs_common_proto_NettyPacketHeader_HeadersEntry_descriptor =
      internal_static_com_ruyuan_dfs_common_proto_NettyPacketHeader_descriptor.getNestedTypes().get(0);
    internal_static_com_ruyuan_dfs_common_proto_NettyPacketHeader_HeadersEntry_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_ruyuan_dfs_common_proto_NettyPacketHeader_HeadersEntry_descriptor,
        new String[] { "Key", "Value", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
