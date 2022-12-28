package com.sevensevengsi.laundry.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Store {
    @Id
    @GeneratedValue
    @Column(name = "Id", nullable = false)
    private Long Id;

    @Column(name = "Store_Name", length = 30, nullable = false)
    private String storeName;
}
