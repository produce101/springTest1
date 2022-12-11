package Board;


import OnlyConsole.AppleSpeaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("bd")
public class Test1 {


    @Autowired
    BoardService boardService;


    AppleSpeaker appleSpeaker;

   // @Autowired
    //BoardVO boardVO;

    public void doTest1() {
        BoardVO boardVO = boardService.getBoard(new BoardVO());

        System.out.println("가져온 board VO는 " + boardVO);
    }

    public void doTest2() {
        System.out.println("두테스트222");
    }

    public String abcTest3(String a, String b) {

        System.out.println("에이비시스트333" + a);

/*        try {
            appleSpeaker.volumeUp();
        } catch (Exception e) {
            System.out.println("실패 " + e);
            //throw new RuntimeException("Exception :: To trigger @AfterThrowing");
            throw new IllegalArgumentException("꺄후울~~");
        }*/
        return "123 ive~~~";
    }

    public String abcTest4() {
        return "이건 뭐에요??";
    }


}
