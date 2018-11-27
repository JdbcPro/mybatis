package test;

import dao.DepartmentMapper;
import dao.EmployeeMapper;
import dao.EmployeeMapperPlus;
import entity.Department;
import entity.Employee;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import util.MybatisUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MybatisTest1 {

    @Test
    public void test1() {
        SqlSessionFactory sessionFactory = MybatisUtil.getSessionFactory();
        SqlSession sqlSession = sessionFactory.openSession();
        try {
            EmployeeMapperPlus mapper = sqlSession.getMapper(EmployeeMapperPlus.class);
            Employee employee = mapper.getEmpById(1);
            System.out.println(employee);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void test2() {
        SqlSessionFactory sessionFactory = MybatisUtil.getSessionFactory();
        SqlSession sqlSession = sessionFactory.openSession();
        try {
            EmployeeMapperPlus mapper = sqlSession.getMapper(EmployeeMapperPlus.class);
            Employee employee = mapper.getEmpAndDept(1);
            System.out.println(employee);
            System.out.println(employee.getDepartment().getDeptname());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void test3() {
        SqlSessionFactory sessionFactory = MybatisUtil.getSessionFactory();
        SqlSession sqlSession = sessionFactory.openSession();
        try {
            EmployeeMapperPlus mapper = sqlSession.getMapper(EmployeeMapperPlus.class);
            Employee employee = mapper.getEmpAndDeptStep(1);
            System.out.println(employee.getLastName());
            System.out.println(employee.getDepartment());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void test4() {
        SqlSessionFactory sessionFactory = MybatisUtil.getSessionFactory();
        SqlSession sqlSession = sessionFactory.openSession();
        try {
            DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
            Department dep = mapper.getDepByIdPlus(1);
            System.out.println(dep);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void test5() {
        SqlSessionFactory sessionFactory = MybatisUtil.getSessionFactory();
        SqlSession sqlSession = sessionFactory.openSession();
        try {
            DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
            Department dep = mapper.getDepByIdStep(1);
            System.out.println(dep.getDeptname());
            System.out.println(dep.getEmps());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }
}
