package com.rustdv.computermagazine.dto.read;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ReadMonitorDto extends ReadGoodsDto {

    private String diagonal;
}
