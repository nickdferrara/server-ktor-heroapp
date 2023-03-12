package com.example.plugins

import com.example.routes.getAllHeroes
import com.example.routes.searchHeroes
import io.ktor.server.routing.*
import io.ktor.server.application.*
import io.ktor.server.http.content.*

fun Application.configureRouting() {
    routing {
        getAllHeroes()
        searchHeroes()

        static("/images" ) {
            resources("images")
        }
    }
}
