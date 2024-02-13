package com.galecki.githubrepositoryfetcher.domain.model.server;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.galecki.githubrepositoryfetcher.domain.model.client.Owner;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Repo(String name, Owner owner) {
}
