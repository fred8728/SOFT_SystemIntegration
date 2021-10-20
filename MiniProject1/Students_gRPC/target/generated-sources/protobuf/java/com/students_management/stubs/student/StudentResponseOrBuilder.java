// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: student.proto

package com.students_management.stubs.student;

public interface StudentResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.students_management.stubs.student.StudentResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string student_id = 1;</code>
   * @return The studentId.
   */
  java.lang.String getStudentId();
  /**
   * <code>string student_id = 1;</code>
   * @return The bytes for studentId.
   */
  com.google.protobuf.ByteString
      getStudentIdBytes();

  /**
   * <code>string name = 2;</code>
   * @return The name.
   */
  java.lang.String getName();
  /**
   * <code>string name = 2;</code>
   * @return The bytes for name.
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <code>int32 age = 3;</code>
   * @return The age.
   */
  int getAge();

  /**
   * <code>.com.students_management.stubs.student.Gender gender = 4;</code>
   * @return The enum numeric value on the wire for gender.
   */
  int getGenderValue();
  /**
   * <code>.com.students_management.stubs.student.Gender gender = 4;</code>
   * @return The gender.
   */
  com.students_management.stubs.student.Gender getGender();

  /**
   * <code>.com.students_management.stubs.student.Semester sem = 5;</code>
   * @return The enum numeric value on the wire for sem.
   */
  int getSemValue();
  /**
   * <code>.com.students_management.stubs.student.Semester sem = 5;</code>
   * @return The sem.
   */
  com.students_management.stubs.student.Semester getSem();

  /**
   * <code>.com.students_management.stubs.student.Grade billedkunst = 6;</code>
   * @return The enum numeric value on the wire for billedkunst.
   */
  int getBilledkunstValue();
  /**
   * <code>.com.students_management.stubs.student.Grade billedkunst = 6;</code>
   * @return The billedkunst.
   */
  com.students_management.stubs.student.Grade getBilledkunst();

  /**
   * <code>.com.students_management.stubs.student.Grade geografi = 7;</code>
   * @return The enum numeric value on the wire for geografi.
   */
  int getGeografiValue();
  /**
   * <code>.com.students_management.stubs.student.Grade geografi = 7;</code>
   * @return The geografi.
   */
  com.students_management.stubs.student.Grade getGeografi();

  /**
   * <code>.com.students_management.stubs.student.Grade haendarbejde = 8;</code>
   * @return The enum numeric value on the wire for haendarbejde.
   */
  int getHaendarbejdeValue();
  /**
   * <code>.com.students_management.stubs.student.Grade haendarbejde = 8;</code>
   * @return The haendarbejde.
   */
  com.students_management.stubs.student.Grade getHaendarbejde();
}