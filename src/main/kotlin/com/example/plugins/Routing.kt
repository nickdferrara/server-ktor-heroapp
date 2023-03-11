package com.example.plugins

import com.example.routes.getAllHeroes
import io.ktor.server.routing.*
import io.ktor.server.application.*
import io.ktor.server.http.content.*

fun Application.configureRouting() {
    routing {
        getAllHeroes()

        static("/images" ) {
            resources("images")
        }
    }
}
