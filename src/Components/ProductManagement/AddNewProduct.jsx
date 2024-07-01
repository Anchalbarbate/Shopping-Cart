import React, { useState } from 'react'
import { addProduct, getProduct, updateProduct } from '../../Service/ProductService'
import { useNavigate, useParams } from 'react-router-dom'
import './AddNewProduct.css'




export const AddNewProduct = () => {

    const navigate=useNavigate();

    const {productId}=useParams();

    const[errors,setErrors]=useState({
        productType:"",
        productName:"",
        category:"",
        price:"",
        quantity:"",
        imageUrl:"",
        description:""

    })

    const[productType,setProductType]=useState('')
    const[productName,setProductName]=useState('')
    const[category,setCategory]=useState('')
    const[price,setPrice]=useState('')
    const[quantity,setQuantity]=useState('')
    const[imageUrl,setImageUrl]=useState('')
    const[description,setDescription]=useState('')
   
    useState(()=>{
        if(productId){
            getProduct(productId).then((response)=>{
                setProductType(response.data.productType);
                setProductName(response.data.productName);
                setCategory(response.data.category);
                setPrice(response.data.price);
                setQuantity(response.data.quantity);
                setImageUrl(response.data.imageUrl);
                setDescription(response.data.description);

            }).catch(error=>{
                console.error(error);
            })
                
        }

    },[productId])
    
    function saveOrUpdateProduct(e){
        e.preventDefault();
        if(validateForm){
            const product={productType,productName,category,price,quantity,imageUrl,description}
            console.log(product)
            if(productId){
                updateProduct(productId,product).then(response=>{
                    console.log(response.data);
                    navigate('/ProductList')
                }).catch(error=>{
                    console.error(error);
                })

            }else{
                addProduct(product).then((response)=>{
                console.log(response.data)
                navigate('/ProductList');
               }).catch(error=>{
                console.error(error);
               })
                
            }    

        }  
        
    }

    function validateForm(){
        let valid=true;
        const errorsCopy={...errors}

        if(productType.trim()){
             errorsCopy.productType=''
        }else{
            errorsCopy.productType='Product Type is required';
            valid=false;
        }

        if(productName.trim()){
            errorsCopy.productName=''
        }else{
            errorsCopy.productName='Product Name is required';
            valid=false;
        }

        if(category.trim()){
            errorsCopy.category=''
        }else{
            errorsCopy.category='category is required';
            valid=false;
        }

        if(price.trim()){
            errorsCopy.price=''
        }else{
            errorsCopy.price='price is required';
            valid=false;
        }

        if(quantity.trim()){
            errorsCopy.quantity=''
        }else{
            errorsCopy.quantity='quantity is required';
            valid=false;
        }

        if(imageUrl.trim()){
            errorsCopy.imageUrl=''
        }else{
            errorsCopy.imageUrl='imageUrl is required';
            valid=false;
        }

        if(description.trim()){
            errorsCopy.description=''
        }else{
            errorsCopy.description='quantity is required';
            valid=false;
        }

        setErrors(errorsCopy);
        return valid;

    }

    function pageTitle(){
        if(productId){
            return  <h2 className='text'>Update Product</h2>
        }else{
            return  <h2 className='text'>Add Product</h2>
        }
      }

  return (
        <div className='container-main'>
            <div className='container-form'>            
            {
                pageTitle()
            }
            <form className='form'>
                <div className='form-group'>
                    <label className='form-label'>Product Type:</label><br/>
                    <input
                      type='text'
                      placeholder='Enter Product Type'
                      name='productType'
                      value={productType}
                      className={`form-control ${errors.productType?'is-invalid':''}`}
                      onChange={(e)=> setProductType(e.target.value)}
                    />
                    {errors.productType&&  <div className='invalid-feedback'>{errors.productType}</div>}
                </div>
                <div className='form-group'>
                    <label className='form-label'>Product Name:</label><br/>
                    <input
                      type='text'
                      placeholder='Enter Product Name'
                      name='productName'
                      value={productName}
                      className={`form-control ${errors.productName?'is-invalid':''}`}
                      onChange={(e)=> setProductName(e.target.value)}
                    />
                    {errors.productName&&  <div className='invalid-feedback'>{errors.productName}</div>}
                </div>
                <div className='form-group'>
                    <label className='form-label'>Category:</label><br/>
                    <input
                      type='text'
                      placeholder='Enter Product Type'
                      name='category'
                      value={category}
                      className={`form-control ${errors.category?'is-invalid':''}`}
                      onChange={(e)=> setCategory(e.target.value)}
                    />
                    {errors.category&&  <div className='invalid-feedback'>{errors.category}</div>}
                </div>
                <div className='form-group'>
                    <label className='form-label'>Price:</label><br/>
                    <input
                      type='text'
                      placeholder='Enter Product Price'
                      name='price'
                      value={price}
                      className={`form-control ${errors.price?'is-invalid':''}`}
                      onChange={(e)=> setPrice(e.target.value)}
                    />
                    {errors.price&&  <div className='invalid-feedback'>{errors.price}</div>}
                </div>
                <div className='form-group'>
                    <label className='form-label'>Quantity:</label><br/>
                    <input
                      type='text'
                      placeholder='Enter Product Quantity'
                      name='quantity'
                      value={quantity}
                      className={`form-control ${errors.quantity?'is-invalid':''}`}
                      onChange={(e)=> setQuantity(e.target.value)}
                    />
                    {errors.quantity&&  <div className='invalid-feedback'>{errors.quantity}</div>}
                </div>
                <div className='form-group'>
                    <label className='form-label'>Image Url:</label><br/>
                    <input
                      type='text'
                      placeholder='Enter Product Image Url'
                      name='imageUrl'
                      value={imageUrl}
                      className={`form-control ${errors.imageUrl?'is-invalid':''}`}
                      onChange={(e)=> setImageUrl(e.target.value)}
                    />
                    {errors.imageUrl&&  <div className='invalid-feedback'>{errors.imageUrl}</div>}
                </div>
                <div className='form-group'>
                    <label className='form-label'>Description:</label><br/>
                    <input
                      type='text'
                      placeholder='Enter Product Description'
                      name='description'
                      value={description}
                      className={`form-control ${errors.description?'is-invalid':''}`}
                      onChange={(e)=> setDescription(e.target.value)}
                    />
                    {errors.description&&  <div className='invalid-feedback'>{errors.description}</div>}
                </div>
                <button onClick={saveOrUpdateProduct}>Submit</button>
            </form>
            </div>
           
        </div>
       
  )
}
export default AddNewProduct;
