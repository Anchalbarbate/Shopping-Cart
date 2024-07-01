
import React, { useState, useEffect } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import './GetCartItems.css'
import remove from '../Assets/remove-icon.png';
import { cartitemlist, removeitem } from '../../Service/CartService';




export const GetCartItems = () => {
    const [products, setProducts] = useState([]);
    let cartId = localStorage.getItem("userId");
    const navigate=useNavigate();
   
    
    useEffect(() => {    
      if (!cartId) {    
        navigate('/login');
       }
       getCartItems()

    }, []);

    function getCartItems(){
      cartitemlist(cartId).then((response)=>{
        setProducts(response.data);
      }).catch(error=>{
        console.error(error);
      })
    }
  
    if (products.length === 0) {
      return (<div className='empty-order'> 
        <h2>Your Cart is Empty</h2> 
        <Link to='/'><h3>Start Shopping</h3></Link>
        </div>
      );
  }

    function getSubTotal() {
        let total=0;
        {products.map(product=>(
         total+= product.price*product.quantity
          
        )
        )}
        return total;
    }

    function removeProduct(productId){
      console.log(productId);
      removeitem(cartId,productId).then(response=>{
        getCartItems()
      }).catch(error=>{
        console.log(error);
      })
    }
     
  
    return (
      <div className='cartitems'> 
      <div className='cartitems-format-main'>
        <p>Product</p>
        <p>Product ID</p>
        <p>Product Name</p>
        <p>Quantity</p>
        <p>Price</p>
        <p>Total</p>
        <p>Remove</p>
      </div>
      <hr/>
      
        {products.map(product => (
          <div>
          <div className='cartitem-format cartitems-format-main'>
          <img src={product.imageUrl} alt='' className='cartitem-product-icon'/>
          <p>{product.productId}</p>
          <p>{product.productName}</p>
          <p>{product.quantity}</p>
          <p>{product.price}</p>
          <p>{product.quantity*product.price}</p>
          <img src={remove} alt='' className='cartitem-remove-icon' onClick={()=>removeProduct(product.productId)}></img>
          </div>
          <hr/>
          </div>



        ))}
        <div className='cartitems-down'>
          <div className='cartitems-total'>
            <h2>Cart Total</h2>
            <div>
              <div className='cartitems-total-item'>
                <p>Subtotal</p>
                <p>${getSubTotal()}</p>

              </div>
              <hr/>
              <div className='cartitems-total-item'>
                <p>Sheeping Fee</p>
                <p>Free</p>
              </div>
              <hr/>
              <div className='cartitems-total-item'>
                 <h3>Total</h3>
                 <h3>${getSubTotal()}</h3>
              </div>
            </div>
            <button>Place Order</button>
          </div>
        </div>
        
      </div>


    );
}
