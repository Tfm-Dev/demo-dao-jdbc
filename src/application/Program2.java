package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("===== TEST 1: department findById =====");
        Department department = departmentDao.findById(1);
        System.out.println(department);

        System.out.println("\n===== TEST 2: department findAll =====");
        List<Department> departments = departmentDao.findAll();
        departments.forEach(System.out::println);

        System.out.println("\n===== TEST 3: department insert =====");
        department = new Department(null, "Teste");
        departmentDao.insert(department);
        System.out.println("Inserted completed! Id = " + department.getId());

        System.out.println("\n===== TEST 4: department update =====");
        department = departmentDao.findById(5);
        department.setName("D1");
        departmentDao.update(department);
        System.out.println("Updated completed!");

        System.out.println("\n===== TEST 5: department delete =====");
        System.out.print("Enter id for delete test: ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Deleted completed!");

        sc.close();
    }
}
