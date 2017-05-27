// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: MceShipInfo.proto

package com.proto;

public final class MceShipInfoOuterClass {
  private MceShipInfoOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface MceShipInfoOrBuilder extends
      // @@protoc_insertion_point(interface_extends:MceShipInfo)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>optional int64 oid = 1;</code>
     */
    boolean hasOid();
    /**
     * <code>optional int64 oid = 1;</code>
     */
    long getOid();
  }
  /**
   * Protobuf type {@code MceShipInfo}
   */
  public  static final class MceShipInfo extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:MceShipInfo)
      MceShipInfoOrBuilder {
    // Use MceShipInfo.newBuilder() to construct.
    private MceShipInfo(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private MceShipInfo() {
      oid_ = 0L;
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private MceShipInfo(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 8: {
              bitField0_ |= 0x00000001;
              oid_ = input.readInt64();
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.proto.MceShipInfoOuterClass.internal_static_MceShipInfo_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.proto.MceShipInfoOuterClass.internal_static_MceShipInfo_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.proto.MceShipInfoOuterClass.MceShipInfo.class, com.proto.MceShipInfoOuterClass.MceShipInfo.Builder.class);
    }

    private int bitField0_;
    public static final int OID_FIELD_NUMBER = 1;
    private long oid_;
    /**
     * <code>optional int64 oid = 1;</code>
     */
    public boolean hasOid() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>optional int64 oid = 1;</code>
     */
    public long getOid() {
      return oid_;
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeInt64(1, oid_);
      }
      unknownFields.writeTo(output);
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt64Size(1, oid_);
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof com.proto.MceShipInfoOuterClass.MceShipInfo)) {
        return super.equals(obj);
      }
      com.proto.MceShipInfoOuterClass.MceShipInfo other = (com.proto.MceShipInfoOuterClass.MceShipInfo) obj;

      boolean result = true;
      result = result && (hasOid() == other.hasOid());
      if (hasOid()) {
        result = result && (getOid()
            == other.getOid());
      }
      result = result && unknownFields.equals(other.unknownFields);
      return result;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptorForType().hashCode();
      if (hasOid()) {
        hash = (37 * hash) + OID_FIELD_NUMBER;
        hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
            getOid());
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.proto.MceShipInfoOuterClass.MceShipInfo parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.proto.MceShipInfoOuterClass.MceShipInfo parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.proto.MceShipInfoOuterClass.MceShipInfo parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.proto.MceShipInfoOuterClass.MceShipInfo parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.proto.MceShipInfoOuterClass.MceShipInfo parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.proto.MceShipInfoOuterClass.MceShipInfo parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.proto.MceShipInfoOuterClass.MceShipInfo parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static com.proto.MceShipInfoOuterClass.MceShipInfo parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.proto.MceShipInfoOuterClass.MceShipInfo parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.proto.MceShipInfoOuterClass.MceShipInfo parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(com.proto.MceShipInfoOuterClass.MceShipInfo prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code MceShipInfo}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:MceShipInfo)
        com.proto.MceShipInfoOuterClass.MceShipInfoOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.proto.MceShipInfoOuterClass.internal_static_MceShipInfo_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.proto.MceShipInfoOuterClass.internal_static_MceShipInfo_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.proto.MceShipInfoOuterClass.MceShipInfo.class, com.proto.MceShipInfoOuterClass.MceShipInfo.Builder.class);
      }

      // Construct using com.proto.MceShipInfoOuterClass.MceShipInfo.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      public Builder clear() {
        super.clear();
        oid_ = 0L;
        bitField0_ = (bitField0_ & ~0x00000001);
        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.proto.MceShipInfoOuterClass.internal_static_MceShipInfo_descriptor;
      }

      public com.proto.MceShipInfoOuterClass.MceShipInfo getDefaultInstanceForType() {
        return com.proto.MceShipInfoOuterClass.MceShipInfo.getDefaultInstance();
      }

      public com.proto.MceShipInfoOuterClass.MceShipInfo build() {
        com.proto.MceShipInfoOuterClass.MceShipInfo result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public com.proto.MceShipInfoOuterClass.MceShipInfo buildPartial() {
        com.proto.MceShipInfoOuterClass.MceShipInfo result = new com.proto.MceShipInfoOuterClass.MceShipInfo(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.oid_ = oid_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder clone() {
        return (Builder) super.clone();
      }
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.setField(field, value);
      }
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.proto.MceShipInfoOuterClass.MceShipInfo) {
          return mergeFrom((com.proto.MceShipInfoOuterClass.MceShipInfo)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.proto.MceShipInfoOuterClass.MceShipInfo other) {
        if (other == com.proto.MceShipInfoOuterClass.MceShipInfo.getDefaultInstance()) return this;
        if (other.hasOid()) {
          setOid(other.getOid());
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.proto.MceShipInfoOuterClass.MceShipInfo parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.proto.MceShipInfoOuterClass.MceShipInfo) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private long oid_ ;
      /**
       * <code>optional int64 oid = 1;</code>
       */
      public boolean hasOid() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <code>optional int64 oid = 1;</code>
       */
      public long getOid() {
        return oid_;
      }
      /**
       * <code>optional int64 oid = 1;</code>
       */
      public Builder setOid(long value) {
        bitField0_ |= 0x00000001;
        oid_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional int64 oid = 1;</code>
       */
      public Builder clearOid() {
        bitField0_ = (bitField0_ & ~0x00000001);
        oid_ = 0L;
        onChanged();
        return this;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:MceShipInfo)
    }

    // @@protoc_insertion_point(class_scope:MceShipInfo)
    private static final com.proto.MceShipInfoOuterClass.MceShipInfo DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new com.proto.MceShipInfoOuterClass.MceShipInfo();
    }

    public static com.proto.MceShipInfoOuterClass.MceShipInfo getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    @java.lang.Deprecated public static final com.google.protobuf.Parser<MceShipInfo>
        PARSER = new com.google.protobuf.AbstractParser<MceShipInfo>() {
      public MceShipInfo parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new MceShipInfo(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<MceShipInfo> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<MceShipInfo> getParserForType() {
      return PARSER;
    }

    public com.proto.MceShipInfoOuterClass.MceShipInfo getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_MceShipInfo_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_MceShipInfo_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\021MceShipInfo.proto\"\032\n\013MceShipInfo\022\013\n\003oi" +
      "d\030\001 \001(\003B\013\n\tcom.proto"
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
    internal_static_MceShipInfo_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_MceShipInfo_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_MceShipInfo_descriptor,
        new java.lang.String[] { "Oid", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}