package com.serialization_test.controller

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post

@Controller
class HelloWorldController{

    @Post("/hello")
    fun hello(world: World): HttpResponse<String> {
        val msg = "Hello ${world.name}"
        print(msg)
        return HttpResponse.ok(msg)
    }

}

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class World(
    val type: String,
    val name: String
)


data class HelloWorldSetting(
    var locale: String,
)