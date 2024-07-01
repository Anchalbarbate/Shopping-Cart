import { GetCartItems } from "../Components/Cart/GetCartItems";


function Cart(){
    return(
        <div>
        <h2 style={{background:'black',textAlign:'center',color:'white',
         margin: '0%',fontSize: '40px',paddingTop:'2px',height:'70px'}}>My Cart</h2>
       <GetCartItems/>
        </div>
       
          
       
    )

}

export default Cart;