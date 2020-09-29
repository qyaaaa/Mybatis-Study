import com.qy.dao.StudentMapper;
import com.qy.dao.TeacherMapper;
import com.qy.pojo.Student;
import com.qy.pojo.Teacher;
import com.qy.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher(1);
        System.out.println(teacher);
        sqlSession.close();
    }

    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        List<Student> studentList = mapper.getStudent();

        for (Student student : studentList) {
            System.out.println(student);
        }

        sqlSession.close();
    }

    @Test
    public void test2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> studentList = mapper.getStudent2();

        for (Student student : studentList) {
            System.out.println(student);
        }

        sqlSession.close();
    }

}
