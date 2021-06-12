package com.cts.lombok;

import com.cts.lombok.model.Employee;
import com.cts.lombok.model.PartTimeEmployee;

public class Main {

	public static void main(String[] args) {
		Employee emp1=new Employee(1001, "FP Jones", 50000);
		System.out.println(emp1);
		PartTimeEmployee ptemp1=new PartTimeEmployee();
		ptemp1.setId(2001);
		ptemp1.setName("Hiram Lodge");
		ptemp1.setSalary(60000);
		System.out.println(ptemp1);
	}

}
