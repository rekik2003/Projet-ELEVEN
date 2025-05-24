import React from 'react';
import { useAuth } from '../context/AuthContext';
import '../styles/ProfilePage.css';


const UserProfile = () => {
  const { user, logout } = useAuth();

  // If the user is not authenticated, show a message
  if (!user) {
    return <p>You need to log in to view your profile.</p>;
  }


  const handleEditProfile = () => {
    console.log('Redirect to Edit Profile page'); // Add navigation logic if needed
  };

  const handleChangePassword = () => {
    console.log('Redirect to Change Password page'); // Add navigation logic if needed
  };

  const handleDeleteAccount = () => {
    if (window.confirm('Are you sure you want to delete your account? This action cannot be undone.')) {
      console.log('Call backend to delete account'); // Add backend call to delete account
    }
  };
  
  

  return (
    <div className="container user-profile">
      <div className="profile-details">
        <p><strong>Name:</strong> {user.name}</p>
        <p><strong>Email:</strong> {user.email}</p>
        <p><strong>Joined:</strong> {new Date(user.joinDate).toLocaleDateString()}</p>
      </div>

      <div className="profile-actions">
        <button className="btn" onClick={handleEditProfile}>
          Edit Profile
        </button>
        <button className="btn" onClick={handleChangePassword}>
          Change Password
        </button>
        <button className="btn btn-danger" onClick={handleDeleteAccount}>
          Delete Account
        </button>
        <button className="btn btn-secondary" onClick={logout}>
          Logout
        </button>
      </div>
    </div>
  );
};


export default UserProfile;
