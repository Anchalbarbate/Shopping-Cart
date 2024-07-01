import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import './Sidebar.css'
import profilemenu from '../Assets/profile-menu.png'
import remove from '../Assets/remove-icon-white.png';


function Sidebar() {
  const [isOpen, setIsOpen] = useState(false);

  const toggleSidebar = () => {
    setIsOpen(!isOpen);
  };

  const closeSidebar = () => {
    setIsOpen(false);
  };

  return (
    <div>
      <img src={profilemenu} alt='' className='nav-logo-profile' onClick={toggleSidebar}/>
      <div className={`sidebar ${isOpen ? 'open' : ''}`}>
       <img src={remove} alt='' onClick={closeSidebar} className='close-btn'></img>
      
        <ul className='list-menu'>
          <li><Link to='/profile' style={{textDecoration:'none',color:'white'}}>Profile</Link></li>
    
          <li><Link to='/myorders'style={{textDecoration:'none',color:'white'}}>My Orders</Link></li>
          
          <li><Link style={{textDecoration:'none',color:'white'}}>Settings</Link></li>
          
        </ul>
      </div>
    </div>
  );
}

export default Sidebar;