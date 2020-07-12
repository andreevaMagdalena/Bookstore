package  bookstore.shop.model.service;

import bookstore.shop.model.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserServiceModel extends BaseServiceModel {
    @NotNull
    private Role role;
    @Length(min = 3, message = "Username must be more than 2 symbols")
    private String username;
    @Length(min = 4, message = "Password must be more than 3 symbols")
    @NotNull(message = "Password is required")
    private String password;
    @Email(message = "Email is required")
    private String email;
    @NotNull(message = "Address is required")
    private String address;
    @NotNull(message = "Phone is required")
    private String phone;
}
