package dat250.services;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dat250.models.Poll;
import dat250.models.User;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/polls")
public class PollComponent {

    @GetMapping("")
    private ResponseEntity<List<Poll>> getPolls() {
        User user = new User();

        List<Poll> polls = new ArrayList<>();

        return ResponseEntity.ok(polls);
    }

    // Users: get users, create user, delete user, update user email

    // Poll:
    // - Create new poll (includes the VoteOption)
    // - Delete a poll (includes VoteOption and Votes)
    // - Maybe Update validUntil poll (insecure to change createdBy, createdAt or question)

    // Vote: Create new vote of User to VoteOption; Delete vote of User to VoteOption, Change vote of User to VoteOption

}
