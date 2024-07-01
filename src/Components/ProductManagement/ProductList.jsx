import React, { useEffect, useState } from 'react'
import { deleteProduct, listproducts } from '../../Service/ProductService'
import './ProductList.css' 
import { useNavigate } from 'react-router-dom'

export const ProductList = () => {

  const [products,setProduct]=useState([])
  const navigate=useNavigate();

  useEffect(()=>{
    getAllProduct()
  },[])

  function getAllProduct(){
       
    listproducts().then((response)=>{
      setProduct(response.data);
    }).catch(error=>{
      console.error(error);
    })
  }

  function AddProduct(){
        navigate('/add-product')
  }

  function updateProduct(productId){
    navigate('/update-product/'+productId)

  }

  function removeProduct(productId){
    console.log(productId);
    deleteProduct(productId).then(response=>{
      getAllProduct()
    }).catch(error=>{
      console.log(error);
    })
  }

  

  return (
    <div className='container'>
    <h2>List Of Available Products</h2>
    <button className='button' onClick={AddProduct}>Add Product</button>
    <table className='container-table'>
        <thead>
            <tr>
                <th>Product Id</th>
                <th>Type</th>
                <th>Name</th>
                <th>Category</th>
                <th>Quantity</th>
                <th>Price</th>
                <th>Url</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
          {
            products.map(product=>
              <tr key={product.productId}>
                <td>{product.productId}</td>
                <td>{product.productType}</td>
                <td>{product.productName}</td>
                <td>{product.category}</td>
                <td>{product.quantity}</td>
                <td>{product.price}</td>
                <td>{product.imageUrl}</td>
                <td >                 
                  <button onClick={()=>updateProduct(product.productId)}>Update</button>
                  <button onClick={()=>removeProduct(product.productId)} style={{background:"red",border:"none",outline:"none"}}> Delete</button>                 
                </td>
              </tr>)
          }
        </tbody>
    </table>

    </div>
    
  )
}
