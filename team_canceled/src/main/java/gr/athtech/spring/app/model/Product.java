package gr.athtech.spring.app.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.ArrayList;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)

public class Product extends BaseModel {
    private String name;
    private BigDecimal price;
    private String description;
    private Integer quantity;   // what is that used for?
    private ArrayList<ProductCategory> categories;
}
