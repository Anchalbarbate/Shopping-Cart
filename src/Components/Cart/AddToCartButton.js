import React from 'react';
import { useNavigate } from 'react-router-dom';



function AddToCartButton({ productId }) {

  const cartId = localStorage.getItem('userId');
  const navigate = useNavigate()
  
  
  const handleAddToCart = () => {
    if (cartId) {
      // Make a request to add the product to the cart using the cartId
     
      fetch(`http://localhost:8100/cart/addItem/${cartId}/product/${productId}`, { method: 'POST' });
      console.log('Adding product to cart:', cartId);
      alert('Product added successfully')
    } else {
      // Redirect to login or registration page if user is not logged in
         navigate('/login');
    }
  };

  return (
    <button onClick={handleAddToCart}>Add to Cart</button>
  );
}


export default AddToCartButton;