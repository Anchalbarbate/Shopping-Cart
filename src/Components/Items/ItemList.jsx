import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import './ItemList.css';
import { listproducts } from '../../Service/ProductService';



function ItemList() {
  const [products, setProducts] = useState([]);

  useEffect(() => {
     listproducts().then((response)=>{
    setProducts(response.data);
  }).catch(error=>{
    console.error(error);
  })
  
   }, []);
  

  return (
    <div class="product-container">
    
      <div class="product-grid">
        {products.map(product => (
          <Link style={{textDecoration: 'none',color:'black'}} key={product.productId} to={`/product/${product.productId}`} className="product-link">
            <div class="product-card">    
              <img src={product.imageUrl} alt={product.productName} />     
              <div class="product-details">
                <p><b>{product.productType}-{product.productName}</b><br/>{product.discription}<br/><b>${product.price}</b></p>
                {/* <p>${product.price}</p> */}
              </div>
            </div>
          </Link>
        ))}
      </div>
    </div>
  );
}

export default ItemList;