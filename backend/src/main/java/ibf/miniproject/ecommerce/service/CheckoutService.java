package ibf.miniproject.ecommerce.service;



import ibf.miniproject.ecommerce.PurchaseUtils;
import ibf.miniproject.ecommerce.model.Address;
import java.util.UUID;

import java.util.Set;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.mongodb.client.result.UpdateResult;

import ibf.miniproject.ecommerce.model.Customer;
import ibf.miniproject.ecommerce.model.OrderItem;
import ibf.miniproject.ecommerce.model.Orders;
import ibf.miniproject.ecommerce.model.PurchaseResponse;
import ibf.miniproject.ecommerce.model.Purchase;
import ibf.miniproject.ecommerce.repository.AddressRepository;
import ibf.miniproject.ecommerce.repository.CustomerRepository;
import ibf.miniproject.ecommerce.repository.OrderItemRepository;
import ibf.miniproject.ecommerce.repository.OrdersRepository;
import jakarta.transaction.Transactional;

@Service
public class CheckoutService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    OrderItemRepository orderItemRepository;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    OrdersRepository ordersRepository;

    @Autowired
    private MongoTemplate template;

    private static final String COMMENTS_COL = "commerce";

    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {
        Orders order = purchase.getOrder();

        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);

        Set<OrderItem> orderItems = purchase.getOrderItems();
        orderItems.forEach(item -> order.add(item));
        orderItems.forEach(item -> orderItemRepository.createOrderItem(item));


        Address shippingAddress = purchase.getShippingAddress();
        Integer addressId = addressRepository.createAddress(shippingAddress);
        order.setShippingAddressId(addressId);
        //order.setShippingAddress(purchase.getShippingAddress());

        Customer customer = purchase.getCustomer();
        Integer custmerId = customerRepository.createCustomer(customer);
        order.setCustomerId(custmerId);
        order.setCustomer(purchase.getCustomer());
        
        ordersRepository.createOrder(order);

        // Document doc= PurchaseUtils.toDocument(purchase, orderTrackingNumber);
        // System.out.println("------------------");

        // template.insert(doc, "COMMENTS_COL");


        insertIntoMongoDB(purchase, orderTrackingNumber);
        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
        return UUID.randomUUID().toString();
    }

    public void insertIntoMongoDB(Purchase purchase, String orderTrackingNumber){
        Document doc = PurchaseUtils.toDocument(purchase, orderTrackingNumber);
        Criteria criteria = Criteria.where("orderTrackingNumber").is(orderTrackingNumber);
        Query query = Query.query(criteria);
        Update updateOps = new Update().push("purchase", doc);
        UpdateResult result = template.upsert(query, updateOps, Document.class,COMMENTS_COL);
        System.out.printf("matched: %d\n", result.getMatchedCount());
		System.out.printf("modified: %d\n", result.getModifiedCount());

    }
    
}
