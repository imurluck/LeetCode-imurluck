package classification.bfs.easy;

import model.Employee;

import java.util.HashMap;
import java.util.List;

public class ImportEmployee690 {

    public static int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> employeeMap = new HashMap<>();
        for (Employee employee : employees) {
            employeeMap.put(employee.id, employee);
        }
        Employee targetEmployee = employeeMap.get(id);
        return getSumImportance(employeeMap, targetEmployee);
    }

    public static int getSumImportance(HashMap<Integer, Employee> employeeMap, Employee root) {
        if (root == null) {
            return 0;
        }
        int sum = root.importance;
        for (Integer id : root.subordinates) {
            Employee employee = employeeMap.get(id);
            sum += getSumImportance(employeeMap, employee);
        }
        return sum;
    }
}
