package com.ssi.task8;

public class Employee extends Thread {
	private int empno;
	private String ename;
	private int sal;
	
	
	public Employee(int empno, String ename, int sal) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.sal = sal;
	}

	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", ename=" + ename + ", sal=" + sal + "]";
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public void computeSal()
	{   
		String name = currentThread().getName();
		System.out.println(name+" HRA :"+ (10*sal)/100);
		System.out.println(name+" DA :"+(25*sal)/100);
		System.out.println(name+" CA "+(10*sal)/100);
	}
	

	@Override
	public void run() {
		computeSal();
	}

	public static void main(String[] args) {
		Employee  emp1=new Employee(101,"rr",20000);
		emp1.setName("Emp rr");
		Employee  emp2=new Employee(102,"ss",3000);
		emp2.setName("Emp ss");
		Employee  emp3=new Employee(103,"tt",4000);
		emp3.setName("Emp tt");
		Employee  emp4=new Employee(104,"uu",50000);
		emp4.setName("Emp uu");
		Employee  emp5=new Employee(105,"vv",60000);
		emp5.setName("Emp vv");
		emp1.start();
		emp2.start();
		emp3.start();
		emp5.start();
		emp4.start();
		
	}
}
