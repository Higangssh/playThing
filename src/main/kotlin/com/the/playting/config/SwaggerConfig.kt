package com.the.playting.config

import io.swagger.v3.oas.models.ExternalDocumentation
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig {

    @Bean
    fun api(): OpenAPI {
        return OpenAPI()
            .info(
                Info().title("PlayThing Api")
                    .description("PlayThing 의 API Swagger 명세서")
                    .version("v1.0")
            )
            .externalDocs(
                ExternalDocumentation()
                    .description("Swagger Kotlin Documentation")
                    .url("https://springdoc.org")
            )
    }

//    @Bean
//    fun publicApi(): GroupedOpenApi {
//        return GroupedOpenApi.builder()
//            .group("public")
//            .pathsToMatch("/public/**")
//            .build()
//    }


}