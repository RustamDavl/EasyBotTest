package com.rustdv.computermagazine.entity;

import com.rustdv.computermagazine.entity.embeddable.FormFactor;
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
public class Computer extends Goods {


    @Enumerated(EnumType.STRING)
    private FormFactor formFactor;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Computer computer = (Computer) o;
        return getId() != null && Objects.equals(getId(), computer.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.series, super.producer, super.price, super.amount);
    }
}
