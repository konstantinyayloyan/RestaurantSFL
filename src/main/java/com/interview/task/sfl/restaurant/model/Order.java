package com.interview.task.sfl.restaurant.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.interview.task.sfl.restaurant.model.enums.OrderStatus;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    Long id;

    @ManyToOne
    @JoinColumn(name = "table_id")
    @JsonManagedReference
    RestaurantTable restourantTable;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    OrderStatus status;

    @OneToMany(mappedBy = "order")
    Set<ProductInOrder> productInOrders = new HashSet<>();

}
