import React, { useState, useEffect} from 'react';
import { useParams } from 'react-router-dom';

import './Item.css'
import AddToCartButton from '../Cart/AddToCartButton';



function Item() {
  const [product, setProduct] = useState(null);
  const { productId } = useParams();

  useEffect(() => {
   
    fetch(`http://localhost:8000/product/${productId}`)
      .then(response => response.json())
      .then(data => {
        setProduct(data);
      })
      .catch(error => {
        console.error('Error fetching product details:', error);
      });
  }, [productId]);



  if (!product) {
    return <div>Loading...</div>;
  }
  
 

  return (
    
      <div className="product-display">
      <div className="product-left">
        <div className="product-left-img">
          <img className="left-main-img" src={product.imageUrl} alt={product.productName} /> 
        </div>
        
      </div>
      <div className="product-right">
        <h1>{product.productName}</h1>
        <div className="product-right-price">
         <p>{product.discription}</p>
        </div>
        <div className="product-right-price">
          <p>${product.price}</p>
        </div>        
        <AddToCartButton productId={productId}/>
        
      </div>
    </div>
    
    
  );
}

export default Item;