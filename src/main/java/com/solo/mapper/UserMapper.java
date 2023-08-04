package com.solo.mapper;

import com.core.annotation.SMC;
import com.core.collection.SList;
import com.core.collection.Solo;
import com.core.exception.business.SException;
import com.ibatis.MybatisSMC;

@SMC
public class UserMapper extends MybatisSMC {
	
	private final String NAMESPACE = UserMapper.class.getName();
	
	public SList findAllUser(Solo params) throws SException {
		return selectList(NAMESPACE, "findAllUser", params);
	}

	public SList findAllUserPage(Solo params) throws SException {
		return selectPage(NAMESPACE, "findAllUserPage", params);
	}
	
	public Solo findUserById(Solo params) throws SException {
		return selectOne(NAMESPACE, "findUserById", params);
	}
	
	public long saveUser(Solo params) throws SException {
		return insert(NAMESPACE, "saveUser", params);
	}
	
	public long updateUser(Solo params) throws SException {
		return update(NAMESPACE, "updateUser", params);
	}
	
	public long deleteUser(Solo params) throws SException {
		return delete(NAMESPACE, "deleteUser", params);
	}

}
