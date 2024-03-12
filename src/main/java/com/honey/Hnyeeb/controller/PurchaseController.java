package com.honey.Hnyeeb.controller;


import com.honey.Hnyeeb.entity.Purchase;
import com.honey.Hnyeeb.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.ListUI;
import java.util.List;

@RestController
@RequestMapping("api/v1/purchase")
@CrossOrigin
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @PostMapping("/add")
    public List<Purchase> addPurchase(@RequestBody List<Purchase> purchases){
        return purchaseService.addPurchase(purchases);
    }

}
