import React from 'react';
import { useAuth } from '../context/AuthContext';
import '../styles/Buttons.css';
import '../styles/ProfilePage.css';

const LogoutButton = () => {
  const { logout } = useAuth();

  return (
    <div className="flex-center">
        <button className='logout-btn' onClick={logout}>Logout</button>
    </div>
  );
};

export default LogoutButton;