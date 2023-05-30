package ibf.miniproject.ecommerce;

import java.util.List;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import ibf.miniproject.ecommerce.model.Product;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;

public class ProductUtils {

    public static Product toProduct(SqlRowSet rs){
        Product product = new Product();
        product.setId(rs.getInt("id"));
        product.setSku(rs.getString("product_sku"));
        product.setName(rs.getString("product_name"));
        product.setDescription(rs.getString("product_description"));
        product.setUnitPrice(rs.getDouble("product_price"));
        product.setImageUrl(rs.getString("product_image"));
        product.setActive(rs.getBoolean("product_active"));
        product.setUnitsInStock(rs.getInt("product_units_in_stock"));
        product.setDateCreated(rs.getDate("product_date_created"));
        product.setLastUpdated(rs.getDate("product_last_updated"));
        product.setCategoryId(rs.getInt("category_id"));
        return product;
    }

    public static JsonObject productToJson(Product product){
        if(product.getLastUpdated()==null){
            product.setLastUpdated(product.getDateCreated());
        }
        JsonObject json = Json.createObjectBuilder()
            .add("id", product.getId())
            .add("sku", product.getSku())
            .add("name", product.getName())
            .add("description", product.getDescription())
            .add("unitPrice", product.getUnitPrice())
            .add("imageUrl", product.getImageUrl())
            .add("active", product.getActive())
            .add("unitsInStock", product.getUnitsInStock())
            .add("dateCreated", product.getDateCreated().toString())
            .add("lastUpdated", product.getLastUpdated().toString())
            .add("categoryId", product.getCategoryId())
            .build();
        return json;
    }

    public static JsonArray toJson(List<Product> products){

        JsonArrayBuilder builder = Json.createArrayBuilder();
        for(Product product : products){
            if(product.getLastUpdated()==null){
                product.setLastUpdated(product.getDateCreated());
            }

            builder.add(Json.createObjectBuilder()
                .add("id", product.getId())
                .add("sku", product.getSku())
                .add("name", product.getName())
                .add("description", product.getDescription())
                .add("unitPrice", product.getUnitPrice())
                .add("imageUrl", product.getImageUrl())
                .add("active", product.getActive())
                .add("unitsInStock", product.getUnitsInStock())
                .add("dateCreated", product.getDateCreated().toString())
                .add("lastUpdated", product.getLastUpdated().toString())
                .add("categoryId", product.getCategoryId())
            );
        }
        JsonArray jsonArray = builder.build();

        return jsonArray;
    }



    
}
