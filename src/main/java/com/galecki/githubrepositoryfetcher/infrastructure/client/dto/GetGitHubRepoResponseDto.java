package com.galecki.githubrepositoryfetcher.infrastructure.client.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.galecki.githubrepositoryfetcher.domain.model.client.Owner;

@JsonIgnoreProperties(ignoreUnknown = true)
public record GetGitHubRepoResponseDto(String name, Owner owner, String fork) {
}
