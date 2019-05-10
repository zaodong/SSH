package com.ssh.dao.impl;

import com.ssh.dao.DepartmentDao;
import com.ssh.model.Department;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import java.util.List;

/*
 * 部门管理DAO层的实现类
 */
public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao {

	@Override
	public int findCount() {
		return 0;
	}

	@Override
	public List<Department> findByPage(int begin, int pageSize) {
		return null;
	}

	@Override
	public void save(Department department) {

	}

	@Override
	public Department findById(Integer did) {
		return null;
	}

	@Override
	public void update(Department department) {

	}

	@Override
	public void delete(Department department) {

	}

	@Override
	public List<Department> findAll() {
		return null;
	}
}
