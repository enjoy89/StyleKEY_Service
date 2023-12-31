package com.thekey.stylekey.backend.service.admin;

import com.thekey.stylekey.backend.model.brand.entity.Brand;
import com.thekey.stylekey.backend.model.item.entity.Item;
import com.thekey.stylekey.backend.service.admin.dto.CreateBrandRequestDto;
import com.thekey.stylekey.backend.service.admin.dto.UpdateBrandRequestDto;

import java.util.List;

public interface BrandAdminService {

    // create
    Brand createBrand(CreateBrandRequestDto requestDto);

    // read only one
    Brand findById(Long id);

    // read all
    List<Brand> findAll();

    // update
    Brand updateBrand(Long id, UpdateBrandRequestDto requestDto);

    // delete
    void deleteBrand(Long id);

    List<Item> getItemsByBrandId(Long brandId);

}
