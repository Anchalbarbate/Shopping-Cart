import React, { useEffect, useState } from 'react'
import { cancelorder, orderlist } from '../../Service/OrderService'

export const OrderList = () => {

  const [orders,setOrders]=useState([])


  useEffect(()=>{
    getAllOrders()
  },[])

  function getAllOrders(){      
    orderlist().then((response)=>{
      setOrders(response.data);

    }).catch(error=>{
      console.error(error);
    })
  }


  function CancelOrder(userId){
    console.log(userId);
    cancelorder(userId).then(response=>{
      getAllOrders()
    }).catch(error=>{
      console.log(error);
    })
  }

  

  return (
    <div className='container'>
    <h2>List Of Orders</h2>
    <table className='container-table'>
        <thead>
            <tr>
                <th>Order Id</th>
                <th>Order Date</th>
                <th>Customer Id</th>
                <th>Ammount Paid</th>
                <th>Mode of Payment</th>
                <th>Status</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
          {
            orders.map(order=>
              <tr key={order.orderId}>
                    <td>{order.orderId}</td>
                <td>{order.orderDate}</td>
                <td>{order.customerId}</td>
                <td>{order.ammountpaid}</td>
                <td>{order.modeOfPayment}</td>
                <td>{order.orderStatus}</td>
                <td >                 
                  <button onClick={()=>CancelOrder(order.customerId)} style={{background:"red",border:"none",outline:"none"}}> Cancel</button>                 
                </td>
              </tr>)
          }
        </tbody>
    </table>

    </div>
    
  )
}