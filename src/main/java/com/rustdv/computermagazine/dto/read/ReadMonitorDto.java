package com.rustdv.computermagazine.dto.read;

import com.rustdv.computermagazine.entity.embeddable.Diagonal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ReadMonitorDto extends ReadGoodsDto {

    private String diagonal;
}
