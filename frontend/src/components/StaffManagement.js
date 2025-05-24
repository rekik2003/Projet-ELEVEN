import React, { useState, useEffect } from 'react';
import axios from 'axios';

const StaffManagement = () => {
  const [staff, setStaff] = useState([]);
  const [error, setError] = useState(null);

  useEffect(() => {
    axios.get('http://localhost:8081/personnels')
      .then(response => {
        setStaff(response.data);
      })
      .catch(err => {
        setError('Failed to load staff.');
      });
  }, []);

  const handleDeleteStaff = (staffId) => {
    axios.delete(`http://localhost:8081/admin/personnels/delete/${staffId}`)
      .then(() => {
        setStaff(staff.filter(staffMember => staffMember.id !== staffId));
        alert('Staff member deleted successfully.');
      })
      .catch(() => {
        alert('Failed to delete staff member.');
      });
  };

  return (
    <div>
      {error && <p>{error}</p>}
      <ul>
        {staff.map(staffMember => (
          <li key={staffMember.id}>
            <p><strong>Name:</strong> {staffMember.firstName} {staffMember.lastName}</p>
            <p><strong>Email:</strong> {staffMember.email}</p>
            <p><strong>Competence:</strong> {staffMember.competence}</p>
            <p><strong>Position:</strong> {staffMember.position}</p>
            <button onClick={() => handleDeleteStaff(staffMember.id)}>Delete Staff</button>
          </li>
        ))}
      </ul>
      <button>Add New Staff</button>
    </div>
  );
};

export default StaffManagement;
