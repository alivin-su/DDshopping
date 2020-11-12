package com.d.ddmall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.d.common.utils.PageUtils;
import com.d.ddmall.member.entity.MemberEntity;

import java.util.Map;

/**
 * 会员
 *
 * @author sudi
 * @email alvinsudi@163.com
 * @date 2020-10-29 20:57:16
 */
public interface MemberService extends IService<MemberEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

