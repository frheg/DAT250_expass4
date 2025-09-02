package dat250.group2.poll.poll.entities;

import java.time.Instant;
import java.util.List;

public class Poll {

    // Poll
    private String id;
    private String question;
    private Instant publishedAt;
    private Instant validUntil;

    private Boolean publicAccess;

    private User createdBy;

    private List<VoteOption> options;

    public Poll(String id, String question, Instant publishedAt, Instant validUntil, User createdBy, Boolean publicAccess) {
        this.id = id;
        this.question = question;
        this.publishedAt = publishedAt;
        this.validUntil = validUntil;

        this.createdBy = createdBy;
        this.publicAccess = publicAccess;
    }

    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }

    public Instant getPublishedAt() {
        return publishedAt;
    }
    public void setPublishedAt(Instant publishedAt) {
        this.publishedAt = publishedAt;
    }

    public Instant getValidUntil() {
        return validUntil;
    }
    public void setValidUntil(Instant validUntil) {
        this.validUntil = validUntil;
    }

    public User getCreatedBy() {
        return createdBy;
    }
    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }
}
