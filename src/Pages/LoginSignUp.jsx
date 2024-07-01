
import React,{useState} from "react";
import './CSS/login.css'
import { useNavigate } from "react-router-dom";

import createCart from "../Components/Cart/CreateCart";


function LoginSignUp(){

    const navigate=useNavigate();

    const[state,setState]=useState("Login");
    const [formData,setFormData]=useState({
        name:"",
        password:"",
        emailId:"",
        phoneNo:"",
        gender:"",
        role:"",

    })

    const changeHandler=(e)=>{
        setFormData({...formData,[e.target.name]:e.target.value})
    }
     
    const login=async()=>{
        console.log("Login Function executed",formData)
 
        try {
            const response = await fetch('http://localhost:8080/profile/authenticate', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(formData)
            });

            if (response.ok) {
                const data = await response.json();
                // Store token in local storage
                localStorage.setItem('token', data.token);
                localStorage.setItem("userId",data.memberId);
                localStorage.setItem("role",data.role);
                console.log('Authentication successful');
                if(data.role==='ADMIN'){
                    navigate('/Admin')
                }
                else{
                    navigate('/')
                }
                    
                
            } else {
                console.error('Authentication failed');
                alert("username or password is incorrect")
            }
        } catch (error) {
            console.error('Error authenticating user:', error);
        }
    };


    const signup=async()=>{
    

        try {
            const response = await fetch('http://localhost:8080/profile/adduser', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(formData)
            });
            

            if (response.ok) {
                console.log('Registration successful');
                const data = await response.json();
                createCart(data.memberId);
                setState("Login");
                navigate('/login')

            
            } else {
                console.error('Registration failed:',response.statusText);
                alert(response.error)
            }
        } catch (error) {
            console.error('Error registering user:', error);
        }

    }

    return(
        <div>
        <div className="header">
            <h2>Welcome to GoTrendy !</h2>
        </div> 
        <div className="loginsignup">
        
            <div className="loginsignup-container">
                <h1>{state}</h1>
                <div className="loginsignup-fields">
                    {state==="Sign Up"?
                     <>
                     <input name='name' value={formData.name}  onChange={changeHandler} type="text" placeholder="Username" />
                     <input name='emailId' value={formData.emailId} onChange={changeHandler} type="email" placeholder="Email Address" />
                     <input name='phoneNo' value={formData.phoneNo} onChange={changeHandler} type="tel" placeholder="Phone Number" />
                     <div className="gender-radio">
                                <label>
                                    <input
                                        type="radio"
                                        name="gender"
                                        value="Male"
                                        checked={formData.gender === "Male"}
                                        onChange={changeHandler}
                                    />
                                    Male
                                </label>
                                <label>
                                    <input
                                        type="radio"
                                        name="gender"
                                        value="Female"
                                        checked={formData.gender === "Female"}
                                        onChange={changeHandler}
                                    />
                                    Female
                                </label>
                                <label>
                                    <input
                                        type="radio"
                                        name="gender"
                                        value="Other"
                                        checked={formData.gender === "Other"}
                                        onChange={changeHandler}
                                    />
                                    Other
                                </label>
                        </div>
                     <input name='role' value={formData.role}  onChange={changeHandler} type="text" placeholder="Role" />
                     <input name='password' value={formData.password}  onChange={changeHandler} type="password" placeholder="Password" />
                     <textarea name='address' value={formData.address} onChange={changeHandler} placeholder="Address"></textarea>
                 </>
                 : <>
                 <input name='name' value={formData.name}  onChange={changeHandler} type="text" placeholder="Username" />
                 <input name='password' value={formData.password}  onChange={changeHandler} type="password" placeholder="Password" /></>}
                          
                    
                </div>
                                   
                <button onClick={()=>{state==="Login"?login():signup()}}>Continue</button>
                {state==="Sign Up"
                ?<p className="loginsignup-login">Already have an account?<span onClick={()=>{setState("Login")}}>Login here</span></p>
                :<p className="loginsignup-login">Create an account?<span onClick={()=>{setState("Sign Up")}}>Click here</span></p>
                }
                <div className="loginsignup-agree">
                  <input type="checkbox" name="" id="" />
                  <p>By continuing, I agree the terms of use and privacy policy.</p>
                </div>
                

            </div>
            
        </div>
        </div>
    )

}

export default LoginSignUp;