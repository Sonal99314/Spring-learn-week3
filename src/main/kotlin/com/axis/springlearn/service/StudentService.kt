package com.axis.springlearn.service

import com.axis.springlearn.model.Student
import org.springframework.stereotype.Service

@Service
class StudentService {
    val students= mutableListOf<Student>(
        Student(1,"Ramesh", "male","ramesh@gmail.com", "37648645" ),
        Student(2,"mahesh","male","mahesh@gmail.com","38745643"),
        Student(3,"suresh","male","suresh@gmail.com","38795643")


    )
    fun getAll(): MutableList<Student> {
        return students
    }
}