import React, { createContext } from 'react'
import { listproducts } from '../Service/ProductService';

export const ShopContext =createContext(null);

export const ShopContextProvider = (props) => {
    const contextValue=listproducts;
  return (
    <ShopContext.Provider value={contextValue}>
      {props.children}
    </ShopContext.Provider>
  )
}
export default ShopContextProvider;
