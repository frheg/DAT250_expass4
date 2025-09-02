package dat250.models;

import java.util.List;

public class VoteOption {
    private String voteId;
    private String caption;
    private List<Vote> votes;

    public VoteOption() {
    }

    // VoteId
    public String getVoteId()   {
        return voteId;
    }
    public void setVoteId(String voteId)    {
        this.voteId = voteId;
    }

    // Caption
    public String getCaption()  {
        return caption;
    }
    public void setCaption(String caption)  {
        this.caption = caption;
    }

    // Votes
    public List<Vote> getVotes()    {
        return votes;
    }
    public void setVotes(List<Vote> votes)  {
        this.votes = votes;     // NOTE: This implementation may be altered depending on votes should be appended or created new list each time.
    }
}
