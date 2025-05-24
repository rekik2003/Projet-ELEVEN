import React, { createContext, useState, useContext, useEffect } from 'react';
import axios from 'axios';
import { login as apiLogin, signUp as apiSignUp } from '../api/api';

const AuthContext = createContext();

export const useAuth = () => useContext(AuthContext);

export const AuthProvider = ({ children }) => {
  const [user, setUser] = useState(null);
  const [loading, setLoading] = useState(true);

  // Check if the user is logged in (e.g., by checking a token)
  useEffect(() => {
    const token = localStorage.getItem('token');
    if (token) {
      axios.get('/api/auth/me', { headers: { Authorization: `Bearer ${token}` } })
        .then(response => {
          setUser(response.data);  // Set user data if token is valid
        })
        .catch(() => {
          localStorage.removeItem('token');
        })
        .finally(() => {
          setLoading(false);
        });
    } else {
      setLoading(false);
    }
  }, []);

  const login = async (email, password) => {
    try {
      const response = await apiLogin(email, password);  // Make API call to login
      localStorage.setItem('token', response.data.token);  // Store token in localStorage
      setUser(response.data);  // Set user data in state
    } catch (error) {
      console.error('Login failed', error);  // Handle login error (you can show a UI message here)
    }
  };


  const logout = () => {
    localStorage.removeItem('token');
    setUser(null);
  };


  const signUp = async (email, password) => {
    try {
      const response = await apiSignUp(email, password);  // Make API call to sign up
      login(email, password);  // Automatically log in the user after sign-up
    } catch (error) {
      console.error('Sign up failed', error);  // Handle sign-up error (you can show a UI message here)
    }
  };


  return (
    <AuthContext.Provider value={{ user, login, logout, signUp }}>
      {loading ? <div>Loading...</div> : children}
    </AuthContext.Provider>
  );
};
