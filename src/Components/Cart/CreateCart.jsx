function createCart(memberId) {

    fetch('http://localhost:8100/cart/newcart/'+memberId, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
    })
    .then(response => {
      if (!response.ok) {
        throw new Error('Failed to create cart');
      }
      return response.json();
    })
    .then(data => {
      console.log('Cart created successfully:', data);
      // Handle the response data as needed
    })
    .catch(error => {
      console.error('Error creating cart:', error);
      // Handle errors
    });
  }

  export default createCart;