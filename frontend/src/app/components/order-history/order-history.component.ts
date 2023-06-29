import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { OrderHistory } from 'src/app/model/OrderHistory';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-order-history',
  templateUrl: './order-history.component.html',
  styleUrls: ['./order-history.component.css']
})
export class OrderHistoryComponent implements OnInit{

  orderHistory: OrderHistory[] = []

  constructor( private productService: ProductService, 
    private route: ActivatedRoute ) { }

  ngOnInit(): void {
    this.listHistory();
  }

  listHistory(){
    this.productService.getOrderHistory().then((result)=>{
      this.orderHistory=result;
    }).catch(error => console.log(error));
  }
    

}
