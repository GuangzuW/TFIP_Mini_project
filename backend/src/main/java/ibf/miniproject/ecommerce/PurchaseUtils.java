package ibf.miniproject.ecommerce;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import ibf.miniproject.ecommerce.model.OrderItem;
import ibf.miniproject.ecommerce.model.Purchase;
import ibf.miniproject.ecommerce.model.PurchaseResponse;
import jakarta.json.Json;
import jakarta.json.JsonObject;

public class PurchaseUtils {

    

    public static JsonObject purchaseResponeToJson(PurchaseResponse pr){

        JsonObject jsonObject = Json.createObjectBuilder()
            .add("orderTrackingNumber", pr.getOrderTrackingNumber())
            .build();
        return jsonObject;
    }

    public static Document toDocument(Purchase purchase, String orderTrackingNumber){

        Document doc = new Document();
        List productIds = new ArrayList<Integer>();
        for(OrderItem p : purchase.getOrderItems()){
            productIds.add(p.getProductId());
        }
        doc.put("orderTrackingNumber", orderTrackingNumber);
        System.out.println("orderTrackingNumber: " + orderTrackingNumber);
        doc.put("customerEmail", purchase.getCustomer().getEmail());
        doc.put("ProductIds", productIds);
        return doc;

    }
    
}
