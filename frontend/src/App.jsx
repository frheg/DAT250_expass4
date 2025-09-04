import {useEffect, useState} from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import Poll from "./components/Poll.jsx";
import CreatePoll from "./components/CreatePoll.jsx";

function App() {
  const [count, setCount] = useState(0)

    const [polls, setPolls] = useState([])

    useEffect(() => {
       fetchPolls()
    }, []);


  async function fetchPolls() {
      const response = await fetch("http://localhost:8080/polls");
      if (!response.ok) throw new Error("Network error");
      const data = await response.json();

      // if it's an array
      for (const poll of data) {
          console.log(poll.pollId, poll.question, poll.publishedAt);
      }
      console.log(data)
      setPolls(data)
  }


  return (
    <>
        {polls.map(poll => (
            <Poll key={`poll_${poll.pollId}`} poll={poll} />
        ))}

        <CreatePoll />
    </>
  )
}

export default App
