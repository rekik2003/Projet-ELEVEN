import React, { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { useParams } from 'react-router-dom';
import axios from 'axios';
import '../styles/Buttons.css';
import '../styles/MatchPage.css';



const MatchPage = () => {
  const [matches, setMatches] = useState([]);
  const [error, setError] = useState(null);
  const [loading, setLoading] = useState(true);
  const { participantId } = useParams();

  const navigate = useNavigate();

  useEffect(() => {
    // Fetch the list of matches from the backend
    axios
      .get('http://localhost:8081/participant/consulterMatches') // Adjust to match your backend API URL
      .then((response) => {
        setMatches(response.data);
        setLoading(false);
      })
      .catch((err) => {
        setError('Impossible de charger la liste des matchs. Veuillez réessayer.');
        setLoading(false);
      });
  }, []);

  const handleReserveClick = (matchId) => {
    navigate(`http://localhost:3000/participant/${participantId}/reservationTicket/${matchId}`);
  };

  if (loading) {
    return <p>Chargement en cours...</p>;
  }

  return (
    <div className="container">
      <h1>Liste des matchs</h1>
      {error && <p className="error">{error}</p>}
      {matches.length === 0 ? (
        <p>Aucun match disponible.</p>
      ) : (
        <ul>
          {matches.map(match => (
            <li key={match.id}>
            <h3>{match.title}</h3>
            <p><span>Competition:</span> {match.competition}</p>
            <p><span>Description:</span> {match.description}</p>
            <p><span>Date:</span> {match.date}</p>
            <p><span>Lieu:</span> {match.location}</p>
            <p><span>Nombre Maximum de Participants:</span> {match.nbMaximParticipants}</p>
            <p><span>Disponibilité:</span> {match.availableSeats} places disponibles</p>
            <div className="button-container">
              <button
                className="button-ticket"
                onClick={() => handleReserveClick(match.id)}
              >
                Reserve Ticket
              </button>
            </div>
          </li>
          
          ))}
        </ul>
      )}
    </div>
  );
};
export default MatchPage;