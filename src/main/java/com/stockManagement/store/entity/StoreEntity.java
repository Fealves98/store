package com.stockManagement.store.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "store")
public class StoreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_store")
    private long idStore;

    @Column(name = "name_store")
    private String nameStore;
}
