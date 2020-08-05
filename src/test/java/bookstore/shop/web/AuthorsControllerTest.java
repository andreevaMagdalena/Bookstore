package bookstore.shop.web;

import bookstore.shop.model.entity.Author;
import bookstore.shop.repository.AuthorRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthorsControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AuthorRepository authorRepository;

    private String TEST_AUTHOR1_ID, TEST_AUTHOR2_ID;
    private String TEST_AUTHOR1_NAME = "Pesho", TEST_AUTHOR2_NAME = "Ivan";

    @BeforeEach
    public void setUp(){
        Author author = new Author();
        author.setFirstName(TEST_AUTHOR1_NAME);
        author = authorRepository.save(author);
        TEST_AUTHOR1_ID = author.getId();


        Author author1 = new Author();
        author1.setFirstName(TEST_AUTHOR2_NAME);
        author1 = authorRepository.save(author1);
        TEST_AUTHOR2_ID = author1.getId();

    }
    @AfterEach
    public void tearDown(){
        authorRepository.deleteAll();
    }

    @Test
    public void testAuthorsReturnCorrectStatusCode() throws Exception {
        this.mockMvc.perform(get("/authors")).andExpect(status().isOk());
    }

}
