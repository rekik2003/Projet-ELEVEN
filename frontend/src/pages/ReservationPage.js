import React, { useState, useEffect } from 'react';
import '../styles/Global.css';
import '../styles/Buttons.css';
import { useParams, useNavigate } from 'react-router-dom';
import '../styles/ReservationPage.css';
import axios from 'axios';

const ReservationPage = () => {
  const { matchId,participantId } = useParams();
  const navigate = useNavigate();

  const [matchTitle, setMatchTitle] = useState('');
  const [formData, setFormData] = useState({
    name: '',
    address: '',
    email: '',
    paymentMethod: 'Credit Card',
  });
  const [reservationStatus, setReservationStatus] = useState('');
  const [error, setError] = useState('');
  const [isSubmitting, setIsSubmitting] = useState(false);

  useEffect(() => {
    // Fetch match title using matchId
    const fetchMatchTitle = async () => {
      try {
        const response = await axios.get(`http://localhost:8081/participant/consulterMatches/${matchId}`);
        setMatchTitle(response.data.title); // Assuming the response has a "title" field
        document.title = `Reserve a Ticket for ${response.data.title}`; // Set page title dynamically
      } catch (err) {
        setError('Failed to fetch match details. Please try again later.');
      }
    };

    if (matchId) {
      fetchMatchTitle();
    }
  }, [matchId]);

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setFormData((prevData) => ({
      ...prevData,
      [name]: value,
    }));
  };

  const handleSubmit = async () => {
    setIsSubmitting(true);
    try {
      // Call the backend API to submit the reservation
      const reservationResponse = await axios.post(
        `http://localhost:8081/participant/${participantId}/reservationTicket/${matchId}`,
        formData,
        {
          headers: {
            'Content-Type': 'application/json',
          },
        }
      );

      // Email confirmation
      const emailResponse = await axios.post(
        `http://localhost:8081/participant/consulterMatches/${matchId}/send-confirmation-email`,
        { email: formData.email },
        {
          headers: {
            'Content-Type': 'application/json',
          },
        }
      );

      if (emailResponse.status === 200) {
        setReservationStatus('Reservation Successful! A confirmation email has been sent.');
        setTimeout(() => navigate('/'), 2000);
      } else {
        setReservationStatus('Reservation successful, but email confirmation failed.');
      }
    } catch (err) {
      setError('Failed to complete the reservation. Please try again.');
    } finally {
      setIsSubmitting(false);
    }
  };

  const handleCancel = () => {
    navigate('/');
  };

  return (
    <div className="reservation-page">
      <div className="reservation-container">
        <h1>Reserve a Ticket for {matchTitle || 'Loading...'} </h1>
        <form onSubmit={(e) => e.preventDefault()}>
          <label>
            Name:
            <input
              type="text"
              name="name"
              value={formData.name}
              onChange={handleInputChange}
              required
            />
          </label>
          <label>
            Address:
            <input
              type="text"
              name="address"
              value={formData.address}
              onChange={handleInputChange}
              required
            />
          </label>
          <label>
            Email:
            <input
              type="email"
              name="email"
              value={formData.email}
              onChange={handleInputChange}
              required
            />
          </label>
          <label>
            Payment Method:
            <select
              name="paymentMethod"
              value={formData.paymentMethod}
              onChange={handleInputChange}
            >
              <option value="Credit Card">Credit Card</option>
              <option value="PayPal">PayPal</option>
              <option value="Bank Transfer">Bank Transfer</option>
            </select>
          </label>
          <div className="buttons-container">
            <button
              type="button"
              className="button-confirm"
              onClick={handleSubmit}
              disabled={isSubmitting}
            >
              {isSubmitting ? 'Processing...' : 'Confirm Reservation'}
            </button>
            <button
              type="button"
              className="button-cancel"
              onClick={handleCancel}
            >
              Cancel
            </button>
          </div>
        </form>
        {reservationStatus && <p className="success-message">{reservationStatus}</p>}
        {error && <p className="error-message">{error}</p>}
      </div>
    </div>
  );
};

export default ReservationPage;
