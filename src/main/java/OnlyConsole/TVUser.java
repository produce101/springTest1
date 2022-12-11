package OnlyConsole;

import Board.BoardDao;
import Board.Test1;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

    public static void main(String[] args) {

        AbstractApplicationContext factory = new GenericXmlApplicationContext("appContext.xml");

        //AbstractApplicationContext factory = new GenericXmlApplicationContext("sptingTest1/web/WEB-INF/appContext.xml");

        //C:\workspace\spring_project\sptingTest1\web\WEB-INF\appContext.xml

        TV tv = (TV) factory.getBean("tv");
        /*TV tv2 = (TV) factory.getBean("tv");


        tv.turnOn();
        tv2.turnOn();
        bd.doTest1();
        bd.doTest2();
        System.out.println("##############");
        try {
            bd.abcTest3(" 아이브~~", "다이브~~~~~");
        } catch (Exception e) {

        }*/

        Test1 bd = (Test1) factory.getBean("bd");
        bd.abcTest3(" 아이브~~", "다이브~~~~~");
        bd.doTest1();


        //tv3.turnOn();

    }

}
