package com.galecki.githubrepositoryfetcher.domain.service;


import com.galecki.githubrepositoryfetcher.domain.model.client.Owner;
import com.galecki.githubrepositoryfetcher.domain.model.server.Branch;
import com.galecki.githubrepositoryfetcher.domain.model.server.Repo;
import com.galecki.githubrepositoryfetcher.infrastructure.client.dto.GetGitHubBranchResponseDto;
import com.galecki.githubrepositoryfetcher.infrastructure.client.dto.GetGitHubRepoResponseDto;
import com.galecki.githubrepositoryfetcher.infrastructure.client.proxy.GitHubServerProxy;
import com.galecki.githubrepositoryfetcher.infrastructure.client.proxy.error.UserNameNotFoundException;
import com.galecki.githubrepositoryfetcher.infrastructure.server.dto.GetRepoResponseDto;
import com.galecki.githubrepositoryfetcher.infrastructure.server.error.BadRequestHeaderException;
import feign.FeignException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MainDataTransferService {

    private final GitHubServerProxy gitHubServerProxy;

    public MainDataTransferService(GitHubServerProxy gitHubServerProxy) {
        this.gitHubServerProxy = gitHubServerProxy;
    }

    public List<GetRepoResponseDto> prepareGetRepoResponseDtoList(String userName, String acceptHeader) {

        validateAcceptHeader(acceptHeader);
        List<Repo> repoList = prepareRepoList(userName);
        List<GetRepoResponseDto> responseDtoList = new ArrayList<>();

        for (Repo repo : repoList) {
            List<GetGitHubBranchResponseDto> getGitHubBranchResponseDtoList = fetchAllRepositoryBranches(
                    repo.owner().login(),
                    repo.name());
            List<Branch> branchList = new ArrayList<>();
            for (GetGitHubBranchResponseDto getGitHubBranchResponseDto : getGitHubBranchResponseDtoList) {
                branchList.add(new Branch(getGitHubBranchResponseDto.name(), getGitHubBranchResponseDto.commit().sha()));
            }
            responseDtoList.add(new GetRepoResponseDto(repo.name(), repo.owner().login(), List.copyOf(branchList)));
        }
        return responseDtoList;
    }

    private List<Repo> prepareRepoList(String userName) {
        List<GetGitHubRepoResponseDto> getGitHubRepoResponseDtoList = fetchAllUserRepositories(userName);
        List<Repo> repoList = new ArrayList<>();
        for (GetGitHubRepoResponseDto repo : getGitHubRepoResponseDtoList) {
            if (repo.fork().equals("false")) {
                repoList.add(new Repo(repo.name(), new Owner(repo.owner().login())));
            }
        }
        return repoList;
    }

    private List<GetGitHubRepoResponseDto> fetchAllUserRepositories(String userName) {
        try {
            return gitHubServerProxy.getAllRepositoryByUserName(userName);
        } catch (FeignException.NotFound exception) {
            throw new UserNameNotFoundException("User " + userName + " not found");
        }
    }

    private List<GetGitHubBranchResponseDto> fetchAllRepositoryBranches(String ownerName, String repositoryName) {
        return gitHubServerProxy.getAllBranchesByRepoName(ownerName, repositoryName);
    }

    private void validateAcceptHeader(String header) {
        if (!header.equals("application/json")) {
            throw new BadRequestHeaderException("Bad request header. JSON only supported ");
        }
    }
}