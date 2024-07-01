import React from 'react'
import { ProductList } from '../Components/ProductManagement/ProductList'
import AdminNavbar from '../Components/Navbar/AdminNavbar'

export const ProductManagement = () => {
  return (
    <div>
      <AdminNavbar/>
      <ProductList/>
    </div>
    
  )
}


