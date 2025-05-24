// import React from 'react';
// import { useParams } from 'react-router-dom';
// import '../styles/Global.css'; // Global styles

// const MatchDetails = ({ matches }) => {
//   const { id } = useParams();

//   // Find the match with the given ID
//   const match = matches.find((match) => match.id === parseInt(id));

//   // If match is not found
//   if (!match) {
//     return <p>Match not found.</p>;
//   }

//   return (
//     <div className="container">
//       <h1>{match.title}</h1>
//       <p><strong>Competition:</strong> {match.competition}</p>
//       <p><strong>Date:</strong> {match.date}</p>
//       <p><strong>Location:</strong> {match.location}</p>
//       <p><strong>Description:</strong> {match.description}</p>
//       <p><strong>Maximum Participants:</strong> {match.maxNumberParticipants}</p>
//     </div>
//   );
// };

// export default MatchDetails;
