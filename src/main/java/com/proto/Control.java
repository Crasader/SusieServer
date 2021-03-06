// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Control.proto

package com.proto;

public final class Control {
  private Control() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  /**
   * Protobuf enum {@code E_DIR}
   */
  public enum E_DIR
      implements com.google.protobuf.ProtocolMessageEnum {
    /**
     * <pre>
     *左移动
     * </pre>
     *
     * <code>LEFT = 1;</code>
     */
    LEFT(1),
    /**
     * <pre>
     *右移动
     * </pre>
     *
     * <code>RIGHT = 2;</code>
     */
    RIGHT(2),
    /**
     * <pre>
     *回中
     * </pre>
     *
     * <code>CENTER = 3;</code>
     */
    CENTER(3),
    ;

    /**
     * <pre>
     *左移动
     * </pre>
     *
     * <code>LEFT = 1;</code>
     */
    public static final int LEFT_VALUE = 1;
    /**
     * <pre>
     *右移动
     * </pre>
     *
     * <code>RIGHT = 2;</code>
     */
    public static final int RIGHT_VALUE = 2;
    /**
     * <pre>
     *回中
     * </pre>
     *
     * <code>CENTER = 3;</code>
     */
    public static final int CENTER_VALUE = 3;


    public final int getNumber() {
      return value;
    }

    /**
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static E_DIR valueOf(int value) {
      return forNumber(value);
    }

    public static E_DIR forNumber(int value) {
      switch (value) {
        case 1: return LEFT;
        case 2: return RIGHT;
        case 3: return CENTER;
        default: return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<E_DIR>
        internalGetValueMap() {
      return internalValueMap;
    }
    private static final com.google.protobuf.Internal.EnumLiteMap<
        E_DIR> internalValueMap =
          new com.google.protobuf.Internal.EnumLiteMap<E_DIR>() {
            public E_DIR findValueByNumber(int number) {
              return E_DIR.forNumber(number);
            }
          };

    public final com.google.protobuf.Descriptors.EnumValueDescriptor
        getValueDescriptor() {
      return getDescriptor().getValues().get(ordinal());
    }
    public final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptorForType() {
      return getDescriptor();
    }
    public static final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptor() {
      return com.proto.Control.getDescriptor().getEnumTypes().get(0);
    }

    private static final E_DIR[] VALUES = values();

    public static E_DIR valueOf(
        com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
      if (desc.getType() != getDescriptor()) {
        throw new java.lang.IllegalArgumentException(
          "EnumValueDescriptor is not for this type.");
      }
      return VALUES[desc.getIndex()];
    }

    private final int value;

    private E_DIR(int value) {
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:E_DIR)
  }

  public interface MceControlOrBuilder extends
      // @@protoc_insertion_point(interface_extends:MceControl)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>required .E_DIR dir = 1;</code>
     */
    boolean hasDir();
    /**
     * <code>required .E_DIR dir = 1;</code>
     */
    com.proto.Control.E_DIR getDir();

    /**
     * <code>optional bool isMove = 2;</code>
     */
    boolean hasIsMove();
    /**
     * <code>optional bool isMove = 2;</code>
     */
    boolean getIsMove();
  }
  /**
   * <pre>
   * 控制协议
   * </pre>
   *
   * Protobuf type {@code MceControl}
   */
  public  static final class MceControl extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:MceControl)
      MceControlOrBuilder {
    // Use MceControl.newBuilder() to construct.
    private MceControl(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private MceControl() {
      dir_ = 1;
      isMove_ = false;
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private MceControl(
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
              int rawValue = input.readEnum();
              com.proto.Control.E_DIR value = com.proto.Control.E_DIR.valueOf(rawValue);
              if (value == null) {
                unknownFields.mergeVarintField(1, rawValue);
              } else {
                bitField0_ |= 0x00000001;
                dir_ = rawValue;
              }
              break;
            }
            case 16: {
              bitField0_ |= 0x00000002;
              isMove_ = input.readBool();
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
      return com.proto.Control.internal_static_MceControl_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.proto.Control.internal_static_MceControl_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.proto.Control.MceControl.class, com.proto.Control.MceControl.Builder.class);
    }

    private int bitField0_;
    public static final int DIR_FIELD_NUMBER = 1;
    private int dir_;
    /**
     * <code>required .E_DIR dir = 1;</code>
     */
    public boolean hasDir() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>required .E_DIR dir = 1;</code>
     */
    public com.proto.Control.E_DIR getDir() {
      com.proto.Control.E_DIR result = com.proto.Control.E_DIR.valueOf(dir_);
      return result == null ? com.proto.Control.E_DIR.LEFT : result;
    }

    public static final int ISMOVE_FIELD_NUMBER = 2;
    private boolean isMove_;
    /**
     * <code>optional bool isMove = 2;</code>
     */
    public boolean hasIsMove() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>optional bool isMove = 2;</code>
     */
    public boolean getIsMove() {
      return isMove_;
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      if (!hasDir()) {
        memoizedIsInitialized = 0;
        return false;
      }
      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeEnum(1, dir_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        output.writeBool(2, isMove_);
      }
      unknownFields.writeTo(output);
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeEnumSize(1, dir_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBoolSize(2, isMove_);
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
      if (!(obj instanceof com.proto.Control.MceControl)) {
        return super.equals(obj);
      }
      com.proto.Control.MceControl other = (com.proto.Control.MceControl) obj;

      boolean result = true;
      result = result && (hasDir() == other.hasDir());
      if (hasDir()) {
        result = result && dir_ == other.dir_;
      }
      result = result && (hasIsMove() == other.hasIsMove());
      if (hasIsMove()) {
        result = result && (getIsMove()
            == other.getIsMove());
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
      if (hasDir()) {
        hash = (37 * hash) + DIR_FIELD_NUMBER;
        hash = (53 * hash) + dir_;
      }
      if (hasIsMove()) {
        hash = (37 * hash) + ISMOVE_FIELD_NUMBER;
        hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
            getIsMove());
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.proto.Control.MceControl parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.proto.Control.MceControl parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.proto.Control.MceControl parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.proto.Control.MceControl parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.proto.Control.MceControl parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.proto.Control.MceControl parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.proto.Control.MceControl parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static com.proto.Control.MceControl parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.proto.Control.MceControl parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.proto.Control.MceControl parseFrom(
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
    public static Builder newBuilder(com.proto.Control.MceControl prototype) {
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
     * 控制协议
     * </pre>
     *
     * Protobuf type {@code MceControl}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:MceControl)
        com.proto.Control.MceControlOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.proto.Control.internal_static_MceControl_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.proto.Control.internal_static_MceControl_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.proto.Control.MceControl.class, com.proto.Control.MceControl.Builder.class);
      }

      // Construct using com.proto.Control.MceControl.newBuilder()
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
        dir_ = 1;
        bitField0_ = (bitField0_ & ~0x00000001);
        isMove_ = false;
        bitField0_ = (bitField0_ & ~0x00000002);
        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.proto.Control.internal_static_MceControl_descriptor;
      }

      public com.proto.Control.MceControl getDefaultInstanceForType() {
        return com.proto.Control.MceControl.getDefaultInstance();
      }

      public com.proto.Control.MceControl build() {
        com.proto.Control.MceControl result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public com.proto.Control.MceControl buildPartial() {
        com.proto.Control.MceControl result = new com.proto.Control.MceControl(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.dir_ = dir_;
        if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
          to_bitField0_ |= 0x00000002;
        }
        result.isMove_ = isMove_;
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
        if (other instanceof com.proto.Control.MceControl) {
          return mergeFrom((com.proto.Control.MceControl)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.proto.Control.MceControl other) {
        if (other == com.proto.Control.MceControl.getDefaultInstance()) return this;
        if (other.hasDir()) {
          setDir(other.getDir());
        }
        if (other.hasIsMove()) {
          setIsMove(other.getIsMove());
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        if (!hasDir()) {
          return false;
        }
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.proto.Control.MceControl parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.proto.Control.MceControl) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private int dir_ = 1;
      /**
       * <code>required .E_DIR dir = 1;</code>
       */
      public boolean hasDir() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <code>required .E_DIR dir = 1;</code>
       */
      public com.proto.Control.E_DIR getDir() {
        com.proto.Control.E_DIR result = com.proto.Control.E_DIR.valueOf(dir_);
        return result == null ? com.proto.Control.E_DIR.LEFT : result;
      }
      /**
       * <code>required .E_DIR dir = 1;</code>
       */
      public Builder setDir(com.proto.Control.E_DIR value) {
        if (value == null) {
          throw new NullPointerException();
        }
        bitField0_ |= 0x00000001;
        dir_ = value.getNumber();
        onChanged();
        return this;
      }
      /**
       * <code>required .E_DIR dir = 1;</code>
       */
      public Builder clearDir() {
        bitField0_ = (bitField0_ & ~0x00000001);
        dir_ = 1;
        onChanged();
        return this;
      }

      private boolean isMove_ ;
      /**
       * <code>optional bool isMove = 2;</code>
       */
      public boolean hasIsMove() {
        return ((bitField0_ & 0x00000002) == 0x00000002);
      }
      /**
       * <code>optional bool isMove = 2;</code>
       */
      public boolean getIsMove() {
        return isMove_;
      }
      /**
       * <code>optional bool isMove = 2;</code>
       */
      public Builder setIsMove(boolean value) {
        bitField0_ |= 0x00000002;
        isMove_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional bool isMove = 2;</code>
       */
      public Builder clearIsMove() {
        bitField0_ = (bitField0_ & ~0x00000002);
        isMove_ = false;
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


      // @@protoc_insertion_point(builder_scope:MceControl)
    }

    // @@protoc_insertion_point(class_scope:MceControl)
    private static final com.proto.Control.MceControl DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new com.proto.Control.MceControl();
    }

    public static com.proto.Control.MceControl getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    @java.lang.Deprecated public static final com.google.protobuf.Parser<MceControl>
        PARSER = new com.google.protobuf.AbstractParser<MceControl>() {
      public MceControl parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new MceControl(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<MceControl> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<MceControl> getParserForType() {
      return PARSER;
    }

    public com.proto.Control.MceControl getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_MceControl_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_MceControl_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\rControl.proto\"1\n\nMceControl\022\023\n\003dir\030\001 \002" +
      "(\0162\006.E_DIR\022\016\n\006isMove\030\002 \001(\010*(\n\005E_DIR\022\010\n\004L" +
      "EFT\020\001\022\t\n\005RIGHT\020\002\022\n\n\006CENTER\020\003B\024\n\tcom.prot" +
      "oB\007Control"
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
    internal_static_MceControl_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_MceControl_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_MceControl_descriptor,
        new java.lang.String[] { "Dir", "IsMove", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
