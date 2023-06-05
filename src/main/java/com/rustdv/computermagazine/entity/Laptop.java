package com.rustdv.computermagazine.entity;

import com.rustdv.computermagazine.entity.embeddable.LaptopSize;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SuperBuilder
@Entity
@Getter
@Setter
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class Laptop extends Goods {

    @Enumerated(EnumType.STRING)
    private LaptopSize laptopSize;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Laptop laptop = (Laptop) o;
        return id != null && Objects.equals(id, laptop.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.series, super.producer, super.price, super.amount);
    }
}
