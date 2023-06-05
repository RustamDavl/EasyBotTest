package com.rustdv.computermagazine.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@ToString
@MappedSuperclass
public abstract class Goods {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(name = "series", nullable = false)
    protected String series;
    @Column(nullable = false)
    protected String producer;
    @Column(nullable = false)
    protected BigDecimal price;
    @Column(nullable = false)
    protected Integer amount;
}
