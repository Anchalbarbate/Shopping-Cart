import React, { useEffect, useState } from 'react'
import './Orderdetail.css'
import { Link} from 'react-router-dom';
import { order } from '../../Service/OrderService';

export const Orderdetail = () => {

  const [products, setProducts] = useState([]);
  let userId = localStorage.getItem("userId");
    
    useEffect(() => {      
       getOrder()
    }, []);
    
    function getOrder(){
      order(userId).then((response)=>{
        setProducts(response.data);
      }).catch(error=>{
        console.error(error);
      })
    }

    if (products.length === 0) {
      return (<div className='empty-order'> 
        <h2>No Order placed</h2> 
        <Link to='/'><h3>Continue Shopping</h3></Link>
        </div>
      );
  }


  return (
    <div className="product-container">
      <div className="product-left">
      </div>
      <div className="product-right">   
      </div>
    </div>
  )
}
