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
    private final Map<UUID, Vote> votes = new HashMap<>();
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
        Poll poll = polls.get(pollId);
        if (poll != null) {
            // Populate the poll with its vote options
            List<VoteOption> pollOptions = new ArrayList<>();
            for (VoteOption option : voteOptions.values()) {
                if (option.getPollId() != null && option.getPollId().equals(pollId)) {
                    // Also populate each option with its votes
                    List<Vote> optionVotes = new ArrayList<>();
                    for (Vote vote : votes.values()) {
                        if (vote.getVoteOptionId() != null && vote.getVoteOptionId().equals(option.getOptionId())) {
                            optionVotes.add(vote);
                        }
                    }
                    option.setVotes(optionVotes);
                    pollOptions.add(option);
                }
            }
            poll.setOptions(pollOptions);
        }
        return poll;
    }
    public List<Poll> getAllPolls() {
        List<Poll> pollList = new ArrayList<>(polls.values());
        // Populate each poll with its vote options
        for (Poll poll : pollList) {
            List<VoteOption> pollOptions = new ArrayList<>();
            for (VoteOption option : voteOptions.values()) {
                if (option.getPollId() != null && option.getPollId().equals(poll.getPollId())) {
                    // Also populate each option with its votes
                    List<Vote> optionVotes = new ArrayList<>();
                    for (Vote vote : votes.values()) {
                        if (vote.getVoteOptionId() != null && vote.getVoteOptionId().equals(option.getOptionId())) {
                            optionVotes.add(vote);
                        }
                    }
                    option.setVotes(optionVotes);
                    pollOptions.add(option);
                }
            }
            poll.setOptions(pollOptions);
        }
        return pollList;
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
        vote.setVoteId(UUID.randomUUID());
        vote.setPublishedAt(Instant.now());
        votes.put(vote.getVoteId(), vote);
        return vote;
    }

    public Vote getVote(UUID voteId) {
        return votes.get(voteId);
    }

    public List<Vote> getAllVotes() {
        return new ArrayList<>(votes.values());
    }

    public Vote updateVote(UUID voteId, Vote vote) {
        votes.put(voteId, vote);
        return vote;
    }
    public void deleteVote(UUID voteId) {
        votes.remove(voteId);
    }
}
