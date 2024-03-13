package com.honey.Hnyeeb.serviceImp;

import com.honey.Hnyeeb.entity.Purchase;
import com.honey.Hnyeeb.entity.StockBox;
import com.honey.Hnyeeb.repo.PurchaseRepository;
import com.honey.Hnyeeb.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseServiceImp implements PurchaseService {

    @Autowired
   private JdbcTemplate jdbcTemplate;
    @Autowired
    PurchaseRepository purchaseRepository;
    @Override
    public List<Purchase> addPurchase(List<Purchase> purchases) {
        for (Purchase p : purchases) {
            String sql = "select * from hnyeeb_master.stock_box where product_name=? and product_sub_name=? and types =? ";
            List<StockBox> resultList = jdbcTemplate.query(sql,new Object[] {p.getProductName(),p.getProductSubName(),p.getTypes()},new BeanPropertyRowMapper<>(StockBox.class));
            if(!resultList.isEmpty()) {
                for (StockBox stockBox : resultList) {
                    String tempId = String.valueOf(stockBox.getId());
                    String currentKg = String.valueOf(stockBox.getTotalKg());
                    int addQuantity= Integer.parseInt(p.getTotalKg())+Integer.parseInt(currentKg);
                    String updateSql = "UPDATE hnyeeb_master.stock_box SET total_kg = ? WHERE id= ?";
                    int rowsAffected = jdbcTemplate.update(updateSql,addQuantity, tempId);
                    System.out.println(rowsAffected);
                }


                }
            else {
                String insertSql = "INSERT INTO hnyeeb_master.stock_box (`product_name`, `product_sub_name`, `types`,`total_kg`) VALUES (?, ?, ?, ?); ";
                int rowsAffected = jdbcTemplate.update(insertSql,p.getProductName(),p.getProductSubName(),p.getTypes(),p.getTotalKg());
                System.out.println(rowsAffected);
            }
            }


        return this.purchaseRepository.saveAll(purchases);
    }
}
