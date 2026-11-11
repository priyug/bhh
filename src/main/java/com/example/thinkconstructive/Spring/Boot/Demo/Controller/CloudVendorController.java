package com.example.thinkconstructive.Spring.Boot.Demo.Controller;

import com.example.thinkconstructive.Spring.Boot.Demo.Model.CloudVendor;
import com.example.thinkconstructive.Spring.Boot.Demo.Service.CloudVendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cloudVendor")
public class CloudVendorController {

    @Autowired
    CloudVendorService cloudVendorService;

    public CloudVendorController(CloudVendorService cloudVendorService) {
        this.cloudVendorService = cloudVendorService;
    }

    @GetMapping("{vendorId}")
    public CloudVendor getCloudVendorDetails(@PathVariable("vendorId") String vendorId){
      return cloudVendorService.getCloudVendorDetails(vendorId);
    }


    @GetMapping
    public List<CloudVendor> getAllCloudVendorDetails(){
        return cloudVendorService.getAllCloudVendorDetails();
    }



    @GetMapping("/page")
    public Page<CloudVendor> getAllPageCloudVendor(@RequestParam(defaultValue ="0")int page,@RequestParam(defaultValue = "1")int size){
        return  cloudVendorService.getPageCloudVendorDetails(page,size);
    }
  @PutMapping
  public String updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor){
        cloudVendorService.updateCloudVendorDetails(cloudVendor);
        return "CloudVendor Details update successfully";
    }

    @PatchMapping(("{vendorId}"))
    public String updateCloudVendorDetails(@PathVariable ("vendorId") String vendorId ,@RequestBody CloudVendor cloudVendor){
        return cloudVendorService.updateCloudVendorDetails(vendorId,cloudVendor);
    }

    @PostMapping
    public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor){
        cloudVendorService.createCloudVendorDetails(cloudVendor);
        return "CloudVendor Details create successfully";
    }

     @DeleteMapping("{vendorId}")
    public  String deleteCloudVendorDetails(@PathVariable("vendorId") String vendorId){
        cloudVendorService.deleteCloudVendorDetails(vendorId);
        return "CloudVendor Details Delete Successfully";


}

}
