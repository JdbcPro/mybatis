package dao;

import entity.Employee;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {

    //返回Map
    @MapKey("id")
    public Map<Integer,Employee> getEmpReturnMaps(String lastName);

    //返回Map
    public Map<String,Object> getEmpReturnMap(Integer id);

    public List<Employee>  getEmpsByLastNameLike(String lastName);

    public Employee selEmpByMap(Map<String,Object> map);

    public Employee selEmpByIdAndLastName(@Param("id") Integer id, @Param("lastName") String lastName);

    public Employee selEmpById(Integer id);

    public Integer addEmp(Employee employee);

    public Integer updateEmp(Employee employee);

    public Integer deleteEmp(Integer id);
}
