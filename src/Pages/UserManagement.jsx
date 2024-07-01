import React from 'react'
import AdminNavbar from '../Components/Navbar/AdminNavbar'
import { UserList } from '../Components/UserManagement/UserList'

export const UserManagement = () => {
  return (
    <div>
      <AdminNavbar/>
      <UserList/>
    </div>
  )
}
