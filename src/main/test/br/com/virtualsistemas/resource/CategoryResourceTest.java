package br.com.virtualsistemas.resource;

import br.com.virtualsistemas.model.Category;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by marcus on 17/02/18.
 */
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CategoryResourceTest {

    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    public void findByParent() throws Exception{
        ResponseEntity<Category> entity = restTemplate.getForEntity("/virtual-sistemas-api/category/parent/1sw", Category.class);
        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

}