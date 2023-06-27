import { Address } from "./Address";
import { Customer } from "./Customer";
import { OrderItem } from "./OrderItem";
import { Orders } from "./Orders";

export class Purchase{
    customer!: Customer;
    shippingAddress!: Address;
    order!: Orders;
    orderItems!: OrderItem[];
    orderTrackingNumber!: string;
    
}