package gr.athtech.spring.app.transfer.resource;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import gr.athtech.spring.app.model.AccountCategory;

import java.util.ArrayList;

@Getter
@Setter
@ToString(callSuper = true)
public class AccountResource extends BaseResource {
    @NotNull(message = "Email cannot be null")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "The email format is not correct")
    private String email;

    @NotNull(message = "Password cannot be null")
    private String password;

    @NotNull(message = "Firstname cannot be null")
    private String firstname;

    @NotNull(message = "Lastname cannot be null")
    private String lastname;

    private Integer phoneNumber;

    private ArrayList<AddressResource> addresses;

    private AccountCategory accountCategory;
}
