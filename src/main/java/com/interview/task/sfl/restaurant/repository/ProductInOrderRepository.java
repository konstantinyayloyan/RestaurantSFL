package com.interview.task.sfl.restaurant.repository;

import com.interview.task.sfl.restaurant.model.ProductInOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductInOrderRepository extends JpaRepository<ProductInOrder, Long> {


}
