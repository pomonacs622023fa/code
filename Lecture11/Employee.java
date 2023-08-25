import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Class demonstrating Comparable and Comparator interfaces
 * Adapted from https://stackoverflow.com/questions/2266827/when-to-use-comparable-and-comparator
 */
public class Employee implements Comparable<Employee> {

	private int id;
	private String name;
	private int age;
	private long salary;

	public Employee() {
	}

	public Employee(int id, String name, int age, long salary) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	@Override
	public int compareTo(Employee e) {
		if (this.id > e.id) {
			return 1;
		} else if (this.id < e.id) {
			return -1;
		} else {
			return Character.toString(this.name.charAt(0)).compareToIgnoreCase(Character.toString(e.name.charAt(0)));
		}
	}

	public static Comparator<Employee> nameComparator = new Comparator<Employee>() {
		@Override
		public int compare(Employee e1, Employee e2) {
			return e1.getName().compareTo(e2.getName());
		}
	};

	public static Comparator<Employee> idComparator = new Comparator<Employee>() {
		@Override
		public int compare(Employee e1, Employee e2) {
			return Integer.valueOf(e1.getId()).compareTo(Integer.valueOf(e2.getId()));
		}
	};

	public static void main(String[] args) {

		Employee e1 = new Employee(5, "Yash", 22, 1000);
		Employee e2 = new Employee(8, "Tharun", 24, 25000);
		Employee e3 = new Employee(5, "Yush", 18, 10000);
		
		System.out.print("Natural comparison of " + e1 + " and "+ e2 + "is: ");
		System.out.println(e1.compareTo(e2));
		
		System.out.print("Natural comparison of " + e2 + " and "+ e3 + "is: ");
		System.out.println(e2.compareTo(e3));
		
		System.out.print("Natural comparison of " + e1 + " and "+ e3 + "is: ");
		System.out.println(e1.compareTo(e3));
		
		System.out.print("Name comparison of " + e1 + " and "+ e2 + "is: ");
		System.out.println(Employee.nameComparator.compare(e1, e2));
		
		System.out.print("Name comparison of " + e2 + " and "+ e3 + "is: ");
		System.out.println(Employee.nameComparator.compare(e2, e3));
		
		System.out.print("Name comparison of " + e1 + " and "+ e3 + "is: ");
		System.out.println(Employee.nameComparator.compare(e1, e3));

		System.out.print("ID comparison of " + e1 + " and "+ e2 + "is: ");
		System.out.println(Employee.idComparator.compare(e1, e2));
		
		System.out.print("ID comparison of " + e2 + " and "+ e3 + "is: ");
		System.out.println(Employee.idComparator.compare(e2, e3));
		
		System.out.print("ID comparison of " + e1 + " and "+ e3 + "is: ");
		System.out.println(Employee.idComparator.compare(e1, e3));

		List<Employee> list = new ArrayList<Employee>();
		list.add(e1);
		list.add(e2);
		list.add(e3);
		
		System.out.print("Unsorted list: ");
		System.out.println(list);
		
		Collections.sort(list); // call @compareTo(o1)
		System.out.print("Naturally sorted list: ");
		System.out.println(list);

		Collections.sort(list, Employee.nameComparator); // call @compare (o1,o2)
		System.out.print("Sorted list based on names: ");
		System.out.println(list);

		Collections.sort(list, Employee.idComparator); // call @compare (o1,o2)
		System.out.print("Sorted list based on IDs: ");
		System.out.println(list);
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", salary=" + salary + "]";
	}
}