package com.honey.Hnyeeb.service;

import com.honey.Hnyeeb.dto.VendorReport;
import com.honey.Hnyeeb.entity.Vendor;

import java.util.List;

public interface VendorService {

    Vendor addVendor(Vendor vendor);

    List<String> getVendor();

    Vendor getVendorByName(String name);
    List<VendorReport> getReportOfVendor(String name);
}
