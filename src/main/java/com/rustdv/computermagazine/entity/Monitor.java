package com.rustdv.computermagazine.entity;

import com.rustdv.computermagazine.entity.embeddable.Diagonal;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SuperBuilder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Monitor extends Goods {

    @Enumerated(EnumType.STRING)
    private Diagonal diagonal;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Monitor monitor = (Monitor) o;
        return id != null && Objects.equals(id, monitor.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.series, super.producer, super.price, super.amount);
    }
}
