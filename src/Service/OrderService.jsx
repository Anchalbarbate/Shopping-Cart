import axios from 'axios'

const REST_API_BASE_URL='http://localhost:9100/order';


export const order=(customerId)=>axios.get(REST_API_BASE_URL+"/getOrderById"+'/'+customerId);

export const orderlist=()=>axios.get(REST_API_BASE_URL+"/getAllOrders");

export const cancelorder=(customerId)=>axios.delete(REST_API_BASE_URL+"/cancelOrder"+'/'+customerId);

