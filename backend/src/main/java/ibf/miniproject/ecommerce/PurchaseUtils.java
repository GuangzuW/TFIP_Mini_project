package ibf.miniproject.ecommerce;

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
    
}
