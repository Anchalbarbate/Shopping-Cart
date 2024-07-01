import axios from 'axios'

const REST_API_BASE_URL='http://localhost:8080/profile';


export const userlist =() =>axios.get(REST_API_BASE_URL+"/getProfile");

export const removeuser =(userId) =>axios.delete(REST_API_BASE_URL+"/removeprofile"+'/'+userId);
