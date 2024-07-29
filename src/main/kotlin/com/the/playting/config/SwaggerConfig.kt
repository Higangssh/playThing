package com.the.playting.config

import io.swagger.v3.oas.models.ExternalDocumentation
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springdoc.core.models.GroupedOpenApi
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
//    fun policyApi(): GroupedOpenApi {
//        return GroupedOpenApi.builder()
//            .group("Policy")
//            .pathsToMatch("/api/policies")
//            .build()
//    }


}