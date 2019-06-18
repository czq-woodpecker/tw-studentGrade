package com.tw.repository;

import com.tw.model.Student;

import java.util.*;

/**
 * @author: woodpecker
 * @Date: 2019/6/17 0:36
 * 用于存储学生信息
 */
public class StudentRepository {
    private static Map<String, Student> students = new HashMap<>();

    public static void addStudent(Student student) {
        students.put(student.getNumber(), student);
    }

    public static List<Student> getStudents(List<String> studentNumbers) {
        List<Student> stus = new ArrayList<>();
        for (Student student : students.values()) {
            if (studentNumbers.contains(student.getNumber())) {
                stus.add(student);
            }
        }
        return stus;
    }
}
