
import axios from 'axios'

const REST_API_BASE_URL='http://localhost:9100/product';


export const listproducts =() =>axios.get(REST_API_BASE_URL+"/getAll");

export const addProduct =(product) =>axios.post(REST_API_BASE_URL+"/add",product);

export const getProduct=(productId)=>axios.get(REST_API_BASE_URL+'/'+productId);

export const updateProduct =(productId,product) =>axios.put(REST_API_BASE_URL+"/update"+'/'+productId,product);

export const deleteProduct=(productId)=>axios.delete(REST_API_BASE_URL+"/remove"+'/'+productId);



