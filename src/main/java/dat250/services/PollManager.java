package dat250.services;

import dat250.models.Poll;
import dat250.models.User;
import dat250.models.Vote;
import dat250.models.VoteOption;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.*;

/**
 * Manages CRUD (Create, Read, Update, Delete) operations for polls, users, votes, and vote options.
 */

@Component
public class PollManager {
    private final Map<String, User> users = new HashMap<>();
    private final Map<String, Poll> polls = new HashMap<>();
    private final Map<String, Vote> votes = new HashMap<>();
    private final Map<String, VoteOption> voteOptions = new HashMap<>();

    // User CRUD
    public User createUser(User user) {
        users.put(user.getUserId(), user);
        return user;
    }
    public User getUser(String userId) {
        return users.get(userId);
    }
    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }
    public User updateUser(String userId, User updateRequest) {
        User existingUser = users.get(userId);
        if (existingUser == null) {
            return null;
        }
        
        // Only update fields that are provided, if null, then do not touch
        if (updateRequest.getEmail() != null) {
            existingUser.setEmail(updateRequest.getEmail());
        }
        if (updateRequest.getPassword() != null) {
            existingUser.setPassword(updateRequest.getPassword());
        }

        return existingUser;
    }
    public void deleteUser(String userId) {
        users.remove(userId);
    }

    // Poll CRUD
    public Poll createPoll(Poll poll) {
        // Set pollId automatically using UUID
        String pollId = UUID.randomUUID().toString();
        poll.setPollId(pollId);
        
        // Set publishedAt automatically to current time
        poll.setPublishedAt(Instant.now());
        
        polls.put(poll.getPollId(), poll);
        return poll;
    }
    public Poll getPoll(String pollId) {
        Poll poll = polls.get(pollId);
        return createFilteredPoll(poll);
    }
    public List<Poll> getAllPolls() {
        List<Poll> modifiedPolls = new ArrayList<>();
        for (Poll poll : polls.values()) {
            Poll filteredPoll = createFilteredPoll(poll);
            if (filteredPoll != null) {
                modifiedPolls.add(filteredPoll);
            }
        }
        return modifiedPolls;
    }
    public Poll updatePoll(String pollId, Poll updateRequest) {
        Poll existingPoll = polls.get(pollId);
        if (existingPoll == null) {
            return null;
        }
        
        // Only update validUntil and publicAccess fields
        if (updateRequest.getValidUntil() != null) {
            existingPoll.setValidUntil(updateRequest.getValidUntil());
        }
        if (updateRequest.getPublicAccess() != null) {
            existingPoll.setPublicAccess(updateRequest.getPublicAccess());
        }
        
        return existingPoll;
    }
    public void deletePoll(String pollId) {
        polls.remove(pollId);
    }

    // VoteOption CRUD
    public VoteOption createVoteOption(VoteOption option) {
        voteOptions.put(option.getOptionId(), option);
        return option;
    }
    public VoteOption getVoteOption(String optionId) {
        VoteOption option = voteOptions.get(optionId);
        if (option != null) {
            // Populate the vote option with its votes
            List<Vote> optionVotes = new ArrayList<>();
            for (Vote vote : votes.values()) {
                if (vote.getVoteOptionId() != null && vote.getVoteOptionId().equals(optionId)) {
                    optionVotes.add(vote);
                }
            }
            option.setVotes(optionVotes);
        }
        return option;
    }
    public List<VoteOption> getAllVoteOptions() {
        List<VoteOption> optionList = new ArrayList<>(voteOptions.values());
        // Populate each vote option with its votes
        for (VoteOption option : optionList) {
            List<Vote> optionVotes = new ArrayList<>();
            for (Vote vote : votes.values()) {
                if (vote.getVoteOptionId() != null && vote.getVoteOptionId().equals(option.getOptionId())) {
                    optionVotes.add(vote);
                }
            }
            option.setVotes(optionVotes);
        }
        return optionList;
    }
    public VoteOption updateVoteOption(String optionId, VoteOption option) {
        voteOptions.put(optionId, option);
        return option;
    }
    public void deleteVoteOption(String optionId) {
        voteOptions.remove(optionId);
    }

    // Vote CRUD
    public Vote createVote(Vote vote) {
        votes.put(vote.getVoteId(), vote);
        return vote;
    }
    public Vote getVote(String voteId) {
        return votes.get(voteId);
    }
    public List<Vote> getAllVotes() {
        return new ArrayList<>(votes.values());
    }
    public Vote updateVote(String voteId, Vote vote) {
        votes.put(voteId, vote);
        return vote;
    }
    public void deleteVote(String voteId) {
        votes.remove(voteId);
    }

    // ----- HELPER METHODS -----
    // Helper method to create a poll with filtered creator info and populated options
    private Poll createFilteredPoll(Poll originalPoll) {
        if (originalPoll == null) return null;
        
        Poll modifiedPoll = new Poll();
        modifiedPoll.setPollId(originalPoll.getPollId());
        modifiedPoll.setQuestion(originalPoll.getQuestion());
        modifiedPoll.setPublishedAt(originalPoll.getPublishedAt());
        modifiedPoll.setValidUntil(originalPoll.getValidUntil());
        modifiedPoll.setPublicAccess(originalPoll.getPublicAccess());
        
        // Only include userID of creator, not entire user object
        if (originalPoll.getCreatedBy() != null) {
            User creatorSummary = new User();
            creatorSummary.setUserId(originalPoll.getCreatedBy().getUserId());
            modifiedPoll.setCreatedBy(creatorSummary);
        }
        
        // Populate with vote options
        modifiedPoll.setOptions(getVoteOptionsForPoll(originalPoll.getPollId()));
        
        return modifiedPoll;
    }
    
    // Helper method to get vote options for a specific poll
    private List<VoteOption> getVoteOptionsForPoll(String pollId) {
        List<VoteOption> pollOptions = new ArrayList<>();
        for (VoteOption option : voteOptions.values()) {
            if (option.getPollId() != null && option.getPollId().equals(pollId)) {
                // Create a copy to avoid modifying the original
                VoteOption optionCopy = new VoteOption();
                optionCopy.setOptionId(option.getOptionId());
                optionCopy.setPollId(option.getPollId());
                optionCopy.setCaption(option.getCaption());
                
                // Populate with votes
                optionCopy.setVotes(getVotesForOption(option.getOptionId()));
                pollOptions.add(optionCopy);
            }
        }
        return pollOptions;
    }
    
    // Helper method to get votes for a specific option
    private List<Vote> getVotesForOption(String optionId) {
        List<Vote> optionVotes = new ArrayList<>();
        for (Vote vote : votes.values()) {
            if (vote.getVoteOptionId() != null && vote.getVoteOptionId().equals(optionId)) {
                optionVotes.add(vote);
            }
        }
        return optionVotes;
    }
}
