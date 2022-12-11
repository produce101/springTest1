import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/resources/appContext.xml")
public class MybatisTest {

    @Autowired
    SqlSessionFactory sqlSessionFactory;

    @Test
    public void test1() {

        String resource = "mybatis/global.properties";
        Properties properties = new Properties();

        try {
            Reader reader = Resources.getResourceAsReader(resource);
            properties.load(reader);
            System.out.println(properties.getProperty("jdbc.driver"));
            System.out.println(properties.getProperty("jdbc.username"));
            System.out.println(properties.getProperty("jdbc.password"));
            System.out.println(properties.getProperty("jdbc.url"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("테스트1 " + sqlSessionFactory);
    }

    @Test
    public void test2() {
        try (SqlSession session = sqlSessionFactory.openSession()){
            System.out.println("테스트2" + session);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
