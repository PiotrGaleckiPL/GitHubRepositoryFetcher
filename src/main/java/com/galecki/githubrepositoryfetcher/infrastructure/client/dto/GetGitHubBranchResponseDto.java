package com.galecki.githubrepositoryfetcher.infrastructure.client.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.galecki.githubrepositoryfetcher.domain.model.client.Commit;

@JsonIgnoreProperties(ignoreUnknown = true)
public record GetGitHubBranchResponseDto(String name, Commit commit) {
}
