package Board;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardDao boardDao;

    public BoardVO getBoard(BoardVO vo) {
        return boardDao.getSelect();
    }

/*    @Autowired
    private BoardDao boardDao;

    public BoardVO getBoard(BoardVO vo) {
        return boardDao.getSelect();
    }*/
}
