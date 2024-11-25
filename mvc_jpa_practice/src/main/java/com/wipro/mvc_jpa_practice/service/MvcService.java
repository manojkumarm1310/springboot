package com.wipro.mvc_jpa_practice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.mvc_jpa_practice.dao.MvcDao;
import com.wipro.mvc_jpa_practice.model.Users;

@Service
public class MvcService {
	@Autowired
	private MvcDao mvcDao;

	public Users getUserById(Integer id) {
		// TODO Auto-generated method stub
		System.out.println(id);
		return mvcDao.getUsersById(id);
	}

	public String addUsers(Users user) {
		System.out.println(user);
		mvcDao.save(user);
		return "added";
	}

	public List<Users> getList() {
		// TODO Auto-generated method stub
		return mvcDao.findAll();
	}
	
	
	
}
