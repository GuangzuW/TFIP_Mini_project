import { Injectable } from '@angular/core';
import { BehaviorSubject, Subject } from 'rxjs';
import { CartItem } from '../model/CartItem';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  cartItems: CartItem[] = [];
  // totalPrice: Subject<number> = new Subject<number>();
  // totalQuantity: Subject<number> = new Subject<number>();

  totalPrice: Subject<number> = new BehaviorSubject<number>(0);
  totalQuantity: Subject<number> = new BehaviorSubject<number>(0);

  addToCart(cartItem: CartItem){

    let itemExists: boolean = false;
    let existingCartItem: CartItem = undefined!;

    if(this.cartItems.length>0){
      for(let tempCartItem of this.cartItems){
        if(tempCartItem.id === cartItem.id){
          existingCartItem = tempCartItem;
          break;
        }
      }
      // existingCartItem = this.cartItems.find(tempCartI tem => tempCartItem.id === cartItem.id)!;
      itemExists = (existingCartItem != undefined);
    }
    if(itemExists){
      existingCartItem.quantity++;
    }else{
      this.cartItems.push(cartItem);
    }
    this.computeCartTotals();
  } 
  constructor() { }

  computeCartTotals(){
    let totalPriceValue: number = 0;
    let totalQuantityValue: number = 0;

    for(let item of this.cartItems){
      totalPriceValue += item.quantity * item.unitPrice;
      totalQuantityValue += item.quantity;
    }
    //publish the new values ... all subscribers will receive the new data
    this.totalPrice.next(totalPriceValue);
    this.totalQuantity.next(totalQuantityValue);
    this.logCartData(totalPriceValue, totalQuantityValue);
  }
  logCartData(totalPriceValue: number, totalQuantityValue: number) {
    console.log('Contents of the cart');
    for(let item of this.cartItems){
      const subTotalPrice = item.quantity * item.unitPrice;
      console.log(`name: ${item.name}, quantity: ${item.quantity}, unitPrice: ${item.unitPrice}, subTotalPrice: ${subTotalPrice}`);
    } 
    console.log(`totalPrice: ${totalPriceValue.toFixed(2)}, totalQuantity: ${totalQuantityValue}`);
    console.log('----');
  }

  decreaseQty(cartItem: CartItem) {
    cartItem.quantity--;
    if(cartItem.quantity === 0){
      this.remove(cartItem);
    }else{
      this.computeCartTotals();
    }
  } 

  remove(cartItem: CartItem) {  
    // get index 
    const itemIndex = this.cartItems.findIndex(tempCartItem => tempCartItem.id === cartItem.id);
    if(itemIndex > -1){// if found
      this.cartItems.splice(itemIndex, 1);// remove item at the given index
      this.computeCartTotals();// recalculate cart totals
    }
  } 
}
