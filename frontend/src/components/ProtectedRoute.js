import React from 'react';
import { Navigate } from 'react-router-dom';
import { useAuth } from '../context/AuthContext';
import '../styles/Global.css'; // Global styles
import '../styles/ProtectedRoute.css';


const ProtectedRoute = ({ element, roleRequired, ...rest }) => {
  const { user } = useAuth();

  if (!user) {
    // Redirect to login if user is not authenticated
    return <Navigate to="/login" />;
  }

  // Check if the user has the required role (if any)
  if (roleRequired && user.role !== roleRequired) {
    // Redirect to homepage or a "not authorized" page if role doesn't match
    return <Navigate to="/" />;
  }

  // If the user is authenticated and has the required role (if specified), show the page
  return element;
};

export default ProtectedRoute;
