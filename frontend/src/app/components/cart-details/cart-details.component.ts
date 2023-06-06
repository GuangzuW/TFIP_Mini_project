import { Component, OnInit } from '@angular/core';
import { CartItem } from 'src/app/model/CartItem';
import { CartService } from 'src/app/services/cart.service';

@Component({
  selector: 'app-cart-details',
  templateUrl: './cart-details.component.html',
  styleUrls: ['./cart-details.component.css']
})
export class CartDetailsComponent implements OnInit{
  cartItems: CartItem[] = [];
  totalPrice: number = 0.00;
  totalQuantity: number = 0;

  constructor(private cartService: CartService) { }

  ngOnInit(): void {
    this.listCartDetails();
  } 
  listCartDetails() {
    this.cartItems = this.cartService.cartItems;
    this.cartService.totalPrice.subscribe(
      data => this.totalPrice = data
    );
    this.cartService.totalQuantity.subscribe(
      data => this.totalQuantity = data
    );
    this.cartService.computeCartTotals();
  }
  increaseQty(cartItem: CartItem){
    this.cartService.addToCart(cartItem);
  }
  decreaseQty(cartItem: CartItem){
    this.cartService.decreaseQty(cartItem);
  }
  remove(cartItem: CartItem){
    this.cartService.remove(cartItem);
  }

}
