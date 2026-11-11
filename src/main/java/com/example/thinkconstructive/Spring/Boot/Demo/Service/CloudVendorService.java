package com.example.thinkconstructive.Spring.Boot.Demo.Service;

import com.example.thinkconstructive.Spring.Boot.Demo.Model.CloudVendor;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CloudVendorService {

    public String createCloudVendorDetails(CloudVendor cloudVendor);
    public String updateCloudVendorDetails(CloudVendor cloudVendor);
    public String updateCloudVendorDetails(String vendorId,CloudVendor cloudVendor);
    public String deleteCloudVendorDetails(String vendorId);
    public CloudVendor getCloudVendorDetails(String vendorId);
    public List<CloudVendor> getAllCloudVendorDetails();
    Page<CloudVendor> getPageCloudVendorDetails(int page, int size);
}
