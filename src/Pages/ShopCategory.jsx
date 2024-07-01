import React, { useState, useEffect } from 'react';
import axios from 'axios';
import '../Components/Items/ItemList.css';

import { Link } from 'react-router-dom';
import Navbar from '../Components/Navbar/Navbar';


function ShopCategory({ category }) {
  const [products, setProducts] = useState([]);

  useEffect(() => {
    const fetchProducts = async () => {
      try {
        const response = await axios.get('http://localhost:8000/product/getAll');
        setProducts(response.data);
      } catch (error) {
        console.error('Error fetching products:', error);
      }
    };

    fetchProducts();
  }, []); 
   


  const filteredProducts = products.filter(product => product.category === category);

  return (
      <div>
       <Navbar/>
       <div className="product-container">
          <h2>{category.toUpperCase()} Products</h2>
          {filteredProducts.length > 0 ? (
            <div className="product-grid">
            {filteredProducts.map(product => (
              <Link style={{textDecoration: 'none',color:'black'}} key={product.productId} to={`/product/${product.productId}`} className="product-link">
                <div className="product-card">
                  <img src={product.imageUrl} alt={product.productName} />
                  <div className="product-details">
                    <h3>{product.productType}-{product.productName}</h3>
                    <p>{product.discription}</p>
                    <p>${product.price}</p>
                  </div>
                </div>
              </Link>
            ))}
          </div >
          ) : (
            <p className='product-notfound'>No products found for {category} category.</p>
          )}
        </div>
        </div>
  );
}

export default ShopCategory;