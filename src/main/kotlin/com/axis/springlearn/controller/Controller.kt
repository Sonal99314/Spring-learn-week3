package com.axis.springlearn.controller

import com.axis.springlearn.model.Student
import com.axis.springlearn.service.StudentService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class Controller {
    @RequestMapping("/hello")
    fun helloworld() : String{
        return "hello"
    }
    @GetMapping("/students")
    fun getStudents(): Student{
        return StudentService.getAll()
    }
}