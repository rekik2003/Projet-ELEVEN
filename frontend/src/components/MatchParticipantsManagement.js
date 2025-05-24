import React, { useState, useEffect } from 'react';
import axios from 'axios';

const MatchParticipantsManagement = () => {
  const [matches, setMatches] = useState([]);
  const [error, setError] = useState(null);

  useEffect(() => {
    axios.get('http://localhost:8081/participant/ConsulterMatches')
      .then(response => {
        setMatches(response.data);
      })
      .catch(err => {
        setError('Failed to load matches.');
      });
  }, []);

  const handleRemoveParticipant = (matchId, participantId) => {
    axios.post(`http://localhost:8081/organisateur/deleteParticipant`, { participantId })
      .then(() => {
        setMatches(matches.map(match => match.id === matchId ? { ...match, participants: match.participants.filter(p => p.id !== participantId) } : match));
        alert('Participant removed successfully.');
      })
      .catch(() => {
        alert('Failed to remove participant.');
      });
  };

  return (
    <div>
      {error && <p>{error}</p>}
      <ul>
        {matches.map(match => (
          <li key={match.id}>
            <h3>{match.title}</h3>
            <ul>
              {match.participants.map(participant => (
                <li key={participant.id}>
                  <p><strong>Name:</strong> {participant.firstName} {participant.lastName}</p>
                  <p><strong>Email:</strong> {participant.email}</p>
                  <p><strong>Address:</strong> {participant.adresse}</p>
                  <p><strong>Phone:</strong> {participant.numtel}</p>
                  <p><strong>Preference:</strong> {participant.preference}</p>
                  <button onClick={() => handleRemoveParticipant(match.id, participant.id)}>Remove</button>
                </li>
              ))}
            </ul>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default MatchParticipantsManagement;
