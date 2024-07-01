import React from 'react'
import { Orderdetail } from '../Components/ProfileMenu/Orderdetail'

export const Order = () => {
  return (
    <div>
      <h2 style={{background:'black',textAlign:'center',color:'white',
         margin: '0%',fontSize: '40px',paddingTop:'2px',height:'70px'}}>My Orders</h2>
         <Orderdetail/>
    </div>
    
  )
}
