package com.d.ddmall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.d.common.utils.PageUtils;
import com.d.ddmall.member.entity.MemberCollectSpuEntity;

import java.util.Map;

/**
 * 会员收藏的商品
 *
 * @author sudi
 * @email alvinsudi@163.com
 * @date 2020-10-29 20:57:16
 */
public interface MemberCollectSpuService extends IService<MemberCollectSpuEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

