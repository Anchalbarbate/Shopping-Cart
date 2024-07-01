import React from 'react'
import AdminNavbar from '../Components/Navbar/AdminNavbar'
import { OrderList } from '../Components/OrderManagement/OrderList'

export const OrderManagement = () => {
  return (
    <div>
      <AdminNavbar/>
      <OrderList/>
    </div>
  )
}
