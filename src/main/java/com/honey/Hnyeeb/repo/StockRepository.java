package com.honey.Hnyeeb.repo;

import com.honey.Hnyeeb.entity.StockBox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<StockBox,Long> {
}
