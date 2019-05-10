package com.ssh.action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ssh.model.Department;
import com.ssh.model.Employee;
import com.ssh.model.PageBean;
import com.ssh.service.DepartmentService;
import com.ssh.service.EmployeeService;

import java.util.List;

/**
 * 员工管理的Action类
 * 利用模型驱动接收页面的参数
 * 然后调用service层
 */
public class EmployeeAction extends ActionSupport implements ModelDriven<Employee> {
	//这里的employee会直接被页面传过来的值赋值
	private Employee employee = new Employee();
	@Override
	public Employee getModel() {
		return employee;
	}

	//注入业务层类
	private EmployeeService employeeService;
	private DepartmentService departmentService;

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	/**
	 * 登陆执行的方法
	 */
	public String login() {
		System.out.println("login执行了...");
		//调用业务层的类
		Employee existEmployee = employeeService.login(employee);
		if(existEmployee == null) {
			//登陆失败
			this.addActionError("用户名或密码错误！");
			return INPUT;
		} else{
			//登陆成功就将用户信息存入session对象
			ActionContext.getContext().getSession().put("existEmployee", existEmployee);
			return SUCCESS;
		}
	}

	//分页功能
	private Integer currPage=1;

	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}

	//提供查询的方法
	public String findAll() {
		PageBean<Employee> pageBean = employeeService.findByPage(currPage);
		//将pageBean存入值栈中   对象用push
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}

	//添加员工的方法
	//由于需要展示所有的部门来供员工选择，所有需要持有DepartmentService
	public String saveUI() {
		//查询所有部门
		List<Department> list = departmentService.findAll();
		//将list存入值栈中，集合用set
		ActionContext.getContext().getValueStack().set("list",list);
		return "saveUI";
	}

	//添加员工的方法
	public String save() {
		employeeService.save(employee);
		return "saveSuccess";
	}

	//编辑员工的方法
	public String edit() {
		//根据员工id查询员工
		employee = employeeService.findById(employee.getEid());
		//查询所有部门集合
		List<Department> list = departmentService.findAll();
		//将list存入值栈中，集合用set
		ActionContext.getContext().getValueStack().set("list",list);
		return "editSuccess";
	}

	//修改员工信息的方法
	public String update() {
		employeeService.update(employee);
		return "updateSuccess";
	}

	//删除员工的方法
	public String delete() {
		//删除之前先查询是否有该部门
		employee = employeeService.findById(employee.getEid());
		employeeService.delete(employee);
		return "deleteSuccess";
	}
}
