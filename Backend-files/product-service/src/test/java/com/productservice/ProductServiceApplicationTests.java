package com.productservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.productservice.exception.InvalidProductIDException;
import com.productservice.model.Product;
import com.productservice.repository.ProductRepository;
import com.productservice.service.ProductServiceImpl;


@SpringBootTest
class ProductServiceApplicationTests {
	
	//mock the ProductRepository
	 @Mock
	 ProductRepository productRepository;
	 
	//to inject mock
	 @InjectMocks
	 ProductServiceImpl productService;
	 
	 
   @Test
	public void testAddProduct(){ 				
		//mock data
		Product mockProduct=new Product("1","Bags","FancyBags","Sports",800);

		when(productRepository.save(mockProduct)).thenReturn(mockProduct);		
		Product product=productService.addproduct(mockProduct);		
		assertEquals(mockProduct, product);

}
   @Test
   public void testgetAllProducts(){
	   Product mockProduct1=new Product("1","Bags","FancyBags","Sports",800);
	   Product mockProduct2=new Product("2","Bags","FancyBags","Sports",800);
       List<Product>list=new ArrayList<>();
       list.add(mockProduct1);
       list.add(mockProduct2);
       
        when(productRepository.findAll()).thenReturn(list);		
		List<Product>list2=productService.getAllProducts();		
		assertEquals(2, list2.size());
	   
   }
//   @Test
//   public void getProductById() {
//	   
//        when(productRepository.existsByproductId("existingProductId")).thenReturn(true);
//	    String productId="101";
//	    Product mockProduct=new Product(productId,"Saree","WhiteSaree","Clothes",4000);
//	    productRepository.save(mockProduct);    
//		when(productRepository.findByproductId(productId)).thenReturn(mockProduct);		
//		Product foundProduct=productService.getProductById(productId);		
//		assertEquals(mockProduct, foundProduct);						
//  
//   }
   
   
   @Test
   public void testgetProductById() throws InvalidProductIDException{
       
       when(productRepository.existsByproductId("existingProductId")).thenReturn(true);
       
       // Mock behavior of the repository to return a product when findByproductId is called
       Product mockProduct = new Product(); // Create a mock product object
       when(productRepository.findByproductId("existingProductId")).thenReturn(mockProduct);

       // Call the method under test
       Product result = productService.getProductById("existingProductId");

       // Verify that the repository methods were called with the correct arguments
       verify(productRepository, times(1)).existsByproductId("existingProductId");
       verify(productRepository, times(1)).findByproductId("existingProductId");

       // Verify that the returned product matches the mock product
       assertSame(mockProduct, result);
   }
   
   
   
   @Test
   public void testgetProductById_ProductNotFound() throws InvalidProductIDException{
	   String productId="101";
       when(productRepository.findById(productId)).thenReturn(Optional.empty());
       assertThrows(InvalidProductIDException.class, () -> {
    	   productService.getProductById(productId);
       });
   }
   
   
   
   @Test
   public void testRemoveProductById_ProductExists() {
       // Mock behavior of the repository to return true when existsByproductId is called
       when(productRepository.existsByproductId("existingProductId")).thenReturn(true);
       
       // Mock behavior of the repository to return a product when deleteByproductId is called
       Product mockProduct = new Product(); 
       when(productRepository.deleteByproductId("existingProductId")).thenReturn(mockProduct);
       Product result = productService.removeProductById("existingProductId");
//
//       // Verify that the repository methods were called with the correct arguments
//       verify(productRepository, times(1)).existsByproductId("existingProductId");
//       verify(productRepository, times(1)).deleteByproductId("existingProductId");

       // Verify that the returned product matches the mock product
       assertSame(mockProduct, result);
   }
     
     @Test
     public void removeProductById_ProductNotFound()throws InvalidProductIDException{
    	 String productId="1";
         when(productRepository.findById(productId)).thenReturn(Optional.empty());
         assertThrows(InvalidProductIDException.class, () -> {
      	   productService.removeProductById(productId);
         });
     }
   
//   @Test
//   public void updateProduct(String productId,Product newproduct) {
//        
//	   Optional<Product> mockProduct=Optional.of(new Product("1","Bags","FancyBags","Sports",800));
//	   Product newmockProduct=new Product("1","Book","The Nun","Reading",800);
//	   when(productRepository.save(newmockProduct)).thenReturn(newmockProduct);	
//	   Product product=mockProduct.get();
//	   product.setProductType("Book");
//	   product.setProductName("The Nun");
//	   product.setCategory("Reading");
//	   Product updatedproduct=productService.updateProduct(productId,newmockProduct);		
//	   assertEquals(newmockProduct, updatedproduct);
//   
//   
//	}


}