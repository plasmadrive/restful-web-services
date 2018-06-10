package com.plasmadrive.restfulwebservices.exception

import com.plasmadrive.restfulwebservices.user.UserNotFoundException
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.util.*

/**
 * Created by g on 09/06/2018.
 */

@ControllerAdvice
@RestController
class CustomisedResponseEntityHandler  : ResponseEntityExceptionHandler () {

    @ExceptionHandler(value = [UserNotFoundException::class])
    fun handleAllExceptions (ex : UserNotFoundException, req : WebRequest) : ResponseEntity<ExceptionResponse> {

        val exceptionResponse = ExceptionResponse(ex.message,req.getDescription(false), Date())

        return ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(value = [RuntimeException::class])
    fun handleAllExceptions (ex : RuntimeException, req : WebRequest) : ResponseEntity<ExceptionResponse> {

        val exceptionResponse = ExceptionResponse(ex.message,req.getDescription(false), Date())

        return ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR)
    }

    override fun handleMethodArgumentNotValid(ex: MethodArgumentNotValidException,
                                              headers: HttpHeaders,
                                              status: HttpStatus,
                                              request: WebRequest): ResponseEntity<Any> {
        val exceptionResponse = ExceptionResponse("Validation Failed", ex.bindingResult.toString(),Date())
        return ResponseEntity(exceptionResponse,HttpStatus.BAD_REQUEST)
    }
}