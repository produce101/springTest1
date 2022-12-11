package auth;


import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private InsertServiceImpl insertService;



    @RequestMapping("all")
    public void all() {

    }

    @RequestMapping("member")
    public void member() {

    }

    @RequestMapping("admin")
    public void admin() {

    }

    @RequestMapping("authErr")
    public void authErr(Authentication authentication, Model model) {

        System.out.println("억세스 디나이드 " + authentication);
        model.addAttribute("msg", "억세스 디나이드다");
    }


    @RequestMapping("customLogin")
    public void customLogin(String error, String logout, Model model) {

        System.out.println("뭐야이거?");
        System.out.println("error " + error);
        System.out.println("logout " + logout);

        if (logout != null) {
            model.addAttribute("logout", "Login Error Check Your Account");
        }

        if (error != null) {

            System.out.println("error " + "에러뜨나요오오옹??");
            model.addAttribute("error", "Logout!!");
        }
    }

    @RequestMapping("customLogin2")
    public void customLogin2(String error, String logout, Model model) {

    }

    @RequestMapping("customLogout")
    public void customLogout() {

    }


    @RequestMapping("test1")
    public void test1() {

    }


    @RequestMapping("insertid")
    @ResponseBody
    public String insertid() {

        PassVO passVO = new PassVO();

        String encoderPass = bCryptPasswordEncoder.encode("qweqwe12");

        passVO.setId("abc");
        passVO.setPass(encoderPass);
        passVO.setName("에이비씨");


        insertService.insertId(passVO);

        System.out.println("인서트 아이디 성고옹~" + passVO);

        return "성공";
    }



}
