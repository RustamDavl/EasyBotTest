package com.rustdv.computermagazine.dto.read;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ReadComputerDto extends ReadGoodsDto {

    private String formFactor;
}
