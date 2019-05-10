package com.ssh.service;


import com.ssh.model.Department;
import com.ssh.model.PageBean;

import java.util.List;

public interface DepartmentService {

	PageBean<Department> findByPage(Integer currPage);

	void save(Department department);

	Department findById(Integer did);

	void update(Department department);

	void delete(Department department);

	List<Department> findAll();

}
