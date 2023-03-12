package com.example.routes

import com.example.models.ApiResponse
import com.example.repository.interfaces.IHeroRepository
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject
import java.lang.NumberFormatException

fun Route.getAllHeroes() {

    val heroRepository: IHeroRepository by inject()

    get("/boruto/heroes") {
        try {
            val page = call.request.queryParameters["page"]?.toInt() ?: 1
            require(page in 1..5)

            val apiResponse = heroRepository.getAllHeroes(page = page)
            call.respond(message = apiResponse, status = HttpStatusCode.OK)
        }
        catch(ex: NumberFormatException) {
            call.respond(
                message = ApiResponse(success = false, message = "Only numbers allowed."),
                status = HttpStatusCode.BadRequest
            )
        }
        catch (ex: IllegalArgumentException) {
            call.respond(
                message = ApiResponse(success = false, message = "Only numbers allowed."),
                status = HttpStatusCode.BadRequest
            )
        }
    }
}