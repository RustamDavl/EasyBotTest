package com.rustdv.computermagazine.facade;

import com.rustdv.computermagazine.dto.createupdate.CreateUpdateGoodsDto;
import com.rustdv.computermagazine.dto.read.ReadGoodsDto;

import java.util.List;

public interface GoodsServiceFacade <R extends ReadGoodsDto, C extends CreateUpdateGoodsDto> {

    R create(C goods);

    R edit(Long id, C goods);

    R findById(Long id);

    List<R> findAll();


}
