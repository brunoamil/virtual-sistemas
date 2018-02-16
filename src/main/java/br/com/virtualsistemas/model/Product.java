package br.com.virtualsistemas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by markiing on 16/02/18.
 */

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_product")
public @Data class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private String name;

    @ManyToOne
    private Category category;
}
