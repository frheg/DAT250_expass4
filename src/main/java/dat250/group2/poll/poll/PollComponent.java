package dat250.group2.poll.poll;

import dat250.group2.poll.poll.entities.Poll;
import dat250.group2.poll.poll.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/polls")
public class PollComponent {

    @GetMapping("")
    private ResponseEntity<List<Poll>> getPolls() {
        User user = new User("admin", "admin", "admin");

        List<Poll> polls = new ArrayList<>();
        polls.add(new Poll("1", "How old are you?", Instant.now(), Instant.now().plus(Duration.ofDays(7)), user, false));
        polls.add(new Poll("2", "Where do you live?", Instant.now(), Instant.now().plus(Duration.ofDays(7)), user, false));

        return ResponseEntity.ok(polls);
    }

    // Users: get users, create user, delete user, update user email

    // Poll:
    // - Create new poll (includes the VoteOption)
    // - Delete a poll (includes VoteOption and Votes)
    // - Maybe Update validUntil poll (insecure to change createdBy, createdAt or question)

    // Vote: Create new vote of User to VoteOption; Delete vote of User to VoteOption, Change vote of User to VoteOption

}
