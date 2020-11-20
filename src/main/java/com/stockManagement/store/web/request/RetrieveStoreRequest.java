package com.stockManagement.store.web.request;

import lombok.Data;

@Data
public class RetrieveStoreRequest {

    private Long idStore;

    private String nameStore;
}
