package com.stockManagement.store.service;

import com.stockManagement.store.dto.StoreDTO;
import com.stockManagement.store.mapper.StoreMapper;
import com.stockManagement.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static org.springframework.data.domain.Example.of;

@Slf4j
@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreMapper mapper;
    private final StoreRepository repository;

    public Page<StoreDTO> retrieve(StoreDTO dto, Pageable pageable) {
        log.info("m=retrieve, dto={}, pageable={}", dto, pageable);
        final var example = of(this.mapper.toEntity(dto));
        final var result = this.repository.findAll(example, pageable);
        return result.map(this.mapper::toDTO);
    }
}
