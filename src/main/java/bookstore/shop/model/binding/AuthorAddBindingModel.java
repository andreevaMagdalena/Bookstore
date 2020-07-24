package bookstore.shop.model.binding;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthorAddBindingModel {

    private String firstName;

    private String lastName;

    private String about;

    private int birthYear;

    private String nationality;
}
