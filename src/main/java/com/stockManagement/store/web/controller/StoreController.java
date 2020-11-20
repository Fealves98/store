package com.stockManagement.store.web.controller;

import com.stockManagement.store.mapper.StoreMapper;
import com.stockManagement.store.service.StoreService;
import com.stockManagement.store.web.request.RetrieveStoreRequest;
import com.stockManagement.store.web.response.RetrieveStoreResponse;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/store")
public class StoreController {

    private final StoreMapper mapper;
    private final StoreService service;

    @GetMapping
    @ApiOperation("Consulta Loja")
    public Page<RetrieveStoreResponse> retrieveAll(final RetrieveStoreRequest filter, @PageableDefault Pageable pageable){
        log.info("m=retrieveAll, filter={}, pageable={}", filter, pageable);
        final var store = this.mapper.toDTO(filter);
        final var result = this.service.retrieve(store, pageable);
        return result.map(this.mapper::toResponse);
    }
}
