package com.honey.Hnyeeb.service;

import com.honey.Hnyeeb.entity.Sales;

import java.util.List;

public interface SalesService {
    public List<String> fetchProducName();
    public List<String> fetchSubProducName(String productName);

    public  List<String> fetchTotalKg(String productName, String productSubName);

    public  void addSales(List<Sales> salesList);
}
