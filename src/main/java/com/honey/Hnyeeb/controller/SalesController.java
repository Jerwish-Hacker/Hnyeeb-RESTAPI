package com.honey.Hnyeeb.controller;


import com.honey.Hnyeeb.entity.Sales;
import com.honey.Hnyeeb.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/sales")
@CrossOrigin
public class SalesController {


    @Autowired
    SalesService salesService;


    @GetMapping("getproductname")
    public List<String> productName(){
        return salesService.fetchProducName();
    }

    @GetMapping("getsubproductname")
    public List<String> producSubtName(@RequestParam("productname") String productname){
        return salesService.fetchSubProducName(productname);
    }
    @GetMapping("gettotalkg")
    public List<String> fetchTotalKg(@RequestParam("productname") String productname ,@RequestParam("productsubname") String subproductname ){
        return salesService.fetchTotalKg(productname,subproductname);
    }
    @PostMapping("addsales")
    public List<String> addSales(@RequestBody List<Sales> salesList){
        salesService.addSales(salesList);
        return null;
    }


}
