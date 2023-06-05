package com.rustdv.computermagazine.entity;

import com.rustdv.computermagazine.entity.embeddable.HardDiskVolume;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.Hibernate;
import javax.persistence.*;
import java.util.Objects;

@SuperBuilder
@Getter
@Setter
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class HardDiskDrive extends Goods {

    @Enumerated(EnumType.STRING)
    private HardDiskVolume hardDiskVolume;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        HardDiskDrive that = (HardDiskDrive) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.series, super.producer, super.price, super.amount);
    }
}
