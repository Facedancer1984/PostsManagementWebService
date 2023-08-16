/*
 * Copyright 2022-2023 GD Next GmbH (Golden Dimension) and involved open source parties.
 */

package com.epam.posts.web.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@RequiredArgsConstructor
public class SwaggerConfig implements WebMvcConfigurer {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                       .info(new Info().title("My app")
                                     .description("We forgot to add any description as we were in a hurry"));
    }
}
