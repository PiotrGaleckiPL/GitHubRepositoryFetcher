package com.galecki.githubrepositoryfetcher.infrastructure.client.proxy;

import com.galecki.githubrepositoryfetcher.infrastructure.client.dto.GetGitHubBranchResponseDto;
import com.galecki.githubrepositoryfetcher.infrastructure.client.dto.GetGitHubRepoResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Component
@FeignClient(name = "github-server-client")
public interface GitHubServerProxy {

    @GetMapping("/users/{userName}/repos")
    List<GetGitHubRepoResponseDto> getAllRepositoryByUserName(@PathVariable String userName);

    @GetMapping("/repos/{ownerName}/{repoName}/branches")
    List<GetGitHubBranchResponseDto> getAllBranchesByRepoName(@PathVariable String ownerName, @PathVariable String repoName);
}
