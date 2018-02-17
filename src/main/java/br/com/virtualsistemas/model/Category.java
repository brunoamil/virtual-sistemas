package br.com.virtualsistemas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by markiing on 16/02/18.
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "tbl_category")
public @Data class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column(unique = true)
    private String name;

    @ManyToOne
    private Category categoryParent;
}
