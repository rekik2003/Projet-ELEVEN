import React from 'react';
// import { Link } from 'react-router-dom';
import '../styles/Global.css'; // Global styles
import '../styles/Footer.css';
import facebookLogo from '../assets/facebook.png';
import instagramLogo from '../assets/instagram.png';
import youtubeLogo from '../assets/youtube.png';
import twitterLogo from '../assets/twitter.png';


const Footer = () => {
  const currentYear = new Date().getFullYear();

  return (
    <footer className="footer">
      <div className="footer-content">
        

        {/* Social Media Links */}
        <div className="footer-social-media">
          <a href="https://www.instagram.com" target="_blank">
            <img src={instagramLogo} alt="instagram"/>
          </a>
          <a href="https://www.facebook.com" target="_blank">
            <img src={facebookLogo} alt="facebook"/>
          </a>
          <a href="https://www.twitter.com" target="_blank">
            <img src={twitterLogo} alt="twitter"/>
          </a>
          <a href="https://www.youtube.com" target="_blank">
            <img src={youtubeLogo} alt="youtube"/>
          </a>
        </div>

        {/* Dynamic Year */}
        <div className="footer-year">
          <p>&copy; {currentYear} Eleven. All Rights Reserved.</p>
        </div>
      </div>
    </footer>
  );
};

export default Footer;
