package com.honey.Hnyeeb.controller;


import com.honey.Hnyeeb.dto.VendorReport;
import com.honey.Hnyeeb.entity.Vendor;
import com.honey.Hnyeeb.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/vendor")
@CrossOrigin
public class VendorController {
    @Autowired
    private VendorService vendorService;

    @PostMapping("/add")
    public Vendor addVendor(@RequestBody Vendor vendor){
        return   this.vendorService.addVendor(vendor);
    }

    @GetMapping("/getdetail")
    public Vendor vendor(@RequestParam("Name")  String name){
        return this.vendorService.getVendorByName(name);
    }


    @GetMapping("/getnames")
    public List<String> getVendorName(){
        return this.vendorService.getVendor();
    }

    @GetMapping("/getreport")
    public List<VendorReport> getVendorName(@RequestParam("Name")  String name){
        return this.vendorService.getReportOfVendor(name);
    }



}
