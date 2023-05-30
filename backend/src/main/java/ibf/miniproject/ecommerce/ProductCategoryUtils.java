package ibf.miniproject.ecommerce;

import java.util.List;

import ibf.miniproject.ecommerce.model.ProductCategory;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;

public class ProductCategoryUtils {
    public static JsonArray toJson(List<ProductCategory> productCategories) {
        JsonArrayBuilder builder = Json.createArrayBuilder();
        for (ProductCategory productCategory : productCategories) {
            builder.add(Json.createObjectBuilder()
                .add("id", productCategory.getId())
                .add("categoryName", productCategory.getCategoryName())
                .build());
        }
        JsonArray jsonArray = builder.build();
        return jsonArray;
    }
}
