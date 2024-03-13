package com.honey.Hnyeeb.serviceImp;

import com.honey.Hnyeeb.dto.VendorReport;
import com.honey.Hnyeeb.entity.Vendor;
import com.honey.Hnyeeb.repo.VendorRepository;
import com.honey.Hnyeeb.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class VendorServiceImp implements VendorService {
    @Autowired
    private VendorRepository vendorRepository;
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public Vendor addVendor(Vendor vendor) {
        return this.vendorRepository.save(vendor);
    }

    @Override
    public List<String> getVendor() {
        List<Vendor> vList = this.vendorRepository.findAll();
        List<String> vName = new ArrayList<>();
        for(Vendor v:vList ){
            vName.add(v.getVendorName());
        }
        return vName;
    }

    @Override
    public Vendor getVendorByName(String name) {
        String sql = "SELECT * FROM vendor where vendor_name = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{name}, new BeanPropertyRowMapper<>(Vendor.class));
    }

    @Override
    public List<VendorReport> getReportOfVendor(String name) {
        String sql = "Select product_name,product_sub_name," +
                "sum(total_kg) as total_kg,sum(total_price) as total_price  from purchase_master " +
                " where vendor=? group by product_name ,product_sub_name  ";
        List<VendorReport> vendorReport=  jdbcTemplate.query(sql, new Object[]{name}, new BeanPropertyRowMapper<>(VendorReport.class));
//        System.out.println(vendorReport);
        return vendorReport;


    }
}
