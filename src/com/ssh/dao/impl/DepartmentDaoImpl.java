package com.ssh.dao.impl;

import com.ssh.dao.DepartmentDao;
import com.ssh.model.Department;
import com.ssh.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import java.util.List;

/*
 * 部门管理DAO层的实现类
 */
public class DepartmentDaoImpl implements DepartmentDao {
	private HibernateUtil hibernateUtil;
	private Session session;

	public void setHibernateUtil(HibernateUtil hibernateUtil) {
		this.hibernateUtil = hibernateUtil;
	}
	@Override
	//部门条数
	public int findCount() {
		String hql = "select count(*) from Department";
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
	//分页部门查询
	public List<Department> findByPage(int begin, int pageSize) {

		String hql = "from Department";
		session = hibernateUtil.getSession();
		Query query = session.createQuery(hql);
		System.out.println(begin);
		System.out.println(pageSize);
		query.setFirstResult(begin);
		query.setMaxResults(pageSize);
		List<Department> list = query.list();
		hibernateUtil.closeSession(session);
		return list;
	}

	@Override
	//部门添加
	public void save(Department department) {
		session = hibernateUtil.getSession();
		session.save(department);
	}

	@Override
	public Department findById(Integer did) {
		session = hibernateUtil.getSession();
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
