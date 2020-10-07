package com.aoki.mall.sys.service.impl;

import com.aoki.mall.sys.entity.SysUserEntity;
import com.aoki.mall.sys.repository.SysUserDao;
import com.aoki.mall.sys.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;


/**
 * 系统用户
 *
 * @author Leo cao
 */
@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUserEntity> implements SysUserService {
//	@Autowired
//	private SysUserRoleService sysUserRoleService;
//	@Autowired
//	private SysRoleService sysRoleService;

//	@Override
//	public PageUtils queryPage(Map<String, Object> params) {
//		String username = (String)params.get("username");
//		Long createUserId = (Long)params.get("createUserId");
//
//		IPage<SysUserEntity> page = this.page(
//			new Query<SysUserEntity>().getPage(params),
//			new QueryWrapper<SysUserEntity>()
//				.like(StringUtils.isNotBlank(username),"username", username)
//				.eq(createUserId != null,"create_user_id", createUserId)
//		);
//
//		return new PageUtils(page);
//	}
//
//	@Override
//	public List<String> queryAllPerms(Long userId) {
//		return baseMapper.queryAllPerms(userId);
//	}
//
//	@Override
//	public List<Long> queryAllMenuId(Long userId) {
//		return baseMapper.queryAllMenuId(userId);
//	}

	@Override
	public SysUserEntity queryByUserName(String username) {
		return baseMapper.queryByUserName(username);
	}

//	@Override
//	@Transactional
//	public void saveUser(SysUserEntity user) {
//		user.setCreateTime(new Date());
//		//sha256加密
//		String salt = RandomStringUtils.randomAlphanumeric(20);
//		user.setPassword(new Sha256Hash(user.getPassword(), salt).toHex());
//		user.setSalt(salt);
//		this.save(user);
//
//		//检查角色是否越权
//		checkRole(user);
//
//		//保存用户与角色关系
//		sysUserRoleService.saveOrUpdate(user.getUserId(), user.getRoleIdList());
//	}
//
//	@Override
//	@Transactional
//	public void update(SysUserEntity user) {
//		if(StringUtils.isBlank(user.getPassword())){
//			user.setPassword(null);
//		}else{
//			user.setPassword(new Sha256Hash(user.getPassword(), user.getSalt()).toHex());
//		}
//		this.updateById(user);
//
//		//检查角色是否越权
//		checkRole(user);
//
//		//保存用户与角色关系
//		sysUserRoleService.saveOrUpdate(user.getUserId(), user.getRoleIdList());
//	}
//
//	@Override
//	public void deleteBatch(Long[] userId) {
//		this.removeByIds(Arrays.asList(userId));
//	}
//
//	@Override
//	public boolean updatePassword(Long userId, String password, String newPassword) {
//		SysUserEntity userEntity = new SysUserEntity();
//		userEntity.setPassword(newPassword);
//		return this.update(userEntity,
//				new QueryWrapper<SysUserEntity>().eq("user_id", userId).eq("password", password));
//	}
	
	/**
	 * 检查角色是否越权
	 */
//	private void checkRole(SysUserEntity user){
//		if(user.getRoleIdList() == null || user.getRoleIdList().size() == 0){
//			return;
//		}
//		//如果不是超级管理员，则需要判断用户的角色是否自己创建
//		if(user.getCreateUserId() == Constant.SUPER_ADMIN){
//			return ;
//		}
//
//		//查询用户创建的角色列表
//		List<Long> roleIdList = sysRoleService.queryRoleIdList(user.getCreateUserId());
//
//		//判断是否越权
//		if(!roleIdList.containsAll(user.getRoleIdList())){
//			throw new RRException("新增用户所选角色，不是本人创建");
//		}
//	}
}