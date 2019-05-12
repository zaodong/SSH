package com.ssh.dao.impl;

import com.ssh.dao.EmployeeDao;
import com.ssh.model.Employee;
import com.ssh.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import java.util.List;

/**
 * 员工管理的DAO的实现
 */
public class EmployeeDaoImpl implements EmployeeDao {

	private HibernateUtil hibernateUtil;
	private Session session;

	public void setHibernateUtil(HibernateUtil hibernateUtil) {
		this.hibernateUtil = hibernateUtil;
	}
	@Override
	public Employee findByUsernameAndPassword(Employee employee) {
		System.out.print(1111);
		String hql = "from Employee where username=? and password=?";
		session = hibernateUtil.getSession();
		Query query = session.createQuery(hql);
		//
		query.setParameter(0, employee.getUsername());
		query.setParameter(1, employee.getPassword());
		List<Employee> lists = query.list();
		if(lists.size() > 0) {
			return lists.get(0);
		}
		return null;
	}

	@Override
	public int findCount() {

		String hql = "select count(*) from Employee";
		session = hibernateUtil.getSession();
		Query query = session.createQuery(hql);
		int count = ((Long) query.setCacheable(true).uniqueResult()).intValue();
		if(count > 0 ) {
			//System.out.println(count);
			return count;
		}
		hibernateUtil.closeSession(session);
		return 0;
	}

	@Override
	//分页查询员工
	public List<Employee> findByPage(int begin, int pageSize) {

		String hql = "from Employee";
		session = hibernateUtil.getSession();
		Query query = session.createQuery(hql);
		//������λ�ð󶨲�ѯ����
		System.out.println(begin);
		System.out.println(pageSize);
		query.setFirstResult(begin);
		query.setMaxResults(pageSize);
		List<Employee> list = query.list();
		hibernateUtil.closeSession(session);
		return list;
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
