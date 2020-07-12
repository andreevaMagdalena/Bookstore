package bookstore.shop.model.binding;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterBindingModel {
    @Length(min = 2, message = "Username length must be more than two characters")
    private String username;
    @Email
    private String email;
    @Length(min = 2, message = "Username length must be more than two characters")
    private String password;
    @Length(min = 2, message = "Username length must be more than two characters")
    private String confirmPassword;
    @NotNull(message = "Address is required")
    private String address;
    @NotNull(message = "Phone is required")
    private String phone;


}
