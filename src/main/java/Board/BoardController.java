package Board;


import OnlyConsole.AppleSpeaker;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;
import java.beans.PropertyEditor;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping
@Log4j
public class BoardController {



    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    BoardService boardService;



    // @Autowired
    //BoardVO boardVO;






    @RequestMapping("/")
    public String home(Model model){
        System.out.println("되요123??");
        //BoardVO boardVO = boardService.getBoard(new BoardVO());
        return "home/index";
    }


/*    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    public void test1() {
        System.out.println("테스트1");
    }


    @ExceptionHandler(ArithmeticException.class)
    public String err1(Exception e) {

        System.out.println("111이게 실행되긴하는데요 " + e);
        return "home/err";
    }*/


/*    @ExceptionHandler(NullPointerException.class)
    public String err2(Exception e) {

        System.out.println("222이게 실행되긴하는데요 " + e);
        return "home/err";
    }*/

/*    @ExceptionHandler(Exception.class)
    public String err3(Exception e) {

        System.out.println("이게 실행되긴하는데요 " + e);
        return "home/err";
    }*/

    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
    public String login(BoardVO boardVO, HttpServletRequest httpServletRequest){

        /*SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
        sessionLocaleResolver.setDefaultLocale(new Locale("en"));*/


        Locale locale = Locale.ENGLISH;

        System.out.println("로케일은 " + locale);
        httpServletRequest.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, locale);


        return "home/login";
    }

    @ResponseBody
    @RequestMapping(value = "/data1")
    public List<BoardVO> tests() {

        List<BoardVO> boardVOList = new ArrayList<BoardVO>();


        BoardVO boardVO = new BoardVO();
        boardVO.setName("만도");
        boardVO.setAge(37);

        BoardVO boardVO2 = new BoardVO();
        boardVO2.setName("그로구");
        boardVO2.setAge(50);


        boardVOList.add(boardVO);
        boardVOList.add(boardVO2);


        return boardVOList;

    }



    @ResponseBody
    @RequestMapping(value = "/data2")
    public BoardListVo test6() {

        List<BoardVO> boardVOList = new ArrayList<BoardVO>();

        BoardListVo boardListVo = new BoardListVo();


        BoardVO boardVO = new BoardVO();
        boardVO.setName("만도");
        boardVO.setAge(37);

        BoardVO boardVO2 = new BoardVO();
        boardVO2.setName("그로구");
        boardVO2.setAge(50);

        boardVOList.add(boardVO);
        boardVOList.add(boardVO2);



        boardListVo.setBoardList(boardVOList);


        return boardListVo;

    }





    //@ResponseBody
    @RequestMapping(value = "/insertFile", method = {RequestMethod.GET, RequestMethod.POST})
    public void insertFile(BoardVO boardVO){


        String d = boardVO.getStr1();



        System.out.println("이거는123321zzz " + d);
        //return  d;
        throw new NullPointerException("아이디는 반드시 입력321555111");

        //String abc = multipartFile.getOriginalFilename();
        /*if(!multipartFile.isEmpty()) {
            System.out.println("있음");

            String filename = multipartFile.getOriginalFilename();

             multipartFile.transferTo(new File("C:\\workspace\\임시\\" + filename));

        } else {
            System.out.println("없음");
        }*/



        ///System.out.println("비비시는123 " + bbc);
        //System.out.println("에이비시는 " + abc + " " + bbc);

    }



    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {

        //webDataBinder.

        System.out.println("이닛바인더??123 " + webDataBinder.getObjectName() + " " + webDataBinder.getFieldDefaultPrefix());


        //webDataBinder.setAllowedFields("msg");

        //webDataBinder.registerCustomEditor(String.class,  new Customer());

        //log.debug("여기 호출되나요??");

    }



    @RequestMapping(value = "/doc")
    public String doc(HttpServletRequest httpServletRequest, @Validated BoardVO boardVO, @Validated  @ModelAttribute("msg") String msg, Model model, HttpSession httpSession){

        //BoardVO boardVO1 = new BoardVO();
        log.error("허허허");

        log.debug("허허허222");


        System.out.println("잘됩니11133당~" + msg);

        model.addAttribute("abc","징징이");

        httpServletRequest.getSession().setAttribute("wow","알라바마");

        model.addAttribute(boardVO);


        httpSession.setAttribute("aaa","~~넘어가는 값 변경 확인~~");

        httpSession.setAttribute("aab","이거는요??");

        return "home/doc";
    }






    @GetMapping(value = "/dod")
    public String dod(HttpServletRequest httpServletRequest, BoardVO boardVO, Model model, RedirectAttributes redirectAttributes){

        redirectAttributes.addFlashAttribute("str1","어헛~");


        String s = (String) httpServletRequest.getSession().getAttribute("wow");




        System.out.println("세션 찍히는거 확인 " + s);

        return "home/dod";
        //return "redirect:/doc";
    }


    @GetMapping(value = "/doe")
    public String doe(BoardVO boardVO, Model model, RedirectAttributes redirectAttributes){

        redirectAttributes.addFlashAttribute("str1","어헛~");


        return "redirect:/doc";
    }







    @ResponseBody
    @RequestMapping(value = "/dojson")
    public BoardVO dojson(BoardVO boardVO, Model model, RedirectAttributes redirectAttributes){

        redirectAttributes.addFlashAttribute("str1","어헛~");

        BoardVO boardVO1 = new BoardVO();

        boardVO1.setAge(3);
        boardVO1.setStr1("안냥");

        return boardVO1;
    }

    @ResponseBody
    @RequestMapping(value = "/ex01")
    public ResponseEntity ex01(){


        HttpHeaders headers = new HttpHeaders();

        String msg = "{\"name\": \"홍길동\"}";

        headers.add("content-Type", "application/json;charset=UTF-8");

        return new ResponseEntity<>(msg, headers, HttpStatus.OK);

    }


    @RequestMapping(value = "/do1")
    public String do1(){


        return "안녕하세요~";
    }


}
