package com.galecki.githubrepositoryfetcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class GitHubRepositoryFetcherApplication {

    public static void main(String[] args) {
        SpringApplication.run(GitHubRepositoryFetcherApplication.class, args);
    }

}
