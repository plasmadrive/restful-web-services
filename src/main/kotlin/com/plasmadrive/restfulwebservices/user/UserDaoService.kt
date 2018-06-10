package com.plasmadrive.restfulwebservices.user


import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.ResponseStatus
import java.nio.file.attribute.UserPrincipalNotFoundException
import java.util.*

/**
 * Created by g on 08/06/2018.
 */

@Component
class UserDaoService {

    private var users: List<User> = listOf(
            User(1, "Adam", Date()),
            User(2, "Eve", Date()),
            User(3, "Charles", Date())
    )

    private var usersCount = 3

    fun findAll(): List<User> {
        return users
    }

    fun save(user: User): User {
        val idUser = User(user.id?:++usersCount,user.name,user.birthDate)

        users = users + idUser

        return  idUser
    }


    fun find(id: Int): User {
        return users.filter { user -> user.id == id }.firstOrNull()?:throw UserNotFoundException ("User : " + id + " not found")
    }

    fun deleteById(id : Int) : User {
        val index = users.indexOfFirst { user -> user.id == id }
        if (index != -1) {
            users = users.take(index) + users.takeLast((users.size - (index + 1)))
        }
        return users.elementAtOrNull(index)?:throw UserNotFoundException("User : " + id + "not found")
    }


}

@ResponseStatus(HttpStatus.NOT_FOUND)
class UserNotFoundException (message : String) : RuntimeException (message){

}
