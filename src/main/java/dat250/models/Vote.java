package dat250.models;

import java.time.Instant;
import java.util.UUID;


public class Vote {

    private UUID voteId;
    private User user;
    private String voteOptionId;
    private Instant publishedAt;

    public Vote()   {
    }

    // VoteId
    public UUID getVoteId()   {
        return voteId;
    }
    public void setVoteId(UUID voteId)    {
        this.voteId = voteId;
    }

    // User
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    // VoteOptionId
    public String getVoteOptionId() {
        return voteOptionId;
    }
    public void setVoteOptionId(String voteOptionId) {
        this.voteOptionId = voteOptionId;
    }

    // PublishedAt
    public Instant getPublishedAt() {
        return publishedAt;
    }
    public void setPublishedAt(Instant publishedAt) {
        this.publishedAt = publishedAt;
    }
}
