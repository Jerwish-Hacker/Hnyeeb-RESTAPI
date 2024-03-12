package com.honey.Hnyeeb.serviceImp;

import com.honey.Hnyeeb.entity.Purchase;
import com.honey.Hnyeeb.repo.PurchaseRepository;
import com.honey.Hnyeeb.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseServiceImp implements PurchaseService {


    @Autowired
    PurchaseRepository purchaseRepository;
    @Override
    public List<Purchase> addPurchase(List<Purchase> purchases) {
        return this.purchaseRepository.saveAll(purchases);
    }
}
