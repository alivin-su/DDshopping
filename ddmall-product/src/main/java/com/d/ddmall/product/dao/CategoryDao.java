package com.d.ddmall.product.dao;

import com.d.ddmall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-10-29 18:34:21
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
