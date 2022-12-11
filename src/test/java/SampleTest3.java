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


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/resources/appContext.xml"})
public class SampleTest3 {

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
        System.out.println("셋업안되냐고??");
    }

/*    @Test
    public void a1() throws Exception {

        SampleVo1 sampleVo1 = new SampleVo1();

        sampleVo1.setFirstName("퍼스트네임");
        sampleVo1.setLastName("라스트네임dd");

        String jsonStr = new Gson().toJson(sampleVo1);

        MockHttpServletRequestBuilder mockHttpServletRequestBuilder =post("/a6")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonStr);

        mockMvc.perform(mockHttpServletRequestBuilder)
                .andExpect(status().is(200));

    }*/


    @Test
    public void doc () throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/doc?msg=123"));
    }

}
