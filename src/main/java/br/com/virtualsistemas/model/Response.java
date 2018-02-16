package br.com.virtualsistemas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.http.HttpStatus;

/**
 * Created by markiing on 16/02/18.
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
public @Data class Response {

    private HttpStatus status;
    private String message;
}
