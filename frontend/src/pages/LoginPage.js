import React from 'react';
import { useAuth } from '../context/AuthContext';
import { useNavigate } from 'react-router-dom';
import LoginForm from '../components/LoginForm';
import '../styles/Global.css'; // Global styles
import '../styles/LoginPage.css';

const LoginPage = () => {
  const { login } = useAuth();
  const navigate = useNavigate();

  const handleLogin = (userData) => {
    login(userData);
    navigate('/profile');
  };

  return (
    <div className="login-page">
      <div className="login-container">
        <h1>Login</h1>
        <LoginForm onLogin={login} />
      </div>
    </div>
    
  );
};

export default LoginPage;