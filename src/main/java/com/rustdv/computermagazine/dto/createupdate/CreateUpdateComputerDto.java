package com.rustdv.computermagazine.dto.createupdate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CreateUpdateComputerDto extends CreateUpdateGoodsDto {

    String formFactor;

}
