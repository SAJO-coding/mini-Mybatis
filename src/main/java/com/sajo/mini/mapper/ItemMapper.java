package com.sajo.mini.mapper;

import com.sajo.mini.model.dto.ItemDTO;

import java.util.List;

public interface ItemMapper {
    List<ItemDTO> selectAllItem();

    int insertItem(ItemDTO itemDTO);

    int productDelete(String itemName);
}
