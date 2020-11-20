package com.stockManagement.store.mapper;

import com.stockManagement.store.dto.StoreDTO;
import com.stockManagement.store.entity.StoreEntity;
import com.stockManagement.store.web.request.RetrieveStoreRequest;
import com.stockManagement.store.web.response.RetrieveStoreResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StoreMapper {

    StoreMapper mapper = Mappers.getMapper(StoreMapper.class);

    StoreDTO toDTO(final RetrieveStoreRequest filter);
    
    StoreDTO toDTO(final StoreEntity entity);

    StoreEntity toEntity(final StoreDTO dto);

    RetrieveStoreResponse toResponse(StoreDTO storeDTO);
}
