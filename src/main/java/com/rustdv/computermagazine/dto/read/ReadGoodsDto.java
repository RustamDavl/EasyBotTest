package com.rustdv.computermagazine.dto.read;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public abstract class ReadGoodsDto {

    protected String id;
    protected String series;
    protected String price;
    protected String amount;
    protected String producer;
}
