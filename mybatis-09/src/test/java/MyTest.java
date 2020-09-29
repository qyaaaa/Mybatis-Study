import com.qy.dao.UserMapper2;
import com.qy.pojo.User;
import com.qy.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MyTest {
    @Test
    public void test1(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        SqlSession sqlSession1 = MybatisUtils.getSqlSession();

        UserMapper2 mapper = sqlSession.getMapper(UserMapper2.class);
        UserMapper2 mapper1 = sqlSession1.getMapper(UserMapper2.class);

        User user = mapper.queryUserById(1);
        System.out.println(user);

        //mapper.updateUser(new User(2, "aaaa", "bbbb"));

        //清理缓存
        //sqlSession.clearCache();

        System.out.println("=========================");

        User user1 = mapper.queryUserById(1);
        System.out.println(user1);

        System.out.println(user==user1);

        sqlSession.close();
        sqlSession1.close();
    }
}
