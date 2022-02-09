package com.axis.springlearn.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class Controller {
    @RequestMapping("/hello")
    fun helloworld() : String{
        return "hello"
    }
}