package com.example.studentrdb;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.studentrdb.entity.Student;

import java.util.List;

@Dao
public interface StudentDAO {

    @Insert
    void insertStudent(Student student);

    @Query("SELECT * FROM STUDENT_TABLE")
    List<Student> getAllStudentList();

    @Query("DELETE FROM student_table")
    void deleteAll();

    // Reset auto-increment counter for student_table
    @Query("DELETE FROM sqlite_sequence WHERE name = 'student_table'")
    void resetAutoIncrement();
}
