package com.aoki.mall.sys.repository;

import com.aoki.mall.sys.entity.SysCaptchaEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 验证码
 *
 * @author Leo
 */
@Mapper
public interface SysCaptchaDao extends BaseMapper<SysCaptchaEntity> {

}
