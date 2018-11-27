package dao;

import entity.Department;

public interface DepartmentMapper {
    /*根据ID查询部门*/
    public Department getDepById(Integer id);

    public Department getDepByIdPlus(Integer id);

    public Department getDepByIdStep(Integer id);
}
