import com.qy.dao.BlogMapper;
import com.qy.pojo.Blog;
import com.qy.utils.IDUtils;
import com.qy.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class MyTest {
    @Test
    public void test1(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        Blog blog = new Blog();
        blog.setId(IDUtils.getId());
        blog.setTitle("Mybatis如此简单");
        blog.setAuthor("狂神说");
        blog.setCreate_time(new Date());
        blog.setViews(9999);

        blog.setId(IDUtils.getId());
        blog.setTitle("Java如此简单");
        mapper.addBlog(blog);

        blog.setId(IDUtils.getId());
        blog.setTitle("Spring如此简单");
        mapper.addBlog(blog);

        blog.setId(IDUtils.getId());
        blog.setTitle("微服务如此简单");
        mapper.addBlog(blog);

        mapper.addBlog(blog);
        sqlSession.close();
    }

    @Test
    public void test2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
//        map.put("title", "Java如此简单");
        map.put("views","9999");

        List<Blog> blogs = mapper.queryBlogChoose(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }

        sqlSession.close();
    }

    @Test
    public void test3(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
        ArrayList<Integer> ids = new ArrayList();
        ids.add(1);
        ids.add(2);
        map.put("ids",ids);
        List<Blog> blogs = mapper.queryBlogForEach(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }

        sqlSession.close();
    }
}
