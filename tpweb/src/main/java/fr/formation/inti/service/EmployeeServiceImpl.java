package fr.formation.inti.service;

import java.util.List;

import fr.formation.inti.dao.EmployeeDaoImpl;
import fr.formation.inti.entity.Employee;

public class EmployeeServiceImpl implements EmployeeService{
	
	EmployeeDaoImpl dao;
	
	public EmployeeServiceImpl() {
		dao = new EmployeeDaoImpl();
	}

	@Override
	public Employee findById(Integer id) {
		dao.beginTransaction();
		Employee c = dao.findById(id);
		dao.commit(true);
		return c;
	}

	@Override
	public List<Employee> findAll() {
		dao.beginTransaction();
		List<Employee> list = dao.findAll();
		dao.commit(true);
		return list;
	}

	@Override
	public Integer save(Employee c) {
		dao.beginTransaction();
		Employee cust = dao.save(c);
		
		dao.commit(true);
		return cust.getEmpId();
	}

	@Override
	public void delete(Employee entiy) {
		dao.beginTransaction();
		dao.delete(entiy);
		dao.commit(true);
		
	}

	@Override
	public void deleteById(Integer id) {
		dao.beginTransaction();
		dao.deleteById(id);
		dao.commit(true);
		
	}

}
