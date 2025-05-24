import React, { useState, useEffect } from 'react';
import axios from 'axios';

const OrganizerManagement = () => {
  const [organizers, setOrganizers] = useState([]);
  const [error, setError] = useState(null);

  useEffect(() => {
    axios.get('http://localhost:8081/organisateurs')
      .then(response => {
        setOrganizers(response.data);
      })
      .catch(err => {
        setError('Failed to load organizers.');
      });
  }, []);

  const handleDeleteOrganizer = (organizerId) => {
    axios.delete(`http://localhost:8081/admin/organisateurs/delete/${organizerId}`)
      .then(() => {
        setOrganizers(organizers.filter(organizer => organizer.id !== organizerId));
        alert('Organizer deleted successfully.');
      })
      .catch(() => {
        alert('Failed to delete organizer.');
      });
  };

  return (
    <div>
      {error && <p>{error}</p>}
      <ul>
        {organizers.map(organizer => (
          <li key={organizer.id}>
            <p><strong>Name:</strong> {organizer.firstName} {organizer.lastName}</p>
            <p><strong>Email:</strong> {organizer.email}</p>
            <p><strong>Competence:</strong> {organizer.competence}</p>
            <p><strong>Position:</strong> {organizer.position}</p>
            <p><strong>Availability:</strong> {organizer.disponibilite}</p>
            <p><strong>Phone:</strong> {organizer.numtel}</p>
            <button onClick={() => handleDeleteOrganizer(organizer.id)}>Delete Organizer</button>
          </li>
        ))}
      </ul>
      <button>Add New Organizer</button>
    </div>
  );
};

export default OrganizerManagement;
