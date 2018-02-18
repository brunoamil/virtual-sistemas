package br.com.virtualsistemas.resource;

import br.com.virtualsistemas.model.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

/**
 * Created by marcus on 17/02/18.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductResourceTest {

    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    public void findByCode() throws Exception {
        ResponseEntity<Category> entity = restTemplate.getForEntity("/virtual-sistemas-api/product/1sw", Category.class);
        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }


}