package com.honey.Hnyeeb.serviceImp;

import com.honey.Hnyeeb.entity.Sales;
import com.honey.Hnyeeb.entity.StockBox;
import com.honey.Hnyeeb.repo.SalesRepository;
import com.honey.Hnyeeb.repo.StockRepository;
import com.honey.Hnyeeb.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class SalesServiceImp implements SalesService {

    @Autowired
    SalesRepository salesRepository;
    @Autowired
    StockRepository stockRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public List<String> fetchProducName() {
        List<StockBox> stockBoxes = stockRepository.findAll();
        List<String> productList = new ArrayList<>();
        for(StockBox s :stockBoxes){
            productList.add(s.getProductName());
        }
        return productList;
    }

    @Override
    public List<String> fetchSubProducName(String productName) {
        String sql = "SELECT product_sub_name FROM stock_box where product_name = ?";
        return jdbcTemplate.queryForList(sql, String.class,productName);
    }

    @Override
    public List<String> fetchTotalKg(String productName, String productSubName) {
        String sql = "SELECT total_kg FROM stock_box where product_name = ? and product_sub_name = ?" ;
        return jdbcTemplate.queryForList(sql, String.class,productName,productSubName);
    }

    @Override
    public void addSales(List<Sales> salesList) {
        for (Sales s : salesList) {
            String sql = "select * from stock_box where product_name=? and product_sub_name=? ";
            List<StockBox> resultList = jdbcTemplate.query(sql, new Object[]{s.getProductName(), s.getProductSubName()}, new BeanPropertyRowMapper<>(StockBox.class));
            for (StockBox stockBox : resultList) {
                String tempId = String.valueOf(stockBox.getId());
                String currentKg = String.valueOf(stockBox.getTotalKg());
                int balanceKg = Integer.parseInt(currentKg) - Integer.parseInt(s.getTotalKg());
                System.out.println(balanceKg);
                String updateSql = "UPDATE hnyeeb_master.stock_box SET total_kg = ? WHERE id= ?";
                int rowsAffected = jdbcTemplate.update(updateSql, balanceKg, tempId);
            }
        }

        salesRepository.saveAll(salesList);
    }

}
