package employee;
import tableMySql.*;
import java.util.List;

public interface SelectRequest {
   List<Employee> selectEmployee();
   List<EmpProfBuldSkil> selectFindEmployee(String message);
}

