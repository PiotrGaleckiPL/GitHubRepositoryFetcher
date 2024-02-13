package com.galecki.githubrepositoryfetcher.infrastructure.client.config;

import feign.codec.Decoder;
import feign.jackson.JacksonDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientConfig {

    @Bean
    Decoder feignDecoder() {
        return new JacksonDecoder();
    }
}
