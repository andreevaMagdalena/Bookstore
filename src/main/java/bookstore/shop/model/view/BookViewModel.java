package bookstore.shop.model.view;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookViewModel {

    private String id;
    private String title;
    private String imgUrl;
    private String description;
    private BigDecimal price;

}
