import {useEffect, useState} from "react";
import './Poll.css';

export default function CreatePoll() {

    useEffect(() => {
        console.log('miau')
    }, []);

    function onNewPoll() {
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

        console.log("New Poll")
    }

    return (
        <button
            className="poll-button"
            onClick={() => onNewPoll()}
        >
            New Poll
        </button>
    )
}