package com.plasmadrive.restfulwebservices

import org.springframework.web.bind.annotation.GetMapping
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
}