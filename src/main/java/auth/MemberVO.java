package auth;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class MemberVO {

    private String userId;
    private String userPw;
    private  String userName;
    private boolean enabled;
    private String info;

    private Date regDate;
    private Date updateDate;
    private List<AuthVO> authList;

}
