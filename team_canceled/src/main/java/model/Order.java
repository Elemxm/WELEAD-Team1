package model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)

public class Order extends BaseModel{
    private Store store;
    private Account account;
    private Date date;
    private ArrayList<Product> products; //Look into the data type, maybe keyValue pair with quantity?
    private BigDecimal total;
    private PaymentMethod paymentMethod;
    private BigDecimal deliveryTip;
}
