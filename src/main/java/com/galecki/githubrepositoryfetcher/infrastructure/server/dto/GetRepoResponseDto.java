package com.galecki.githubrepositoryfetcher.infrastructure.server.dto;

import com.galecki.githubrepositoryfetcher.domain.model.server.Branch;

import java.util.List;

public record GetRepoResponseDto(String repositoryName, String ownerLogin, List<Branch> branches) {
}
