# Poll App with REST API
## Description of current code:
The current code is structured with MSC (Model-Service-Controller) architecture in mind. It includes:
- **Models**: Defines the data structures and their basic methods for the program.
    - `Poll`: Represents a poll containing a question and multiple choice options.
    - `User`: Represents a user who can create polls and vote.
    - `Vote`: Represents a user's vote on a option in a poll.
    - `VoteOption`: Represents an option within a poll that users can vote for.
- **Services**: Contains the business logic for the program.
    - `PollManager`: Manages the collections of users, polls, votes, and vote options, and provides methods to manipulate them.
- **Controllers**: Handles API-endpoints.
    - `PollController`: Manages API-endpoints for polls.
    - `UserController`: Manages API-endpoints for users.
    - `VoteController`: Manages API-endpoints for votes.
    - `VoteOptionController`: Manages API-endpoints for vote options.
## How to run and test current program:
In terminal, navigate to project root and run with gradlew:
```bash
./gradlew bootRun
```
Then use **Bruno** to interact with the API endpoints and test them. Default API endpoints are available at `http://localhost:8080/`. Check folder `brunofiles` for example requests.
