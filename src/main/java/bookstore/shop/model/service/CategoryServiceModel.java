package bookstore.shop.model.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryServiceModel {
    @NotNull(message = "Category name is required")
    @Length(min = 3, max = 20, message = "Name length must be between 3 and 20 characters (inclusive 3 and 20)")
    private String categoryName;
    @Length(min = 5, message = "Description min length must be minimum 5(inclusive) characters")
    private String description;
}
