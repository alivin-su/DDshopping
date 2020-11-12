package com.d.ddmall.order.dao;

import com.d.ddmall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author sudi
 * @email alvinsudi@163.com
 * @date 2020-10-29 21:05:19
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
