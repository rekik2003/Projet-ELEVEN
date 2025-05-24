import React, { useState, useEffect } from 'react';
import axios from 'axios';
import '../styles/Global.css'; // Global styles
import '../styles/StaffPage.css'; // Add specific styles for this page

const StaffPage = () => {
  const [assignedMatches, setAssignedMatches] = useState([]);
  const [error, setError] = useState('');

  useEffect(() => {
    fetchAssignedMatches();
  }, []);

  const fetchAssignedMatches = async () => {
    try {
      const response = await axios.get('http://localhost:8081/personnels/mesAffectations', {
        headers: {
          'Content-Type': 'application/json',
        },
      });
      setAssignedMatches(response.data);
    } catch (err) {
      setError('Failed to fetch assigned matches. Please try again.');
    }
  };

  

  return (
    <div className="staff-page">
      <h1>Welcome to Your Dashboard</h1>
      {error && <p className="error-message">{error}</p>}


      <div className="assigned-matches-section">
        <h2>Matches You Are Assigned To</h2>
        {assignedMatches.length === 0 ? (
          <p>No matches assigned yet.</p>
        ) : (
          <ul className="assigned-matches-list">
            {assignedMatches.map((match) => (
              <li key={match.id} className="assigned-match-item">
                <h3>{match.title}</h3>
                <p>
                  <strong>Date:</strong> {match.date}
                </p>
                <p>
                  <strong>Location:</strong> {match.location}
                </p>
                <p>
                  <strong>Description:</strong> {match.description}
                </p>
              </li>
            ))}
          </ul>
        )}
      </div>
    </div>
  );
};

export default StaffPage;
