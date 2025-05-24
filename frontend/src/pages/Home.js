import '../styles/Global.css'; // Global styles
import '../styles/HomePage.css';
import profile1 from '../assets/profile1.png';
import profile2 from '../assets/profile2.png';
import profile3 from '../assets/profile3.png';
import picwhyus from '../assets/picwhyus.jpg';
import creditcard from '../assets/creditcard.png';


const Home = () => {
  
  return (
    <>
      <div className="hero-section">
            
      </div>
      <div className="container">

        <div class="testimonials">
          <h1>See What Our Users Say</h1>
          <div class="feedback-container">
            <div class="feedback">
              <img src={profile1} alt="User 1" class="profile-pic" />
              <p>George</p>
              <div class="stars">⭐⭐⭐⭐⭐</div>
              <p>"The service was excellent! Booking tickets has never been easier."</p>
            </div>
            <div class="feedback">
              <img src={profile2} alt="User 2" class="profile-pic" />
              <p>James</p>
              <div class="stars">⭐⭐⭐⭐⭐</div>
              <p>"Super fast and reliable. I love how simple everything is!"</p>
            </div>
            <div class="feedback">
              <img src={profile3} alt="User 3" class="profile-pic" />
              <p>Alex</p>
              <div class="stars">⭐⭐⭐⭐⭐</div>
              <p>"Fantastic experience from start to finish. Highly recommended!"</p>
            </div>
          </div>
      </div>

      <div class="why-us">
        <img src={picwhyus} alt="Why Use Us" class="why-us-image" />
        <div class="why-us-text">
          <h1>Why Use Us</h1>
          <p>
            Our company is dedicated to providing the best ticketing experience. With us, 
            you can enjoy fast, reliable, and secure bookings, ensuring you never miss your 
            favorite events. Our platform is user-friendly and trusted by thousands of 
            customers. Experience the difference with our hassle-free ticket solutions!
          </p>
        </div>
      </div>

      <div className="payment-info">
        <div className="payment-text">
          <h1>Secure and Trustworthy Payments</h1>
          <p>
            We use a variety of secure and trusted payment methods to ensure your transactions 
            are safe and hassle-free. Our tools are designed to provide you with the utmost 
            convenience and reliability for a seamless experience.
          </p>
        </div>
        <div className="payment-image">
          <img src={creditcard} alt="Credit Card Payment" />
        </div>
      </div>

      </div>
    </>
  );
};

export default Home;
