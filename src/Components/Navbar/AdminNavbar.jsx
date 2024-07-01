import React, { useState } from 'react';
import './Navbar.css'
import logo1 from '../Assets/logo1.png'
import { Link } from 'react-router-dom';

export const AdminNavbar = () => {

    const[menu,setMenu]=useState("")
  return (
    <div className='navbar'>
            <div className='nav-logo'>

            <img src={logo1} alt="" />
            <p>GoTrendy</p>
    
            </div>

            <ul className='nav-menu'>
                <li onClick={()=>{setMenu("ProductManagement")}}><Link  style={{textDecoration:'none',color:'white'}} to='/ProductList'>ProductManagement</Link>{menu==="ProductManagement"?<hr/>:<></>}</li>
                <li onClick={()=>{setMenu("OrderManagement")}}><Link style={{textDecoration:'none',color:'white'}} to='/Orders'>OrderManagement</Link>{menu==="OrderManagement"?<hr/>:<></>}</li>
                <li onClick={()=>{setMenu("UserManagement")}}><Link style={{textDecoration:'none',color:'white'}} to='/User'>UserManagement</Link>{menu==="UserManagement"?<hr/>:<></>}</li>
            </ul>

            <div className='nav-login-cart'>
                
                <button onClick={()=>{localStorage.removeItem('token');localStorage.removeItem('userId');localStorage.removeItem('role');window.location.replace('/')}}>Logout</button>         
                

            </div>
          

        </div>
  )
}
export default AdminNavbar;