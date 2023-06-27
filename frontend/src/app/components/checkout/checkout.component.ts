import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { BehaviorSubject, Subject } from 'rxjs';
import { OrderItem } from 'src/app/model/OrderItem';
import { Orders } from 'src/app/model/Orders';
import { Purchase } from 'src/app/model/Purchase';
import { CartService } from 'src/app/services/cart.service';
import { CheckoutService } from 'src/app/services/checkout.service';
import { FormService } from 'src/app/services/form.service';

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent implements OnInit{

  checkoutForm!: FormGroup;

  totalPrice: number = 0;
  totalQuantity: number = 0;

  creditCardYears: number[] = [];
  creditCardMonths: number[] = [];

  orderTrackingNumber!: string;

  constructor(private formBuilder:FormBuilder, 
              private formService: FormService, 
              private cartService: CartService, 
              private checkoutService: CheckoutService, 
              private router: Router) { }

  ngOnInit(): void {
    this.reviewCartDetails();
    this.checkoutForm = this.formBuilder.group({
      customer: this.formBuilder.group({
        firstName: new FormControl('',[Validators.required, Validators.minLength(3)]),
        lastName: new FormControl('',[Validators.required, Validators.minLength(3)]),
        email: new FormControl('',[Validators.required, Validators.email]),
      }), 
      
      shippingAddress: this.formBuilder.group({
        blockNumber: new FormControl('',[Validators.required, Validators.minLength(2)]),
        streetName: new FormControl('',[Validators.required, Validators.minLength(3)]),
        unitNumber: new FormControl('',[Validators.required, Validators.minLength(2)]),
        country: new FormControl('',[Validators.required, Validators.minLength(3)]),
        postCode: new FormControl('',[Validators.required, Validators.pattern('[0-9]{6}')]),
      }),
      creditCard: this.formBuilder.group({
        cardType: new FormControl('',[Validators.required]),
        nameOnCard: new FormControl('',[Validators.required, Validators.minLength(3)]),
        cardNumber: new FormControl('',[Validators.required, Validators.pattern('[0-9]{16}')]),
        securityCode: new FormControl('',[Validators.required, Validators.pattern('[0-9]{3}')]),
        expiryMonth: new FormControl('',[Validators.required]),
        expiryYear: new FormControl('',[Validators.required])
      })
    });
    const startMonth: number = new Date().getMonth() + 1;
    console.log("startMonth: " + startMonth)
    this.formService.getCreditCardMonths(startMonth).subscribe(
      data =>{
        console.log("Retrieved credit card month: " + JSON.stringify(data));
        this.creditCardMonths = data;
      }
    );
    this.formService.getCreditCardYears().subscribe(
      data => {
        console.log("Retrieved credit card years: " + JSON.stringify(data));
        this.creditCardYears = data;
      }
    );

  }

  reviewCartDetails() {
    this.cartService.totalQuantity.subscribe(
      totalQuantity=> this.totalQuantity = totalQuantity
    );
    this.cartService.totalPrice.subscribe(
      totalPrice => this.totalPrice = totalPrice
    );
  }

  get firstName(){
    return this.checkoutForm.get('customer.firstName');
  }
  get lastName(){
    return this.checkoutForm.get('customer.lastName');
  }
  get email(){
    return this.checkoutForm.get('customer.email');
  }
  get blockNumber(){
    return this.checkoutForm.get('shippingAddress.blockNumber');
  }
  get streetName(){
    return this.checkoutForm.get('shippingAddress.streetName');
  }
  get unitNumber(){
    return this.checkoutForm.get('shippingAddress.unitNumber');
  }
  get country(){
    return this.checkoutForm.get('shippingAddress.country');
  }
  get postCode(){
    return this.checkoutForm.get('shippingAddress.postCode');
  }
  get cardType(){
    return this.checkoutForm.get('creditCard.cardType');
  }
  get nameOnCard(){
    return this.checkoutForm.get('creditCard.nameOnCard');
  }
  get cardNumber(){
    return this.checkoutForm.get('creditCard.cardNumber');
  }
  get securityCode(){
    return this.checkoutForm.get('creditCard.securityCode');
  }
  get expiryMonth(){
    return this.checkoutForm.get('creditCard.expiryMonth');
  }
  get expiryYear(){
    return this.checkoutForm.get('creditCard.expiryYear');
  }

  onSubmit(){
    console.log("Handling the submit button");
    if(this.checkoutForm.invalid){
      this.checkoutForm.markAllAsTouched();
      return
    }
    console.log(this.checkoutForm.get('customer')?.value);
    //order
    let order = new Orders();
    order.totalPrice = this.totalPrice;
    order.totalQuantity = this.totalQuantity;

    //orderItems
    const cartItems = this.cartService.cartItems;
    let orderItem: OrderItem[] = [];
    for(let i=0; i<cartItems.length; i++){
      orderItem[i] = new OrderItem(cartItems[i]);
    }
    // let orderItems: OrderItem[] = cartItems.map(tempCartItem => new OrderItem(tempCartItem));

    //purchase
    let purchase = new Purchase();

    //populate purchase - customer
    purchase.customer = this.checkoutForm.controls['customer'].value;

    purchase.shippingAddress = this.checkoutForm.controls['shippingAddress'].value;

    purchase.order = order;
    purchase.orderItems = orderItem;

    this.checkoutService.placeOrder(purchase).subscribe(
      {
        next: response => {
          alert(`Your order has been received.\nOrder tracking number: ${response.orderTrackingNumber}`);
          this.resetCart();
        },
        error: err => {
          alert(`There was an error: ${err.message}`);
        }
      }
    );




  }
  resetCart() {
    this.cartService.cartItems = [];
    this.cartService.totalPrice.next(0);
    this.cartService.totalQuantity.next(0);
    this.checkoutForm.reset();
    this.router.navigateByUrl("/");
  }

  handleMonthsAndYears(){
    const creditCardFormGroup = this.checkoutForm.get('creditCard');

    const currentYear: number = new Date().getFullYear();
    const selectedYear: number =Number(creditCardFormGroup?.value.expiryYear);

    let startMonth: number;

    if(currentYear == selectedYear){
      startMonth = new Date().getMonth() + 1;
    }else {
      startMonth = 1;
    }
    this.formService.getCreditCardMonths(startMonth).subscribe(
      data => {
        console.log("retrieved credit card months: " + JSON.stringify(data));
        this.creditCardMonths = data;
      }
    );
  }

}
