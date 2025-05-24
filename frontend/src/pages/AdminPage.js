import React, { useState, useEffect } from 'react';
import axios from 'axios';
import StaffManagement from '../components/StaffManagement';
import OrganizerManagement from '../components/OrganizerManagement';
import MatchParticipantsManagement from '../components/MatchParticipantsManagement';
import '../styles/Global.css';
import '../styles/AdminPage.css';

const AdminPage = () => {
  const [error, setError] = useState(null);

  useEffect(() => {
    // Fetch initial data or perform checks if needed
  }, []);

  return (
    <div className="admin-container">
      <h1>Admin Dashboard</h1>
      {error && <p>{error}</p>}
      <div className="admin-section">
        <h2>Staff Management</h2>
        <StaffManagement />
      </div>
      <div className="admin-section">
        <h2>Organizer Management</h2>
        <OrganizerManagement />
      </div>
      <div className="admin-section">
        <h2>Match Participants Management</h2>
        <MatchParticipantsManagement />
      </div>
    </div>
  );
};

export default AdminPage;
