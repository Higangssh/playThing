package com.the.playting

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@EnableJpaAuditing
@SpringBootApplication
class PlayTingApplication

fun main(args: Array<String>) {
    runApplication<PlayTingApplication>(*args)
}
