package ibf.miniproject.ecommerce;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import ibf.miniproject.ecommerce.model.Country;
import jakarta.json.Json;
import jakarta.json.JsonObject;

public class CountryUtils {

    public static Country toCountry(SqlRowSet rs){
        Country country = new Country();
        country.setId(rs.getInt("id"));
        country.setName(rs.getString("name"));
        country.setCode(rs.getString("code"));
        return country;
    }

    public static JsonObject countryToJson(Country country){


        JsonObject json = Json.createObjectBuilder()
            .add("id", country.getId())
            .add("name", country.getName())
            .add("code", country.getCode())
            .build();

            return json;
        
    }
    
}
