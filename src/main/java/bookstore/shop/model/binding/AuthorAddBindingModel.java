package bookstore.shop.model.binding;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthorAddBindingModel {
    @Length(min = 3, max = 20, message = "First name length must be between 3 and 20 characters (inclusive 3 and 20)")
    private String firstName;
    @Length(min = 3, max = 20, message = "Last name length must be between 3 and 20 characters (inclusive 3 and 20)")
    private String lastName;
    @NotNull(message = "This field is required")
    private String about;
    @Min(value = 0, message = "Years must be positive value")
    private int birthYear;
    @NotNull(message = "This field is required")
    private String nationality;
}
