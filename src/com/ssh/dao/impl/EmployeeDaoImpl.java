package com.ssh.dao.impl;

import com.ssh.dao.EmployeeDao;
import com.ssh.model.Employee;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import java.util.List;

/**
 * 员工管理的DAO的实现
 */
public class EmployeeDaoImpl extends HibernateDaoSupport implements EmployeeDao {


	@Override
	public Employee findByUsernameAndPassword(Employee employee) {
		System.out.print(1111);
		return null;
	}

	@Override
	public int findCount() {
		return 0;
	}

	@Override
	public List<Employee> findByPage(int begin, int pageSize) {
		return null;
	}

	@Override
	public void save(Employee employee) {

	}

	@Override
	public Employee findById(Integer eid) {
		return null;
	}

	@Override
	public void update(Employee employee) {

	}

	@Override
	public void delete(Employee employee) {

	}
}
