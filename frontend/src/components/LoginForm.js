import React, { useState } from 'react';
import { useAuth } from '../context/AuthContext';
import axios from 'axios';
import '../styles/Global.css'; // Global styles
import '../styles/Buttons.css';
import '../styles/LoginPage.css';



const LoginForm = ({ onLogin }) => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState('');

  const handleLogin = (e) => {
    e.preventDefault();
    axios.post('http://localhost:8081/login', { email, password })
      .then(response => {
        onLogin(response.data); // Pass user data to parent (AuthContext)
      })
      .catch(err => setError('Invalid credentials. Please try again.'));
  };

  return (
    <form className="center" onSubmit={handleLogin}>
      <div>
        <label>Email:</label>
        <input
          type="email"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
          required
        />
      </div>
      <div>
        <label>Password:</label>
        <input
          type="password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
          required
        />
      </div>
      {error && <p>{error}</p>}
      <button className='button-primary' type="submit">Login</button>
    </form>
  );
};

export default LoginForm;