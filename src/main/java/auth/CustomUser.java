package auth;

import lombok.Data;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


public class CustomUser extends User {

    @Getter
    private MemberVO memberVO;

    public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public CustomUser(MemberVO memberVO) {


        super(memberVO.getUserId(), memberVO.getUserPw(), memberVO.getAuthList().stream().map(authVO -> new SimpleGrantedAuthority(authVO.getAuth())).collect(Collectors.toList()));

        System.out.println("되기는 합니까??");

        this.memberVO = memberVO;

    }


    public CustomUser(MemberVO memberVO, List<GrantedAuthority> roles2) {
        super(memberVO.getUserId(), memberVO.getUserPw(), roles2);
        memberVO.setUserPw("");
        this.memberVO = memberVO;
    }



}
