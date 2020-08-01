package bookstore.shop.model.binding;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PublisherAddBindingModel {
    @Length(min = 3, max = 20, message = "Name length must be between 3 and 20 characters (inclusive 3 and 20)")
    private String companyName;
    @Length(min = 3, max = 40, message = "Country length must be between 3 and 40 characters (inclusive 3 and 40)")
    private String country;
    @Length(min = 3, message = "Address length must be at least 3 characters")
    private String address;
}
