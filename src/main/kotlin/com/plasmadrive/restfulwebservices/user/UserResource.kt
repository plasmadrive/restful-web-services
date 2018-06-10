package com.plasmadrive.restfulwebservices.user

import org.aspectj.weaver.tools.cache.SimpleCacheFactory.path
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import javax.validation.Valid

/**
 * Created by g on 09/06/2018.
 */

@RestController
class UserResource {

    @Autowired
    private lateinit var service : UserDaoService

    @GetMapping( path = ["/users"])
    fun retrieveAllUsers() :  List<User> {
        return service.findAll()
    }

    @GetMapping(path = ["/users/{id}"])
    fun findUser(@PathVariable id : Int) : User? {
        return service.find(id)
    }

    @PostMapping(path = ["/users"])
    fun createUser(@Valid @RequestBody user : User) : ResponseEntity<Any> {
        val savedUser = service.save(user)
        val location = ServletUriComponentsBuilder.
                fromCurrentRequest().
                path("/{id}").
                buildAndExpand(savedUser.id).
                toUri()
        return ResponseEntity.created(location).build()
    }

    @DeleteMapping(path = ["/users/{id}"])
    fun deleteUser (@PathVariable id : Int) : Unit {
        service.deleteById(id)

    }
}