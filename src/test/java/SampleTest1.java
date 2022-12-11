import auth.InsertIdDao;
import auth.MemberVO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/resources/appContext.xml"})
public class SampleTest1 {


    @Autowired
    WebApplicationContext webApplicationContext;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    InsertIdDao insertIdDao;


    MockMvc mockMvc;


    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
        System.out.println("셋업이심~");
    }

    //@Test
    public void testdoa () throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/doc?msg=123"));
    }



    @Test
    public void testdob () throws Exception {
        String encoderPass = bCryptPasswordEncoder.encode("qweqwe12");
        System.out.println("찍어 봅니다~ " + encoderPass);


        MemberVO memberVO = new MemberVO();
        memberVO.setUserId("abc");
        MemberVO memberVO1 = insertIdDao.getSelect(memberVO);
        System.out.println("이거됩니까!!??" + memberVO1);
    }




}
