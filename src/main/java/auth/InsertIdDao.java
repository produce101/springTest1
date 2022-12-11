package auth;


import Board.BoardVO;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InsertIdDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Autowired
    private SqlSessionFactory sqlSessionFactory;


    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;


    public int insertId(PassVO passVO) {
        return sqlSessionTemplate.insert("_auth.insertId", passVO);
    }


    public MemberVO getSelect(MemberVO memberVO) {

        return sqlSessionTemplate.selectOne("_auth.selectMember", memberVO);

    }


    public CustomUserDetailService getSelect1(MemberVO memberVO) {

        return sqlSessionTemplate.selectOne("_auth.selectMember", memberVO);

    }

}
