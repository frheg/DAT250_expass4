package dat250.models;

public class Vote {

    private String voteId;
    private User userID;

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
        return userID;
    }
    public void setUserId() {

    }
}
