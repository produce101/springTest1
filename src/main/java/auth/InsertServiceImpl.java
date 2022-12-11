package auth;


import Board.BoardDao;
import Board.BoardService;
import Board.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsertServiceImpl {

    @Autowired
    private InsertIdDao insertIdDao;

    public int insertId(PassVO passVO) {
        return insertIdDao.insertId(passVO);
    }
}
