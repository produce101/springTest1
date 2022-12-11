import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/resources/appContext.xml"})
public class DataSourceTest {

    @Autowired
    private DataSource ds;

    @Test
    public void testConn() throws Exception {

        try (Connection con = ds.getConnection()) {

            System.out.println("테스트 진행해" + con);

        } catch (Exception e) {

        }

    }


}
