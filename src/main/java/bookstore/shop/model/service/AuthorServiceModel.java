package bookstore.shop.model.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
@Getter
@Setter
@NoArgsConstructor
public class AuthorServiceModel {
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(columnDefinition = "TEXT")
    private String about;
    @Column
    private int birthYear;
    @Column
    private String nationality;
}
