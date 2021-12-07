package dataBase;

import tableMySql.EmpProfBuldSkil;
import tableMySql.Employee;
import java.util.List;

public interface SelectRequest {

    List<Employee> selectEmployee();
    List<EmpProfBuldSkil> selectEmployeeInfoAll();
}
