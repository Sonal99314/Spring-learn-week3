package com.axis.springlearn

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AxisSpringBootDemoApplication

fun main(args: Array<String>) {
	runApplication<AxisSpringBootDemoApplication>(*args)
	println("hello world")


}
