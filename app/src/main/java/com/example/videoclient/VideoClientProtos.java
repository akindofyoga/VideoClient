// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: videoclient.proto

package com.example.videoclient;

public final class VideoClientProtos {
    private VideoClientProtos() {}
    public static void registerAllExtensions(
            com.google.protobuf.ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(
            com.google.protobuf.ExtensionRegistry registry) {
        registerAllExtensions(
                (com.google.protobuf.ExtensionRegistryLite) registry);
    }
    public interface UpdateOrBuilder extends
            // @@protoc_insertion_point(interface_extends:videoclient.Update)
            com.google.protobuf.MessageOrBuilder {

        /**
         * <code>required string update_id = 1;</code>
         */
        boolean hasUpdateId();
        /**
         * <code>required string update_id = 1;</code>
         */
        java.lang.String getUpdateId();
        /**
         * <code>required string update_id = 1;</code>
         */
        com.google.protobuf.ByteString
        getUpdateIdBytes();

        /**
         * <code>required string payload = 2;</code>
         */
        boolean hasPayload();
        /**
         * <code>required string payload = 2;</code>
         */
        java.lang.String getPayload();
        /**
         * <code>required string payload = 2;</code>
         */
        com.google.protobuf.ByteString
        getPayloadBytes();
    }
    /**
     * Protobuf type {@code videoclient.Update}
     */
    public  static final class Update extends
            com.google.protobuf.GeneratedMessageV3 implements
            // @@protoc_insertion_point(message_implements:videoclient.Update)
            UpdateOrBuilder {
        // Use Update.newBuilder() to construct.
        private Update(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }
        private Update() {
            updateId_ = "";
            payload_ = "";
        }

        @java.lang.Override
        public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
            return this.unknownFields;
        }
        private Update(
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
                        case 10: {
                            com.google.protobuf.ByteString bs = input.readBytes();
                            bitField0_ |= 0x00000001;
                            updateId_ = bs;
                            break;
                        }
                        case 18: {
                            com.google.protobuf.ByteString bs = input.readBytes();
                            bitField0_ |= 0x00000002;
                            payload_ = bs;
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
            return com.example.videoclient.VideoClientProtos.internal_static_videoclient_Update_descriptor;
        }

        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return com.example.videoclient.VideoClientProtos.internal_static_videoclient_Update_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            com.example.videoclient.VideoClientProtos.Update.class, com.example.videoclient.VideoClientProtos.Update.Builder.class);
        }

        private int bitField0_;
        public static final int UPDATE_ID_FIELD_NUMBER = 1;
        private volatile java.lang.Object updateId_;
        /**
         * <code>required string update_id = 1;</code>
         */
        public boolean hasUpdateId() {
            return ((bitField0_ & 0x00000001) == 0x00000001);
        }
        /**
         * <code>required string update_id = 1;</code>
         */
        public java.lang.String getUpdateId() {
            java.lang.Object ref = updateId_;
            if (ref instanceof java.lang.String) {
                return (java.lang.String) ref;
            } else {
                com.google.protobuf.ByteString bs =
                        (com.google.protobuf.ByteString) ref;
                java.lang.String s = bs.toStringUtf8();
                if (bs.isValidUtf8()) {
                    updateId_ = s;
                }
                return s;
            }
        }
        /**
         * <code>required string update_id = 1;</code>
         */
        public com.google.protobuf.ByteString
        getUpdateIdBytes() {
            java.lang.Object ref = updateId_;
            if (ref instanceof java.lang.String) {
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8(
                                (java.lang.String) ref);
                updateId_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        public static final int PAYLOAD_FIELD_NUMBER = 2;
        private volatile java.lang.Object payload_;
        /**
         * <code>required string payload = 2;</code>
         */
        public boolean hasPayload() {
            return ((bitField0_ & 0x00000002) == 0x00000002);
        }
        /**
         * <code>required string payload = 2;</code>
         */
        public java.lang.String getPayload() {
            java.lang.Object ref = payload_;
            if (ref instanceof java.lang.String) {
                return (java.lang.String) ref;
            } else {
                com.google.protobuf.ByteString bs =
                        (com.google.protobuf.ByteString) ref;
                java.lang.String s = bs.toStringUtf8();
                if (bs.isValidUtf8()) {
                    payload_ = s;
                }
                return s;
            }
        }
        /**
         * <code>required string payload = 2;</code>
         */
        public com.google.protobuf.ByteString
        getPayloadBytes() {
            java.lang.Object ref = payload_;
            if (ref instanceof java.lang.String) {
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8(
                                (java.lang.String) ref);
                payload_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        private byte memoizedIsInitialized = -1;
        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            if (!hasUpdateId()) {
                memoizedIsInitialized = 0;
                return false;
            }
            if (!hasPayload()) {
                memoizedIsInitialized = 0;
                return false;
            }
            memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(com.google.protobuf.CodedOutputStream output)
                throws java.io.IOException {
            if (((bitField0_ & 0x00000001) == 0x00000001)) {
                com.google.protobuf.GeneratedMessageV3.writeString(output, 1, updateId_);
            }
            if (((bitField0_ & 0x00000002) == 0x00000002)) {
                com.google.protobuf.GeneratedMessageV3.writeString(output, 2, payload_);
            }
            unknownFields.writeTo(output);
        }

        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            if (((bitField0_ & 0x00000001) == 0x00000001)) {
                size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, updateId_);
            }
            if (((bitField0_ & 0x00000002) == 0x00000002)) {
                size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, payload_);
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
            if (!(obj instanceof com.example.videoclient.VideoClientProtos.Update)) {
                return super.equals(obj);
            }
            com.example.videoclient.VideoClientProtos.Update other = (com.example.videoclient.VideoClientProtos.Update) obj;

            boolean result = true;
            result = result && (hasUpdateId() == other.hasUpdateId());
            if (hasUpdateId()) {
                result = result && getUpdateId()
                        .equals(other.getUpdateId());
            }
            result = result && (hasPayload() == other.hasPayload());
            if (hasPayload()) {
                result = result && getPayload()
                        .equals(other.getPayload());
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
            if (hasUpdateId()) {
                hash = (37 * hash) + UPDATE_ID_FIELD_NUMBER;
                hash = (53 * hash) + getUpdateId().hashCode();
            }
            if (hasPayload()) {
                hash = (37 * hash) + PAYLOAD_FIELD_NUMBER;
                hash = (53 * hash) + getPayload().hashCode();
            }
            hash = (29 * hash) + unknownFields.hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static com.example.videoclient.VideoClientProtos.Update parseFrom(
                com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.example.videoclient.VideoClientProtos.Update parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.example.videoclient.VideoClientProtos.Update parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.example.videoclient.VideoClientProtos.Update parseFrom(
                byte[] data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.example.videoclient.VideoClientProtos.Update parseFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.example.videoclient.VideoClientProtos.Update parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.example.videoclient.VideoClientProtos.Update parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input);
        }
        public static com.example.videoclient.VideoClientProtos.Update parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.example.videoclient.VideoClientProtos.Update parseFrom(
                com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.example.videoclient.VideoClientProtos.Update parseFrom(
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
        public static Builder newBuilder(com.example.videoclient.VideoClientProtos.Update prototype) {
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
         * Protobuf type {@code videoclient.Update}
         */
        public static final class Builder extends
                com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
                // @@protoc_insertion_point(builder_implements:videoclient.Update)
                com.example.videoclient.VideoClientProtos.UpdateOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return com.example.videoclient.VideoClientProtos.internal_static_videoclient_Update_descriptor;
            }

            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internalGetFieldAccessorTable() {
                return com.example.videoclient.VideoClientProtos.internal_static_videoclient_Update_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                com.example.videoclient.VideoClientProtos.Update.class, com.example.videoclient.VideoClientProtos.Update.Builder.class);
            }

            // Construct using com.example.videoclient.VideoClientProtos.Update.newBuilder()
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
                updateId_ = "";
                bitField0_ = (bitField0_ & ~0x00000001);
                payload_ = "";
                bitField0_ = (bitField0_ & ~0x00000002);
                return this;
            }

            public com.google.protobuf.Descriptors.Descriptor
            getDescriptorForType() {
                return com.example.videoclient.VideoClientProtos.internal_static_videoclient_Update_descriptor;
            }

            public com.example.videoclient.VideoClientProtos.Update getDefaultInstanceForType() {
                return com.example.videoclient.VideoClientProtos.Update.getDefaultInstance();
            }

            public com.example.videoclient.VideoClientProtos.Update build() {
                com.example.videoclient.VideoClientProtos.Update result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            public com.example.videoclient.VideoClientProtos.Update buildPartial() {
                com.example.videoclient.VideoClientProtos.Update result = new com.example.videoclient.VideoClientProtos.Update(this);
                int from_bitField0_ = bitField0_;
                int to_bitField0_ = 0;
                if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
                    to_bitField0_ |= 0x00000001;
                }
                result.updateId_ = updateId_;
                if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
                    to_bitField0_ |= 0x00000002;
                }
                result.payload_ = payload_;
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
                if (other instanceof com.example.videoclient.VideoClientProtos.Update) {
                    return mergeFrom((com.example.videoclient.VideoClientProtos.Update)other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(com.example.videoclient.VideoClientProtos.Update other) {
                if (other == com.example.videoclient.VideoClientProtos.Update.getDefaultInstance()) return this;
                if (other.hasUpdateId()) {
                    bitField0_ |= 0x00000001;
                    updateId_ = other.updateId_;
                    onChanged();
                }
                if (other.hasPayload()) {
                    bitField0_ |= 0x00000002;
                    payload_ = other.payload_;
                    onChanged();
                }
                this.mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            public final boolean isInitialized() {
                if (!hasUpdateId()) {
                    return false;
                }
                if (!hasPayload()) {
                    return false;
                }
                return true;
            }

            public Builder mergeFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                com.example.videoclient.VideoClientProtos.Update parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (com.example.videoclient.VideoClientProtos.Update) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }
            private int bitField0_;

            private java.lang.Object updateId_ = "";
            /**
             * <code>required string update_id = 1;</code>
             */
            public boolean hasUpdateId() {
                return ((bitField0_ & 0x00000001) == 0x00000001);
            }
            /**
             * <code>required string update_id = 1;</code>
             */
            public java.lang.String getUpdateId() {
                java.lang.Object ref = updateId_;
                if (!(ref instanceof java.lang.String)) {
                    com.google.protobuf.ByteString bs =
                            (com.google.protobuf.ByteString) ref;
                    java.lang.String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        updateId_ = s;
                    }
                    return s;
                } else {
                    return (java.lang.String) ref;
                }
            }
            /**
             * <code>required string update_id = 1;</code>
             */
            public com.google.protobuf.ByteString
            getUpdateIdBytes() {
                java.lang.Object ref = updateId_;
                if (ref instanceof String) {
                    com.google.protobuf.ByteString b =
                            com.google.protobuf.ByteString.copyFromUtf8(
                                    (java.lang.String) ref);
                    updateId_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }
            /**
             * <code>required string update_id = 1;</code>
             */
            public Builder setUpdateId(
                    java.lang.String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000001;
                updateId_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>required string update_id = 1;</code>
             */
            public Builder clearUpdateId() {
                bitField0_ = (bitField0_ & ~0x00000001);
                updateId_ = getDefaultInstance().getUpdateId();
                onChanged();
                return this;
            }
            /**
             * <code>required string update_id = 1;</code>
             */
            public Builder setUpdateIdBytes(
                    com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000001;
                updateId_ = value;
                onChanged();
                return this;
            }

            private java.lang.Object payload_ = "";
            /**
             * <code>required string payload = 2;</code>
             */
            public boolean hasPayload() {
                return ((bitField0_ & 0x00000002) == 0x00000002);
            }
            /**
             * <code>required string payload = 2;</code>
             */
            public java.lang.String getPayload() {
                java.lang.Object ref = payload_;
                if (!(ref instanceof java.lang.String)) {
                    com.google.protobuf.ByteString bs =
                            (com.google.protobuf.ByteString) ref;
                    java.lang.String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        payload_ = s;
                    }
                    return s;
                } else {
                    return (java.lang.String) ref;
                }
            }
            /**
             * <code>required string payload = 2;</code>
             */
            public com.google.protobuf.ByteString
            getPayloadBytes() {
                java.lang.Object ref = payload_;
                if (ref instanceof String) {
                    com.google.protobuf.ByteString b =
                            com.google.protobuf.ByteString.copyFromUtf8(
                                    (java.lang.String) ref);
                    payload_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }
            /**
             * <code>required string payload = 2;</code>
             */
            public Builder setPayload(
                    java.lang.String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000002;
                payload_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>required string payload = 2;</code>
             */
            public Builder clearPayload() {
                bitField0_ = (bitField0_ & ~0x00000002);
                payload_ = getDefaultInstance().getPayload();
                onChanged();
                return this;
            }
            /**
             * <code>required string payload = 2;</code>
             */
            public Builder setPayloadBytes(
                    com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000002;
                payload_ = value;
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


            // @@protoc_insertion_point(builder_scope:videoclient.Update)
        }

        // @@protoc_insertion_point(class_scope:videoclient.Update)
        private static final com.example.videoclient.VideoClientProtos.Update DEFAULT_INSTANCE;
        static {
            DEFAULT_INSTANCE = new com.example.videoclient.VideoClientProtos.Update();
        }

        public static com.example.videoclient.VideoClientProtos.Update getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        @java.lang.Deprecated public static final com.google.protobuf.Parser<Update>
                PARSER = new com.google.protobuf.AbstractParser<Update>() {
            public Update parsePartialFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return new Update(input, extensionRegistry);
            }
        };

        public static com.google.protobuf.Parser<Update> parser() {
            return PARSER;
        }

        @java.lang.Override
        public com.google.protobuf.Parser<Update> getParserForType() {
            return PARSER;
        }

        public com.example.videoclient.VideoClientProtos.Update getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

    }

    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_videoclient_Update_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_videoclient_Update_fieldAccessorTable;

    public static com.google.protobuf.Descriptors.FileDescriptor
    getDescriptor() {
        return descriptor;
    }
    private static  com.google.protobuf.Descriptors.FileDescriptor
            descriptor;
    static {
        java.lang.String[] descriptorData = {
                "\n\021videoclient.proto\022\013videoclient\",\n\006Upda" +
                        "te\022\021\n\tupdate_id\030\001 \002(\t\022\017\n\007payload\030\002 \002(\tB," +
                        "\n\027com.example.videoclientB\021VideoClientPr" +
                        "otos"
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
        internal_static_videoclient_Update_descriptor =
                getDescriptor().getMessageTypes().get(0);
        internal_static_videoclient_Update_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_videoclient_Update_descriptor,
                new java.lang.String[] { "UpdateId", "Payload", });
    }

    // @@protoc_insertion_point(outer_class_scope)
}