import React from 'react';
import { useAuth } from '../context/AuthContext';
import { useNavigate } from 'react-router-dom';
import SignUpForm from '../components/SignUpForm';
import '../styles/Global.css'; // Global styles
import '../styles/SignUpPage.css';

const SignUpPage = () => {
  const { signUp } = useAuth();
  const navigate = useNavigate();

  const handleSignUp = (userData) => {
    signUp(userData);
    navigate('/login');
  };

  return (
    <div className='signup-page'>
      <div className="signup-container">
        <h1>Sign Up</h1>
        <SignUpForm onSignUp={signUp} />
      </div>
    </div>
  );
};

export default SignUpPage;
