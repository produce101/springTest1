package auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private InsertIdDao insertIdDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws BadCredentialsException{


        System.out.println("유저네임은 " + username);

        MemberVO memberVO = new MemberVO();
        memberVO.setUserId(username);
        memberVO.setInfo("인포입니다~~");

        MemberVO customUserDetailService = insertIdDao.getSelect(memberVO);

        if(customUserDetailService == null) {
            System.out.println("널인데요??");
            //CustomLoginFailedHandler로 메시지를 보낸 후 최종적으로 프론트단 ajax에서 값을 받기 위하여 일부러 내는 오류이니
            //콘솔에 An internal error occurred while trying to authenticate the user.가 뜨더라도 신경쓰지 말고 무시할것 (메이븐으로 받은 시큐리티 jar 파일에 오류출력 강제사항이라 수정할수 가 없음)
            //본 방법을 쓰지 않고도 CustomLoginFailedHandler에 메시지를 보낼 수 있거나 ajax에 메시지를 보낼 수 있는 방법이 있으면 그 방법을 쓸것
            throw new BadCredentialsException("notAuth");

        }

        customUserDetailService.setInfo("admin");

        /*List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
        roles.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

        List<GrantedAuthority> ADMIN_ROLES = AuthorityUtils.createAuthorityList("ROLE_ADMIN");*/

        List<GrantedAuthority> roles2 = new ArrayList<>();

        for (AuthVO list:customUserDetailService.getAuthList()) {
            roles2.add(new SimpleGrantedAuthority(list.getAuth()));
        }


        UserDetails userDetails2 = new CustomUser( customUserDetailService, roles2 );


        //System.out.println("이건되요?? " + customUserDetailService + " " +userDetails.getUsername() + " " + userDetails.getAuthorities());

        return userDetails2;
    }
}
