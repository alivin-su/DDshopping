package com.d.ddmall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.d.common.utils.PageUtils;
import com.d.ddmall.product.entity.SpuCommentEntity;

import java.util.Map;

/**
 * 商品评价
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-10-29 18:34:21
 */
public interface SpuCommentService extends IService<SpuCommentEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

