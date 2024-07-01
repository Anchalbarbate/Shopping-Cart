import React, { useState } from 'react';
import './Navbar.css'
import logo1 from '../Assets/logo1.png'
import carticon from '../Assets/carticon.png'
import { Link } from 'react-router-dom';
import Sidebar from '../ProfileMenu/Sidebar';


function Navbar(){

    const[menu,setMenu]=useState("shop")
    
    return(
        <div className='navbar'>
            <div className='nav-logo'>
            {localStorage.getItem('token')
            ?<Sidebar/>:<></>}
            <img src={logo1} alt="" />
            <p>GoTrendy</p>
    
            </div>

            <ul className='nav-menu'>
                <li onClick={()=>{setMenu("shop")}}><Link  style={{textDecoration:'none',color:'white'}} to='/'>Shop</Link>{menu==="shop"?<hr/>:<></>}</li>
                <li onClick={()=>{setMenu("mens")}}><Link style={{textDecoration:'none',color:'white'}} to='/mens'>Men</Link>{menu==="mens"?<hr/>:<></>}</li>
                <li onClick={()=>{setMenu("womens")}}><Link style={{textDecoration:'none',color:'white'}} to='/womens'>Women</Link>{menu==="womens"?<hr/>:<></>}</li>
                <li onClick={()=>{setMenu("kids")}}><Link style={{textDecoration:'none',color:'white'}} to='/kids'>Kids</Link>{menu==="kids"?<hr/>:<></>}</li>
            </ul>

            <div className='nav-login-cart'>
                {localStorage.getItem('token')
                ?<button onClick={()=>{localStorage.removeItem('token');localStorage.removeItem('userId');localStorage.removeItem('role');window.location.replace('/')}}>Logout</button>
                :<Link to='/login'><button>Login</button></Link>}  
                <Link to='/cart'><img src={carticon} alt="" /></Link>
                <div className='nav-cart-count'>0</div>

            </div>
          

        </div>
    )
}

export default Navbar