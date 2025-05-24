import React, { useState } from 'react';
import axios from 'axios';
import '../styles/Global.css';



const CreateMatchForm = () => {
  const [matchData, setMatchData] = useState({
    title: '',
    competition: '',
    date: '',
    location: '',
    description: '',
    maxNumberParticipants: 0,
  });
  const [error, setError] = useState(null);
  const [successMessage, setSuccessMessage] = useState(null);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setMatchData((prevData) => ({ ...prevData, [name]: value }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    // Make POST request to create a match
    axios
      .post('http://localhost:8081/organisateur/creerMatch', matchData)
      .then((response) => {
        setSuccessMessage('Match successfully created!');
        // Clear form after successful submission
        setMatchData({
          title: '',
          competition: '',
          date: '',
          location: '',
          description: '',
          maxNumberParticipants: 0,
        });
      })
      .catch((err) => {
        setError('Erreur lors de la création du match. Veuillez réessayer.');
      });
  };

  return (
    <div className="container">
      <h1>Creer Match</h1>
      <div className='creer'>
      <form onSubmit={handleSubmit}>
        <input
          type="text"
          name="title"
          placeholder="Titre"
          value={matchData.title}
          onChange={handleChange}
          required
        />
        <input
          type="text"
          name="competition"
          placeholder="Compétition"
          value={matchData.competition}
          onChange={handleChange}
          required
        />
        <input
          type="datetime-local"
          name="date"
          placeholder="Date"
          value={matchData.date}
          onChange={handleChange}
          required
        />
        <input
          type="text"
          name="location"
          placeholder="Lieu"
          value={matchData.location}
          onChange={handleChange}
          required
        />
        <textarea
          name="description"
          placeholder="Description"
          value={matchData.description}
          onChange={handleChange}
          required
        />
        <input
          type="number"
          name="maxNumberParticipants"
          placeholder="Nombre de participants max"
          value={matchData.maxNumberParticipants}
          onChange={handleChange}
          required
          min="1"
        />
        <button type="submit">Créer le match</button>

        {error && <p className="error">{error}</p>}
        {successMessage && <p className="success">{successMessage}</p>}
      </form>
      </div>
    </div>
  );
};

export default CreateMatchForm;
