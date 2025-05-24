import React from 'react';
import { useAuth } from '../context/AuthContext';
import UserProfile from '../components/UserProfile'; // Import UserProfile component
import '../styles/Global.css'; // Global styles
import '../styles/ProfilePage.css';

const ProfilePage = () => {
  const { user } = useAuth();
  
  
  return (
    <div className="profile-container">
      <h1>Profile</h1>
      {user ? (
        <UserProfile /> // Use the UserProfile component
      ) : (
        <p>Please log in to view your profile.</p>
      )}
    </div>
  );
};

export default ProfilePage;
