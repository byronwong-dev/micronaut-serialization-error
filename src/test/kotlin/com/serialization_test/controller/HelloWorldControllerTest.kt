package com.serialization_test.controller

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.micronaut.context.annotation.Property
import io.micronaut.http.HttpRequest
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.kotest.annotation.MicronautTest

@MicronautTest
class HelloWorldControllerTest(
    @Client("/")
    val httpClient: HttpClient,
    @Property(name = "settings")
    val prop: List<HelloWorldSetting>
): FunSpec({

    test("can load property") {
        prop.size shouldBe 1
    }

    test("can serialize") {
        val response = httpClient.toBlocking().retrieve(HttpRequest.POST("/hello", World(name = "Jurassic", type = "new")))
        response shouldBe "Hello Jurassic"
    }

})