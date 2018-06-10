package com.plasmadrive.restfulwebservices

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

/**
 * Created by g on 06/06/18.
 */


@RestController
class HelloWorldController {
    @GetMapping(path = ["/hello-world"])
    fun helloWorld () : String {
        return "Hello, World"
    }

    @GetMapping(path=["hello-world-bean"])
    fun helloWorldBean() : HelloWorldBean {
        return HelloWorldBean("hello")
    }

    @GetMapping(path = ["hello-world-bean/path-variable/{message}"])
    fun helloWorldBean(@PathVariable message: String) : HelloWorldBean  {
        return HelloWorldBean(message)
    }
}

data class HelloWorldBean (val message: String)
