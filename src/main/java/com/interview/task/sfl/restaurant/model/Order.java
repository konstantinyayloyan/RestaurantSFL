package com.interview.task.sfl.restaurant.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.interview.task.sfl.restaurant.model.enums.OrderStatus;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "table_id")
    @JsonManagedReference
    private RestaurantTable restaurantTable;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @OneToMany(mappedBy = "order")
    private Set<ProductInOrder> productInOrders = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RestaurantTable getRestaurantTable() {
        return restaurantTable;
    }

    public void setRestaurantTable(RestaurantTable restaurantTable) {
        this.restaurantTable = restaurantTable;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Set<ProductInOrder> getProductInOrders() {
        return productInOrders;
    }

    public void setProductInOrders(Set<ProductInOrder> productInOrders) {
        this.productInOrders = productInOrders;
    }
}
