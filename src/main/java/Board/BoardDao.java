package Board;


import OnlyConsole.LgTV;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BoardDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Autowired
    private SqlSessionFactory sqlSessionFactory;


    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    private String str1 = "SELECT COUNT(*) FROM board";

    BoardVO getSelect() {

        /*System.out.println("테스트");
        Long d = jdbcTemplate.queryForObject("select count(*) from board", Long.class);
        System.out.println("롱디는 " + d);


        int abc = sqlSessionFactory.openSession().selectOne("_test1Mapper.getRowCount", null);
        int bbc = sqlSessionTemplate.selectOne("_test1Mapper.getRowCount", null);*/

        //String cbc = sqlSessionTemplate.selectOne("_test1Mapper.getStr1", null);


        BoardVO boardVO = new BoardVO();
        boardVO.setStr1("안");

        System.out.println("뭐야 " + boardVO);

        //String cbc = sqlSessionTemplate.selectOne("_test1Mapper.getStr1");




        ArrayList<BoardVO> dbc = (ArrayList) sqlSessionTemplate.selectList("_test1Mapper.getStr3", boardVO);


        ArrayList<BoardVO> dbc2 = (ArrayList) sqlSessionFactory.openSession().selectList("_test1Mapper.getStr3", boardVO);



        BoardVO boardVO2 = new BoardVO();
        boardVO2.setStr1("than you");
        boardVO2.setName("유노윤호");
        boardVO2.setAge(37);

        //sqlSessionTemplate.insert("_test1Mapper.insertTest2", boardVO2);

        System.out.println("나옴?? " + dbc);

        System.out.println("들어간 seq 넘버는요?? " + boardVO2.getSeq());

        /*System.out.println("나오니?? " + abc);

        System.out.println("이거는되니? " + bbc);

        System.out.println("테스트에요? " + cbc);*/

        //System.out.println("디비시? " + cbc);

;


        boardVO.setAllRowCount(11);


        /*for(BoardVO aaa :  dbc) {
            System.out.println("돌려봅니당? " + aaa);
        }*/


        BoardVO vo = new BoardVO();
        //vo.setAllRowCount(Long.valueOf(d).intValue());

        return vo;
    }

}
