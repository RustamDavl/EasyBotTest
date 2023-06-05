package com.rustdv.computermagazine.dto.createupdate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public abstract class CreateUpdateGoodsDto {

    protected String series;
    protected String producer;
    protected BigDecimal price;
    protected Integer amount;

}
