package com.solo.controller;

import com.core.util.validation.SValidatorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import com.core.annotation.SCC;
import com.core.annotation.SOP;
import com.core.collection.SList;
import com.core.collection.Solo;
import com.core.exception.business.SException;
import com.solo.mapper.UserMapper;

@SCC
public class UserController {
	
	@Autowired
	private UserMapper userMapper;

	@SOP("USER01") //Find All
	public Solo findAllUser(@RequestBody Solo params) throws SException {
		SValidatorUtil.validate(params, "pageSize", "pageNumber", "pagesToShow");
		Solo result = new Solo();
		SList list = new SList();
		list = userMapper.findAllUserPage(params);
		int listSize = userMapper.findAllUser(params).size();
		Solo page = params.setPage(params, listSize);
		if(!list.isEmpty()) {
			result.set("list", list);
			result.set("page", page);
		}else {
			result.set("list", "List not found !");
			result.set("page", page);
		}
		return result;
	}
	
	@SOP("USER02") //Find Object
	public Solo findUserById(@RequestBody Solo params) throws Exception {
		Solo result = new Solo();
		Solo obj = new Solo();
		try {
			obj = userMapper.findUserById(params);
		} catch (Exception e) {
			throw new Exception("result not found !");
		}
		result.set("result", obj);						
		return obj;
	}
	
	@SOP("USER03") //Save
	public Solo saveUser(@RequestBody Solo params) throws SException {
		Solo result = new Solo();
		long save = userMapper.saveUser(params);
		if(save == 1) {
			result.set("result", "Save Successfully !");						
		}else {
			result.set("result", "Save failed");						
		}
		return result;
	}
	
	@SOP("USER04") //Update
	public Solo updateUser(@RequestBody Solo params) throws SException {
		Solo result = new Solo();
		long update = userMapper.updateUser(params);
		if(update == 1) {
			result.set("result", "Update Successfully !");						
		}else {
			result.set("result", "Update failed !");						
		}
		return result;
	}
	
	@SOP("USER05") //Delete
	public Solo deleteUser(@RequestBody Solo params) throws SException {
		Solo result = new Solo();
		long delete = userMapper.deleteUser(params);
		if(delete == 1) {
			result.set("result", "Delete Successfully !");						
		}else {
			result.set("result", "Delete failed !");						
		}
		return result;
	}

}
