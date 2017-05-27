// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: MseSyncVitality.proto

package com.proto;

public final class MseSyncVitalityOuterClass {
  private MseSyncVitalityOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface MseSyncVitalityOrBuilder extends
      // @@protoc_insertion_point(interface_extends:MseSyncVitality)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <pre>
     *当前体力值
     * </pre>
     *
     * <code>optional int32 value = 1 [default = -1];</code>
     */
    boolean hasValue();
    /**
     * <pre>
     *当前体力值
     * </pre>
     *
     * <code>optional int32 value = 1 [default = -1];</code>
     */
    int getValue();

    /**
     * <pre>
     *下一次增长体力的时间，系统时间（秒）
     * </pre>
     *
     * <code>optional int64 time = 2;</code>
     */
    boolean hasTime();
    /**
     * <pre>
     *下一次增长体力的时间，系统时间（秒）
     * </pre>
     *
     * <code>optional int64 time = 2;</code>
     */
    long getTime();
  }
  /**
   * <pre>
   *同步体力
   * </pre>
   *
   * Protobuf type {@code MseSyncVitality}
   */
  public  static final class MseSyncVitality extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:MseSyncVitality)
      MseSyncVitalityOrBuilder {
    // Use MseSyncVitality.newBuilder() to construct.
    private MseSyncVitality(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private MseSyncVitality() {
      value_ = -1;
      time_ = 0L;
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private MseSyncVitality(
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
              value_ = input.readInt32();
              break;
            }
            case 16: {
              bitField0_ |= 0x00000002;
              time_ = input.readInt64();
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
      return com.proto.MseSyncVitalityOuterClass.internal_static_MseSyncVitality_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.proto.MseSyncVitalityOuterClass.internal_static_MseSyncVitality_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.proto.MseSyncVitalityOuterClass.MseSyncVitality.class, com.proto.MseSyncVitalityOuterClass.MseSyncVitality.Builder.class);
    }

    private int bitField0_;
    public static final int VALUE_FIELD_NUMBER = 1;
    private int value_;
    /**
     * <pre>
     *当前体力值
     * </pre>
     *
     * <code>optional int32 value = 1 [default = -1];</code>
     */
    public boolean hasValue() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <pre>
     *当前体力值
     * </pre>
     *
     * <code>optional int32 value = 1 [default = -1];</code>
     */
    public int getValue() {
      return value_;
    }

    public static final int TIME_FIELD_NUMBER = 2;
    private long time_;
    /**
     * <pre>
     *下一次增长体力的时间，系统时间（秒）
     * </pre>
     *
     * <code>optional int64 time = 2;</code>
     */
    public boolean hasTime() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <pre>
     *下一次增长体力的时间，系统时间（秒）
     * </pre>
     *
     * <code>optional int64 time = 2;</code>
     */
    public long getTime() {
      return time_;
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
        output.writeInt32(1, value_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        output.writeInt64(2, time_);
      }
      unknownFields.writeTo(output);
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(1, value_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt64Size(2, time_);
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
      if (!(obj instanceof com.proto.MseSyncVitalityOuterClass.MseSyncVitality)) {
        return super.equals(obj);
      }
      com.proto.MseSyncVitalityOuterClass.MseSyncVitality other = (com.proto.MseSyncVitalityOuterClass.MseSyncVitality) obj;

      boolean result = true;
      result = result && (hasValue() == other.hasValue());
      if (hasValue()) {
        result = result && (getValue()
            == other.getValue());
      }
      result = result && (hasTime() == other.hasTime());
      if (hasTime()) {
        result = result && (getTime()
            == other.getTime());
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
      if (hasValue()) {
        hash = (37 * hash) + VALUE_FIELD_NUMBER;
        hash = (53 * hash) + getValue();
      }
      if (hasTime()) {
        hash = (37 * hash) + TIME_FIELD_NUMBER;
        hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
            getTime());
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.proto.MseSyncVitalityOuterClass.MseSyncVitality parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.proto.MseSyncVitalityOuterClass.MseSyncVitality parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.proto.MseSyncVitalityOuterClass.MseSyncVitality parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.proto.MseSyncVitalityOuterClass.MseSyncVitality parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.proto.MseSyncVitalityOuterClass.MseSyncVitality parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.proto.MseSyncVitalityOuterClass.MseSyncVitality parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.proto.MseSyncVitalityOuterClass.MseSyncVitality parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static com.proto.MseSyncVitalityOuterClass.MseSyncVitality parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.proto.MseSyncVitalityOuterClass.MseSyncVitality parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.proto.MseSyncVitalityOuterClass.MseSyncVitality parseFrom(
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
    public static Builder newBuilder(com.proto.MseSyncVitalityOuterClass.MseSyncVitality prototype) {
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
     * <pre>
     *同步体力
     * </pre>
     *
     * Protobuf type {@code MseSyncVitality}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:MseSyncVitality)
        com.proto.MseSyncVitalityOuterClass.MseSyncVitalityOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.proto.MseSyncVitalityOuterClass.internal_static_MseSyncVitality_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.proto.MseSyncVitalityOuterClass.internal_static_MseSyncVitality_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.proto.MseSyncVitalityOuterClass.MseSyncVitality.class, com.proto.MseSyncVitalityOuterClass.MseSyncVitality.Builder.class);
      }

      // Construct using com.proto.MseSyncVitalityOuterClass.MseSyncVitality.newBuilder()
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
        value_ = -1;
        bitField0_ = (bitField0_ & ~0x00000001);
        time_ = 0L;
        bitField0_ = (bitField0_ & ~0x00000002);
        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.proto.MseSyncVitalityOuterClass.internal_static_MseSyncVitality_descriptor;
      }

      public com.proto.MseSyncVitalityOuterClass.MseSyncVitality getDefaultInstanceForType() {
        return com.proto.MseSyncVitalityOuterClass.MseSyncVitality.getDefaultInstance();
      }

      public com.proto.MseSyncVitalityOuterClass.MseSyncVitality build() {
        com.proto.MseSyncVitalityOuterClass.MseSyncVitality result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public com.proto.MseSyncVitalityOuterClass.MseSyncVitality buildPartial() {
        com.proto.MseSyncVitalityOuterClass.MseSyncVitality result = new com.proto.MseSyncVitalityOuterClass.MseSyncVitality(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.value_ = value_;
        if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
          to_bitField0_ |= 0x00000002;
        }
        result.time_ = time_;
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
        if (other instanceof com.proto.MseSyncVitalityOuterClass.MseSyncVitality) {
          return mergeFrom((com.proto.MseSyncVitalityOuterClass.MseSyncVitality)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.proto.MseSyncVitalityOuterClass.MseSyncVitality other) {
        if (other == com.proto.MseSyncVitalityOuterClass.MseSyncVitality.getDefaultInstance()) return this;
        if (other.hasValue()) {
          setValue(other.getValue());
        }
        if (other.hasTime()) {
          setTime(other.getTime());
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
        com.proto.MseSyncVitalityOuterClass.MseSyncVitality parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.proto.MseSyncVitalityOuterClass.MseSyncVitality) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private int value_ = -1;
      /**
       * <pre>
       *当前体力值
       * </pre>
       *
       * <code>optional int32 value = 1 [default = -1];</code>
       */
      public boolean hasValue() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <pre>
       *当前体力值
       * </pre>
       *
       * <code>optional int32 value = 1 [default = -1];</code>
       */
      public int getValue() {
        return value_;
      }
      /**
       * <pre>
       *当前体力值
       * </pre>
       *
       * <code>optional int32 value = 1 [default = -1];</code>
       */
      public Builder setValue(int value) {
        bitField0_ |= 0x00000001;
        value_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       *当前体力值
       * </pre>
       *
       * <code>optional int32 value = 1 [default = -1];</code>
       */
      public Builder clearValue() {
        bitField0_ = (bitField0_ & ~0x00000001);
        value_ = -1;
        onChanged();
        return this;
      }

      private long time_ ;
      /**
       * <pre>
       *下一次增长体力的时间，系统时间（秒）
       * </pre>
       *
       * <code>optional int64 time = 2;</code>
       */
      public boolean hasTime() {
        return ((bitField0_ & 0x00000002) == 0x00000002);
      }
      /**
       * <pre>
       *下一次增长体力的时间，系统时间（秒）
       * </pre>
       *
       * <code>optional int64 time = 2;</code>
       */
      public long getTime() {
        return time_;
      }
      /**
       * <pre>
       *下一次增长体力的时间，系统时间（秒）
       * </pre>
       *
       * <code>optional int64 time = 2;</code>
       */
      public Builder setTime(long value) {
        bitField0_ |= 0x00000002;
        time_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       *下一次增长体力的时间，系统时间（秒）
       * </pre>
       *
       * <code>optional int64 time = 2;</code>
       */
      public Builder clearTime() {
        bitField0_ = (bitField0_ & ~0x00000002);
        time_ = 0L;
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


      // @@protoc_insertion_point(builder_scope:MseSyncVitality)
    }

    // @@protoc_insertion_point(class_scope:MseSyncVitality)
    private static final com.proto.MseSyncVitalityOuterClass.MseSyncVitality DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new com.proto.MseSyncVitalityOuterClass.MseSyncVitality();
    }

    public static com.proto.MseSyncVitalityOuterClass.MseSyncVitality getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    @java.lang.Deprecated public static final com.google.protobuf.Parser<MseSyncVitality>
        PARSER = new com.google.protobuf.AbstractParser<MseSyncVitality>() {
      public MseSyncVitality parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new MseSyncVitality(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<MseSyncVitality> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<MseSyncVitality> getParserForType() {
      return PARSER;
    }

    public com.proto.MseSyncVitalityOuterClass.MseSyncVitality getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_MseSyncVitality_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_MseSyncVitality_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\025MseSyncVitality.proto\"2\n\017MseSyncVitali" +
      "ty\022\021\n\005value\030\001 \001(\005:\002-1\022\014\n\004time\030\002 \001(\003B\013\n\tc" +
      "om.proto"
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
    internal_static_MseSyncVitality_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_MseSyncVitality_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_MseSyncVitality_descriptor,
        new java.lang.String[] { "Value", "Time", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}