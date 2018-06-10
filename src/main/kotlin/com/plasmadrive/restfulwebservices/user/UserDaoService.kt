package com.plasmadrive.restfulwebservices.user


import java.util.*

/**
 * Created by g on 08/06/2018.
 */

class UserDaoService {
    companion object  UserDaoObject  {
        private var users : List<User> = listOf(User(1,"Adam", Date()), User(2,"Eve", Date()), User(3,"Charles", Date()))
        private var usersCount = 3
        fun findAll() : List<User> {
            return users
        }

        fun save(user: User) : User {
            if (user.id == null) {
                user.copy(id = ++usersCount)
            }
            users.plus(user)
            return user
        }

        fun find( id : Int) : User?{
            for (user in users) {
                if (user.id == id) {
                    return user
                }
            }
            return null
        }

    }

}
