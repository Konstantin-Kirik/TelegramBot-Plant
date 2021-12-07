package dataBase;

import tableMySql.EmpProfBuldSkil;

import java.util.List;

public interface FindRequest {
    List<EmpProfBuldSkil> selectFindEmployee(String message);
}
