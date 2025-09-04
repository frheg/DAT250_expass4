package dat250.controllers;

import dat250.models.Vote;
import dat250.services.PollManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

import java.util.List;

/**
 * Manages API-endpoints for votes.
 */

@RestController
@RequestMapping("/votes")
public class VoteController {
    @Autowired
    private PollManager pollManager;

    @GetMapping("")
    public ResponseEntity<List<Vote>> getVotes() {
        return ResponseEntity.ok(pollManager.getAllVotes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vote> getVote(@PathVariable UUID id) {
        Vote vote = pollManager.getVote(id);
        if (vote == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(vote);
    }

    @PostMapping("")
    public ResponseEntity<Vote> createVote(@RequestBody Vote vote) {
        Vote created = pollManager.createVote(vote);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vote> updateVote(@PathVariable UUID id, @RequestBody Vote vote) {
        if (pollManager.getVote(id) == null) return ResponseEntity.notFound().build();
        pollManager.updateVote(id, vote);
        return ResponseEntity.ok(vote);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVote(@PathVariable UUID id) {
        pollManager.deleteVote(id);
        return ResponseEntity.noContent().build();
    }
}