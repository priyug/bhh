package com.example.thinkconstructive.Spring.Boot.Demo.Service;

import com.example.thinkconstructive.Spring.Boot.Demo.Exception.CloudVendorException;
import com.example.thinkconstructive.Spring.Boot.Demo.Exception.CloudVendorNotFoundException;
import com.example.thinkconstructive.Spring.Boot.Demo.Model.CloudVendor;
import com.example.thinkconstructive.Spring.Boot.Demo.Repository.CloudVendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CloudVendorServiceImpl implements CloudVendorService {


    @Autowired
    CloudVendorRepository cloudVendorRepository;


    public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository) {
        this.cloudVendorRepository = cloudVendorRepository;
    }

    @Override
    public String createCloudVendorDetails(CloudVendor cloudVendor) {
        cloudVendorRepository.save(cloudVendor);
        return "Create Successfully";
    }

    @Override
    public String updateCloudVendorDetails(CloudVendor cloudVendor) {
        cloudVendorRepository.save(cloudVendor);
        return "Update Successfully";
    }

    @Override
    public String updateCloudVendorDetails(String vendorId,CloudVendor cloudVendor) {
       CloudVendor finalVendor = cloudVendorRepository.findById(vendorId) .orElseThrow(() -> new RuntimeException("Vendor not found"));
        if(cloudVendor.getVendorName()!= null){
               finalVendor.setVendorName(cloudVendor.getVendorName());
        }
        if(cloudVendor.getVendorAddress()!=null){
            finalVendor.setVendorAddress(cloudVendor.getVendorAddress());
        }
        cloudVendorRepository.save(finalVendor);
        return "Update specific data Successfully";
    }

    @Override
    public String deleteCloudVendorDetails(String vendorId) {
        cloudVendorRepository.deleteById(vendorId);
        return "Delete Successfully";
    }

    @Override
    public CloudVendor getCloudVendorDetails(String vendorId) {
        if(cloudVendorRepository.findById(vendorId).isEmpty()) throw new CloudVendorException("Requested vendor is not found");
       return cloudVendorRepository.findById(vendorId).get();

    }

    @Override
    public List<CloudVendor> getAllCloudVendorDetails() {
        return cloudVendorRepository.findAll();
    }

    @Override
   public  Page<CloudVendor> getPageCloudVendorDetails(int page, int size){
        Pageable pageable = PageRequest.of(page,size);
        return cloudVendorRepository.findAll(pageable);
    }
}
