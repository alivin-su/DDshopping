package com.d.ddmall.product;

import com.d.ddmall.product.entity.BrandEntity;
import com.d.ddmall.product.service.BrandService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


//第一步引入对象存储的额starter
//第二部配置key和endpoint等配置信息
//第三步使用ossClient进行相关操作
@SpringBootTest
class DdmallProductApplicationTests {


    @Autowired
    BrandService brandService;

    @Test
    void contextLoads() {
        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setName("华为");
        brandService.save(brandEntity);
        System.out.println("保存成功");
        System.out.println(brandService.getById(1));
    }

}
