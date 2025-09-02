package dat250.services;

import dat250.models.Poll;
import dat250.models.User;
import dat250.models.Vote;
import dat250.models.VoteOption;
import org.springframework.stereotype.Component;

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
        polls.put(poll.getPollId(), poll);
        return poll;
    }
    public Poll getPoll(String pollId) {
        return polls.get(pollId);
    }
    public List<Poll> getAllPolls() {
        return new ArrayList<>(polls.values());
    }
    public Poll updatePoll(String pollId, Poll poll) {
        polls.put(pollId, poll);
        return poll;
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
        return voteOptions.get(optionId);
    }
    public List<VoteOption> getAllVoteOptions() {
        return new ArrayList<>(voteOptions.values());
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
}
