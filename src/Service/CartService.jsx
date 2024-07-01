import axios from 'axios'

const REST_API_BASE_URL='http://localhost:9100/cart';


export const cartitemlist=(cartId)=>axios.get(REST_API_BASE_URL+"/allItems"+'/'+cartId);

export const removeitem =(cartId,productId) =>axios.delete(REST_API_BASE_URL+'/'+cartId+"/removeItem"+'/'+productId);