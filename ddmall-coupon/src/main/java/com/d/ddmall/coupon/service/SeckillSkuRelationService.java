package com.d.ddmall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.d.common.utils.PageUtils;
import com.d.ddmall.coupon.entity.SeckillSkuRelationEntity;

import java.util.Map;

/**
 * 秒杀活动商品关联
 *
 * @author sudi
 * @email alvinsudi@163.com
 * @date 2020-10-29 20:47:26
 */
public interface SeckillSkuRelationService extends IService<SeckillSkuRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

