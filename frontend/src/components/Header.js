import React from 'react';
import { Link } from 'react-router-dom';
import { useAuth } from '../context/AuthContext';
import LogoutButton from './LogoutButton';
import '../styles/Global.css'; // Global styles
import '../styles/Buttons.css';
import '../styles/Header.css';
import elevenLogo from '../assets/eleven.png';

const Header = () => {
  const { user } = useAuth();

  return (
    <header className='container'>
        <a>
          <Link to="/" className="logo-link">
            <img src={elevenLogo} alt="elevenLogo" className="logo" />
          </Link>
        </a>
        <nav className="flex-center">
        
            <Link to="/">Home</Link>
            <Link to="/matches">Matches</Link>
            {user ? (
            <>
                <Link to="/profile">{user.name}</Link>
                <LogoutButton />
            </>
            ) : (
            <>
                <Link to="/login">Login</Link>
                <Link to="/signup">Sign Up</Link>
            </>
            )}
        </nav>
    </header>
  );
};

export default Header;