package com.galecki.githubrepositoryfetcher.infrastructure.server.controller;

import com.galecki.githubrepositoryfetcher.domain.service.MainDataTransferService;
import com.galecki.githubrepositoryfetcher.infrastructure.server.dto.GetRepoResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GitHubRepoRestController {

    final private MainDataTransferService mainDataTransferService;

    public GitHubRepoRestController(MainDataTransferService mainDataTransferService) {
        this.mainDataTransferService = mainDataTransferService;
    }

    @GetMapping("/{userName}")
    List<GetRepoResponseDto> fetchAllUserRepos(
            @PathVariable String userName,
            @RequestHeader(required = true) String accept) {
        return mainDataTransferService.prepareGetRepoResponseDtoList(userName, accept);
    }
}
