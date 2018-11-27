package test;

import dao.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;

import entity.Employee;
import util.MybatisUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MybatisTest {

    @Test
    public void selectOneTest() {
        SqlSessionFactory sqlSessionFactory = MybatisUtil.getSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            Employee employee = sqlSession.selectOne("dao.EmployeeDao.selectEmp", 1);
            System.out.println(employee);
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void selEmpByIdTest() {
        SqlSessionFactory sqlSessionFactory = MybatisUtil.getSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            //3 、获取接口的实现类
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = mapper.selEmpById(1);
            System.out.println(employee);
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void addEmpTest() {
        SqlSessionFactory sqlSessionFactory = MybatisUtil.getSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            //3 、获取接口的实现类
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

            //测试增加
            Employee employee = new Employee();
            employee.setLastName("jack");
            employee.setEmail("jack@qq.com");
            employee.setGender('1');
            Integer integer = mapper.addEmp(employee);
            System.out.println(employee.getId());
            //System.out.println(integer);


            /*测试修改
            Employee employee = new Employee();
            employee.setId(1);
            employee.setGender('1');
            employee.setLastname("bigtom");
            employee.setEmail("bigtom@qq.com");
            mapper.updateEmp(employee);*/

            //mapper.deleteEmp(2);


            sqlSession.commit();

        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void selEmpByIdAndLastname() {
        SqlSessionFactory sqlSessionFactory = MybatisUtil.getSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            //3 、获取接口的实现类
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = mapper.selEmpByIdAndLastName(1, "tom");
            System.out.println(employee);
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void selEmpByMap() {
        SqlSessionFactory sqlSessionFactory = MybatisUtil.getSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            //3 、获取接口的实现类
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Map<String, Object> map = new HashMap<>();
            map.put("id", 1);
            map.put("lastName", "tom");
            Employee employee = mapper.selEmpByMap(map);
            System.out.println(employee);
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void getEmpsByLastNameLike() {
        SqlSessionFactory sqlSessionFactory = MybatisUtil.getSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            //3 、获取接口的实现类
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            List<Employee> list = mapper.getEmpsByLastNameLike("ja%");
            for (Employee employee : list) {
                System.out.println(employee);
            }
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void getEmpReturnMap() {
        SqlSessionFactory sqlSessionFactory = MybatisUtil.getSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            //3 、获取接口的实现类
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Map<String, Object> map = mapper.getEmpReturnMap(1);
            System.out.println(map);

        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void getEmpReturnMaps() {
        SqlSessionFactory sqlSessionFactory = MybatisUtil.getSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            //3 、获取接口的实现类
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Map<Integer, Employee> maps = mapper.getEmpReturnMaps("j%");
            System.out.println(maps);

        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }
}
