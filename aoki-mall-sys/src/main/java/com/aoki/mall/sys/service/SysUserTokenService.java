package com.aoki.mall.sys.service;

import com.aoki.mall.common.utils.R;
import com.aoki.mall.sys.entity.SysUserTokenEntity;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 用户Token
 *
 * @author Leo cao
 */
public interface SysUserTokenService extends IService<SysUserTokenEntity> {

	/**
	 * 生成token
	 * @param userId  用户ID
	 */
	R createToken(long userId);

	/**
	 * 退出，修改token值
	 * @param userId  用户ID
	 */
	void logout(long userId);

}
