package com.interview.task.sfl.restaurant.repository;

import com.interview.task.sfl.restaurant.model.RestaurantTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantTableRepository extends JpaRepository<RestaurantTable, Long> {

    @Query("SELECT r FROM RestaurantTable r WHERE r.user.id=?1")
    List<RestaurantTable> findByUserId(Long id);
}
