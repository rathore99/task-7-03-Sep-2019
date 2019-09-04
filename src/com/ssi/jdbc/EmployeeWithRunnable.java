
public class EmployeeWithRunnable implements Runnable {

	private int empno;
	private String ename;
	private int sal;

	public EmployeeWithRunnable(int empno, String ename, int sal) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.sal = sal;
	}

	@Override
	public String toString() {
		return "EmployeeWithRunnable [empno=" + empno + ", ename=" + ename + ", sal=" + sal + "]";
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

	public void computeSal() {
		String name = Thread.currentThread().getName();
		System.out.println(name + " HRA :" + (10 * sal) / 100);
		System.out.println(name + " DA :" + (25 * sal) / 100);
		System.out.println(name + " CA " + (10 * sal) / 100);
	}

	@Override
	public void run() {
		computeSal();

	}

	public static void main(String[] args) {
		EmployeeWithRunnable emp1 = new EmployeeWithRunnable(101, "rr", 200);
		EmployeeWithRunnable emp2 = new EmployeeWithRunnable(102, "ss", 1000);
		EmployeeWithRunnable emp3 = new EmployeeWithRunnable(103, "tt", 300);
		EmployeeWithRunnable emp4 = new EmployeeWithRunnable(104, "uu", 500);
		EmployeeWithRunnable emp5 = new EmployeeWithRunnable(105, "vv", 700);
		
		Thread t1 = new Thread(emp1);
		t1.start();
		Thread t2 = new Thread(emp2);
		t2.start();
		Thread t3 = new Thread(emp3);
		t3.start();
		
		Thread t4 = new Thread(emp4);
		t4.start();
		Thread t5 = new Thread(emp5);
		t5.start();

	}

}
