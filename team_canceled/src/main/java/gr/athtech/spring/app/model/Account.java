package gr.athtech.spring.app.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class Account extends BaseModel {
    private String email;
    private String firstname;
    private String lastname;
    private ArrayList<Address> addresses;
    private Integer phone;
    private String password;
    private AccountCategory accountCategory;
}
