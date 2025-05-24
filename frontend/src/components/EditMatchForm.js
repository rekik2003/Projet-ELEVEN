import React, { useEffect, useState } from 'react';
import axios from 'axios';
import '../styles/Global.css';


const EditMatchForm = ({ matchId }) => {
  const [matchData, setMatchData] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const [successMessage, setSuccessMessage] = useState('');


  useEffect(() => {
    // Fetch the match details to pre-fill the form
    axios
      .get(`http://localhost:8081/participant/consulterMatches/${matchId}`)
      .then((response) => {
        setMatchData(response.data);
        setLoading(false);
      })
      .catch(() => {
        setError('Erreur lors de la récupération des informations du match.');
        setLoading(false);
      });
  }, [matchId]);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setMatchData((prevData) => ({ ...prevData, [name]: value }));
  };

  
  const handleSubmit = (e) => {
    e.preventDefault();
    setError('');
    setSuccessMessage('');

    // Make PUT request to update the match
    axios
      .put(`http://localhost:8081/organisateur/modifierMatch/${matchId}`, matchData)
      .then(() => {
        setSuccessMessage('Le match a été mis à jour avec succès.');
      })
      .catch(() => {
        setError('Erreur lors de la mise à jour du match. Veuillez réessayer.');
      });
  };

  
  const handleDelete = () => {
    if (!window.confirm('Êtes-vous sûr de vouloir supprimer ce match ?')) return;

    setError('');
    setSuccessMessage('');

    axios
      .delete(`http://localhost:8081/organisateur/supprimerMatch/${matchId}`)
      .then(() => {
        setSuccessMessage('Le match a été supprimé avec succès.');
      })
      .catch(() => {
        setError('Erreur lors de la suppression du match.');
      });
  };

  if (loading) return <div>Chargement...</div>;
  if (!matchData) return <div>Aucune donnée de match trouvée.</div>;


  return (
    <div className="container">
      <h2>Edit Match</h2>
      <form onSubmit={handleSubmit}>
        <label>
          Titre:
          <input
            type="text"
            name="title"
            value={matchData.title}
            onChange={handleChange}
            required
          />
        </label>
        <label>
          Compétition:
          <input
            type="text"
            name="competition"
            value={matchData.competition}
            onChange={handleChange}
            required
          />
        </label>
        <label>
          Date:
          <input
            type="datetime-local"
            name="date"
            value={matchData.date}
            onChange={handleChange}
            required
          />
        </label>
        <label>
          Lieu:
          <input
            type="text"
            name="location"
            value={matchData.location}
            onChange={handleChange}
            required
          />
        </label>
        <label>
          Description:
          <textarea
            name="description"
            value={matchData.description}
            onChange={handleChange}
            required
          />
        </label>
        <label>
          Nombre Max de Participants:
          <input
            type="number"
            name="maxNumberParticipants"
            value={matchData.maxNumberParticipants}
            onChange={handleChange}
            required
          />
        </label>
        <button type="submit">Mettre à jour le match</button>
        <button type="button" onClick={handleDelete}>
          Supprimer le match
        </button>
      </form>
      {error && <p className="error-message">{error}</p>}
      {successMessage && <p className="success-message">{successMessage}</p>}
    </div>
  );
};

export default EditMatchForm;
