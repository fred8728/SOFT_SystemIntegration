// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: student.proto

package com.students_management.stubs.student;

/**
 * Protobuf enum {@code com.students_management.stubs.student.Semester}
 */
public enum Semester
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>SEM1 = 0;</code>
   */
  SEM1(0),
  /**
   * <code>SEM2 = 1;</code>
   */
  SEM2(1),
  /**
   * <code>SEM3 = 2;</code>
   */
  SEM3(2),
  UNRECOGNIZED(-1),
  ;

  /**
   * <code>SEM1 = 0;</code>
   */
  public static final int SEM1_VALUE = 0;
  /**
   * <code>SEM2 = 1;</code>
   */
  public static final int SEM2_VALUE = 1;
  /**
   * <code>SEM3 = 2;</code>
   */
  public static final int SEM3_VALUE = 2;


  public final int getNumber() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalArgumentException(
          "Can't get the number of an unknown enum value.");
    }
    return value;
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   * @deprecated Use {@link #forNumber(int)} instead.
   */
  @java.lang.Deprecated
  public static Semester valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static Semester forNumber(int value) {
    switch (value) {
      case 0: return SEM1;
      case 1: return SEM2;
      case 2: return SEM3;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<Semester>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      Semester> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<Semester>() {
          public Semester findValueByNumber(int number) {
            return Semester.forNumber(number);
          }
        };

  public final com.google.protobuf.Descriptors.EnumValueDescriptor
      getValueDescriptor() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalStateException(
          "Can't get the descriptor of an unrecognized enum value.");
    }
    return getDescriptor().getValues().get(ordinal());
  }
  public final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptorForType() {
    return getDescriptor();
  }
  public static final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptor() {
    return com.students_management.stubs.student.Student.getDescriptor().getEnumTypes().get(0);
  }

  private static final Semester[] VALUES = values();

  public static Semester valueOf(
      com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
    if (desc.getType() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "EnumValueDescriptor is not for this type.");
    }
    if (desc.getIndex() == -1) {
      return UNRECOGNIZED;
    }
    return VALUES[desc.getIndex()];
  }

  private final int value;

  private Semester(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:com.students_management.stubs.student.Semester)
}

