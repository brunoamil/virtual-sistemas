package br.com.virtualsistemas;

import br.com.virtualsistemas.facade.Facade;
import br.com.virtualsistemas.facade.IFacade;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Created by markiing on 16/02/18.
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public IFacade facade(){
        return new Facade();
    }

}
