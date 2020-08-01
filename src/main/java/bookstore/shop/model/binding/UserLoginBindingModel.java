package bookstore.shop.model.binding;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginBindingModel  {
    @Length(min = 2, message = "Username length must be more than two characters")
    private String username;
    @Length(min = 2, message = "Password length must be more than two characters")
    private String password;


}
