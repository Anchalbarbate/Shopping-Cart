import React, { useEffect, useState } from 'react'
import './UserList.css'
import { removeuser, userlist } from '../../Service/UserService'

export const UserList = () => {

  const [users,setUsers]=useState([])


  useEffect(()=>{
    getAllUser()
  },[])

  function getAllUser(){      
    userlist().then((response)=>{
      setUsers(response.data);
    }).catch(error=>{
      console.error(error);
    })
  }


  function removeUser(userId){
    console.log(userId);
    removeuser(userId).then(response=>{
      getAllUser()
    }).catch(error=>{
      console.log(error);
    })
  }

  

  return (
    <div className='container'>
    <h2>List Of Active Users</h2>
    <table className='container-table'>
        <thead>
            <tr>
                <th>User Id</th>
                <th>Username</th>
                <th>Password</th>
                <th>Email</th>
                <th>Address</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
          {
            users.map(user=>
              <tr key={user.memberId}>
                <td>{user.memberId}</td>
                <td>{user.name}</td>
                <td>{user.password}</td>
                <td>{user.emailId}</td>
                <td>{user.address}</td>
                <td >                 
                  <button onClick={()=>removeUser(user.memberId)} style={{background:"red",border:"none",outline:"none"}}> Remove</button>                 
                </td>
              </tr>)
          }
        </tbody>
    </table>

    </div>
    
  )
}