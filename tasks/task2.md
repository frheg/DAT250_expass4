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