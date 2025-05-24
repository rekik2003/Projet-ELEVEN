import React, { useState, useEffect } from 'react';
import { useNavigate , useParams } from 'react-router-dom';
import axios from 'axios';
import '../styles/Global.css'; // Global styles
import '../styles/ReservationManagementPage.css'; // Add a new CSS file for specific styles

const ReservationManagementPage = () => {
  const [reservations, setReservations] = useState([]);
  const [error, setError] = useState('');
  const navigate = useNavigate();
  const { participantId } = useParams();

  useEffect(() => {
    fetchReservations();
  }, []);

  const fetchReservations = async () => {
    try {
      const response = await axios.get(`http://localhost:8081/participant/${participantId}/reservations`, {
        headers: {
          'Content-Type': 'application/json',
        },
      });
      setReservations(response.data);
    } catch (err) {
      setError('Failed to load reservations. Please try again.');
    }
  };

  const handleDelete = async (reservationId) => {
    try {
      await axios.delete(`http://localhost:8081/participant/${participantId}/reservations/delete`, {
        headers: {
          'Content-Type': 'application/json',
        },
      });
      setReservations((prevReservations) =>
        prevReservations.filter((reservation) => reservation.id !== reservationId)
      );
      alert('Reservation deleted successfully.');
    } catch (err) {
      setError('Failed to delete the reservation. Please try again.');
    }
  };

  const handleBack = () => {
    navigate('/');
  };

  return (
    <div className="reservation-management-page">
      <h1>Your Reservations</h1>
      {error && <p className="error-message">{error}</p>}
      {reservations.length === 0 ? (
        <p>You have no reservations.</p>
      ) : (
        <ul className="reservation-list">
          {reservations.map((reservation) => (
            <li key={reservation.id} className="reservation-item">
              <p><strong>Match:</strong> {reservation.matchTitle}</p>
              <p><strong>Date:</strong> {reservation.matchDate}</p>
              <p><strong>Seats Reserved:</strong> {reservation.seatsReserved}</p>
              <button
                className="button-delete"
                onClick={() => handleDelete(reservation.id)}
              >
                Cancel Reservation
              </button>
            </li>
          ))}
        </ul>
      )}
      <button className="button-back" onClick={handleBack}>
        Back to Home
      </button>
    </div>
  );
};

export default ReservationManagementPage;
