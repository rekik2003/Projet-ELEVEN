import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import { AuthProvider } from './context/AuthContext';
import Header from './components/Header';
import Footer from './components/Footer';
import Home from './pages/Home';
import LoginPage from './pages/LoginPage';
import SignUpPage from './pages/SignUpPage';
import StaffPage from './pages/StaffPage';
import ProfilePage from './pages/ProfilePage';
import ReservationManagementPage from './pages/ReservationManagementPage';
// import ProtectedRoute from './components/ProtectedRoute';
import MatchPage from './pages/MatchPage';
import ReservationPage from './pages/ReservationPage';
import OrganizerPage from './pages/OrganizerPage';
import AdminPage from './pages/AdminPage';
import './styles/App.css';


function App() {
  return (
    <AuthProvider>
      <Router>
        <Header />
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/matches" element={<MatchPage />} />
          <Route path="/login" element={<LoginPage />} />
          <Route path="/signup" element={<SignUpPage />} />
          <Route path="/profile" element={<ProfilePage />} />
          <Route path="/organisateur" element={<OrganizerPage />} />
          <Route path="/participant" element={<ReservationPage />} />
          <Route path="/participant/:participantId/reservations" element={<ReservationManagementPage />} />
          <Route path="/admin" element={<AdminPage />} />
          <Route path="/personnels" element={<StaffPage />} />
          {/* <Route
            path="/profile"
            element={<ProtectedRoute element={<ProfilePage />} />}
          /> */}
          {/* <Route
            path="/organizer"
            element={<ProtectedRoute element={<OrganizerPage />} roleRequired="organizer" />}
          /> */}
          {/* <Route
            path="/admin"
            element={<ProtectedRoute element={<AdminPage />} roleRequired="admin" />}
          /> */}
        </Routes>
        <Footer />
      </Router>
    </AuthProvider>
  );
}

export default App;
