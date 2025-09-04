# Basic Spring Boot Application

## Data Model

![Class Diagram](./img/poll_diagram_class.png)

## API Requests

Users:
- [x] get users
- [x] create user
- [x] delete user
- [x] update user email, password

Poll:
- Create new poll (includes the VoteOption)
- Delete a poll (includes VoteOption and Votes)
- Maybe Update validUntil poll (insecure to change createdBy, createdAt or question)
- Get poll
    - If creator requests: Get all information with users
    - If someone else requests: Get only information of user

Vote:
- Create new vote of User to VoteOption
- Delete vote of User to VoteOption


## Open tasks
vote:
- Post: Set voteId and publishedAt automatically
    - If poll is private: UserId is required
    - If poll is public: UserId is not required
- Put: not required
- Get: Only return the userID, not entire user

voteoptions (redundant but good for testing)
- Put: not required (change Caption after votes is dangerous)
- Post: Remove the possibility to add votes from start on; set Id automatically
- Get: Good (except for user inside the votes)

poll:
- Get: Only return userID of creator, not entire user
- Post: Set pollId automatically, set publishedAt automatically
- Put: Only set ValidUntil and publicAccess

user:
- Get: Only return id and username
- Post: Check if username is atomic