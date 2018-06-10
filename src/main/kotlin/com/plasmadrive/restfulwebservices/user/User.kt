package com.plasmadrive.restfulwebservices.user

import java.util.*
import javax.validation.constraints.Past
import javax.validation.constraints.Size

/**
 * Created by g on 08/06/2018.
 */
data class User (val id : Int?,
                 @get:Size(min = 2, message = "Name should have at least 2 chars")
                 val name : String,
                 @get:Past(message = "Birth Date must be in the past")
                 val birthDate : Date
                )
