import { useEffect,useState } from 'react';
import './App.css';
import Navbar from './Components/Navbar/Navbar';
import AdminNavbar from './Components/Navbar/AdminNavbar';
import { BrowserRouter,Routes,Route} from 'react-router-dom';
import ShopCategory from './Pages/ShopCategory';
import LoginSignUp from './Pages/LoginSignUp';
import Cart from './Pages/Cart';
import { Shop } from './Pages/Shop';
import { Product } from './Pages/Product';
import { AdminPage } from './Pages/AdminPage';
import { OrderManagement } from './Pages/OrderManagement';
import { UserManagement } from './Pages/UserManagement';
import { ProductManagement } from './Pages/ProductManagement';
import AddNewProduct from './Components/ProductManagement/AddNewProduct';
import Profile from './Pages/Profile';
import { Order } from './Pages/Order';




function App() {

    const [isAdmin, setIsAdmin] = useState(false);
  
    useEffect(() => {
      // Check if user is admin based on role stored in localStorage
      const userRole = localStorage.getItem('role');
      setIsAdmin(userRole === 'ADMIN');
      
    }, []);

  return (
    <div> 
      <BrowserRouter>
      {/* {isAdmin ? <AdminNavbar /> : <Navbar />} */}
      <Routes>
        <Route path='/'  element={<Shop/>}/>
        <Route path='/mens' element={<ShopCategory category="men"/>}/>
        <Route path='/womens' element={<ShopCategory category="women"/>}/>
        <Route path='/kids' element={<ShopCategory category="kid"/>}/>
        <Route path="/product" element={<Product/>}>
          <Route path=':productId' element={<Product/>}/>
        </Route>
        <Route path='/cart' element={<Cart/>}/>
        <Route path='/login' element={<LoginSignUp/>}/>
        <Route path='/Admin' element={<AdminPage/>}/>
        <Route path='/Orders' element={<OrderManagement/>}/>
        <Route path='/User' element={<UserManagement/>}/>
        <Route path='/ProductList' element={<ProductManagement/>}/>
        <Route path='/add-product' element={<AddNewProduct/>}/>
        <Route path="/update-product" element={<AddNewProduct/>}>
          <Route path=':productId' element={<AddNewProduct/>}/>
        </Route>
        <Route path='/profile' element={<Profile/>}/>
        <Route path='/myorders' element={<Order/>}/>
      </Routes>
      </BrowserRouter>
           
    </div>
    
    
  );
}

export default App;
