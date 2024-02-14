# GitHub Repository Fetcher Application

The GitHub Repository Fetcher application allows you to retrieve information about user repositories from the GitHub platform.

## Interfaces

### GitHubServerProxy

The `GitHubServerProxy` interface is used to communicate with the GitHub server using FeignClient.

Methods:

- `getAllRepositoryByUserName(String userName)`: Retrieves a list of user repositories based on the username.
- `getAllBranchesByRepoName(String ownerName, String repoName)`: Retrieves a list of branches for a specified repository based on the owner's name and repository name.

## Classes

### GitHubRepoRestController

The `GitHubRepoRestController` class is a REST controller handling requests related to fetching user repositories from the GitHub service.

Methods:

- `fetchAllUserRepos(String userName, String accept)`: Handles a GET request at `/{userName}`. Retrieves user repositories based on their name and returns a list of `GetRepoResponseDto` objects.

### MainDataTransferService

The `MainDataTransferService` class is a service managing data transfer between the controller and the GitHub client.

Methods:

- `prepareGetRepoResponseDtoList(String userName, String acceptHeader)`: Prepares a list of user repositories with their branches based on data fetched from GitHub.
- `prepareRepoList(String userName)`: Prepares a list of user repositories based on data fetched from GitHub.
- `fetchAllUserRepositories(String userName)`: Retrieves a list of user repositories based on username.
- `fetchAllRepositoryBranches(String ownerName, String repositoryName)`: Retrieves a list of branches for a specified repository based on the owner's name and repository name.
- `validateAcceptHeader(String header)`: Validates the `Accept` header.

## DTO Classes

### GetGitHubRepoResponseDto

DTO containing information about GitHub user repositories. Contains: `name : String`, `owner : Owner`, `fork : String`. 

### GetGitHubBranchResponseDto

DTO containing information about GitHub repository branches. Contains: `name : String`, `commit : Commit`.

### Repo

DTO containing information about a GitHub repository. Contains: `repoName : String`, `owner : Owner`.

### Branch

DTO containing information about branches in a GitHub repository. Contains: `branchName : String`, `lastCommitSha : String`.

### Owner

DTO containing information about the owner of a GitHub repository. Contains: `login : String`.

### Commit

DTO containing information about the last commit in a GitHub repository. Contains: `sha : String`.

### GetRepoResponseDto

DTO containing information about user repositories with their branches. Contains: `repositoryName : String`, `ownerLogin : String`, `branches : List<Branch>`.

### UserNameNotFoundResponseDto

DTO containing information about the GitHub user not found exception. Contains: `status : HttpStatus`, `message : String`.

### BadRequestHeaderResponseDto

DTO containing information about the HTTP request header error. Contains: `status : HttpStatus`, `message : String`.

## Exception Handling Classes

### BadRequestHeaderException

The `BadRequestHeaderException` class represents an exception related to an invalid HTTP request header.

### BadRequestHeaderExceptionHandler

The `BadRequestHeaderExceptionHandler` class handles the `BadRequestHeaderException` exception, which occurs in case of an invalid HTTP request header.

Methods:

- `handleBadRequestHeader(BadRequestHeaderException exception)`: Handles the `BadRequestHeaderException` and returns an appropriate response(`BadRequestHeaderResponseDto`).

### UserNameNotFoundException

The `UserNameNotFoundException` class represents an exception related to a user not found on the GitHub platform.

### UserNameNotFoundExceptionHandler

The `UserNameNotFoundExceptionHandler` class handles the `UserNameNotFoundException` exception, which occurs when a user is not found on the GitHub platform.

Methods:

- `handleUserNameNotFoundException(UserNameNotFoundException exception)`: Handles the `UserNameNotFoundException` and returns an appropriate response(`UserNameNotFoundResponseDto`).

