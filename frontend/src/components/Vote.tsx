import {useEffect, useState} from "react";
import './Poll.css';

export default function Vote({optionId, pollId}) {

    useEffect(() => {
        console.log('miau', optionId, pollId)
    }, []);

    function onVote() {
        /**
        const response = await fetch("http://localhost:8080/vote", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                pollId: pollId,
                optionId: optionId
            })
        });

        if (!response.ok) throw new Error("Failed to submit vote");

        const data = await response.json();
        return data;
            */

        console.log("Vote")
    }

    return (
        <button
            className="vote-button"
            onClick={() => onVote()}
        >
            Vote
        </button>
    )
}