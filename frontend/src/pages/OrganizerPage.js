import React, { useEffect, useState } from 'react';
import axios from 'axios';
import EditMatchForm from '../components/EditMatchForm';
import CreateMatchForm from '../components/CreateMatchForm';
import '../styles/Buttons.css';
import '../styles/Global.css';
import '../styles/OrganizerPage.css';



const OrganizerPage = () => {

  const [matches, setMatches] = useState([]);
  const [staff, setStaff] = useState([]);
  const [error, setError] = useState(null);

  
  useEffect(() => {
    // Fetch list of matches from the backend
    axios.get('http://localhost:8081/participant/consulterMatches')
      .then(response => {
        setMatches(response.data);
      })
      .catch(err => {
        setError('Impossible de charger la liste des matchs. Veuillez réessayer.');
      });
  }, []);

  useEffect(() => {
    // Fetch the available staff from the PersonnelService
    axios.get('http://localhost:8081/organisateur/listePersonnels/${position}') // Assuming this is the correct API endpoint
      .then(response => {
        setStaff(response.data); // Store staff data in state
      })
      .catch(err => {
        setError('Impossible de charger la liste du personnel. Veuillez réessayer.');
      });
  }, []);
  

  const handleAssignStaff = (matchId, staffId) => {
    // Find the match and the staff member
    const match = matches.find((match) => match.id === matchId);
    const staffMember = staff.find((staff) => staff.id === staffId);

    if (match && staffMember) {
      // Assign staff member to the match
      match.assignedStaff.push(staffMember);
      // Optionally remove the staff from the available staff list
      setStaff((prevStaff) => prevStaff.filter((staff) => staff.id !== staffId)); // Remove from available staff list
      alert(`${staffMember.name} has been assigned to the match!`);
    } else {
      alert('Error assigning staff.');
    }
  };

  return (
    <div className="container">
      <h1>Liste des matchs</h1>
      {error && <p>{error}</p>}
      {matches.length === 0 ? (
        <p>Aucun match disponible.</p>
      ) : (
        <ul>
          {matches.map((match) => (
            <li key={match.id}>
              <h3>{match.title}</h3>
              <p><span>Competition:</span> {match.competition}</p>
              <p><span>Description:</span> {match.description}</p>
              <p><span>Date:</span> {match.date}</p>
              <p><span>Lieu:</span> {match.location}</p>
              <p><span>Nombre Maximum de Participants:</span> {match.maxNumberParticipants}</p>
              <p><span>Disponibilité:</span> {match.availableSeats} places disponibles</p>

              {/* Show available staff for the match */}
              <div>
                <h4>Available Staff</h4>
                <ul>
                  {staff.map((staff) => (
                    <li key={staff.id}>
                      {staff.name}
                      <button
                        className="button-primary"
                        onClick={() => handleAssignStaff(match.id, staff.id)}
                      >
                        Assign to Match
                      </button>
                    </li>
                  ))}
                </ul>
              </div>

              {/* Show assigned staff */}
              <div>
                <h4>Assigned Staff</h4>
                <ul>
                  {match.assignedStaff && match.assignedStaff.length > 0 ? (
                    match.assignedStaff.map((staff) => <li key={staff.id}>{staff.name}</li>)
                  ) : (
                    <p>No staff assigned yet.</p>
                  )}
                </ul>
              </div>

              {/* Add EditMatchForm component */}
              <EditMatchForm matchId={match.id} />
            </li>
          ))}
        </ul>
      )}

      {/* Add CreateMatchForm component */}
      <CreateMatchForm />
    </div>
  );
};
export default OrganizerPage;
