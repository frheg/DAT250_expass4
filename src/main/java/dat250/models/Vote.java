package dat250.models;

import java.time.Instant;

public class Vote {

    private String voteId;
    private User userId;
    private Instant publishedAt;

    public Vote()   {
    }

    // VoteId
    public String getVoteId()   {
        return voteId;
    }
    public void setVoteId(String voteId)    {
        this.voteId = voteId;
    }

    // UserId
    public User getUserId() {
        return userId;
    }
    public void setUserId(User userId) {
        this.userId = userId;
    }

    // PublishedAt
    public Instant getPublishedAt() {
        return publishedAt;
    }
    public void setPublishedAt(Instant publishedAt) {
        this.publishedAt = publishedAt;
    }
}
