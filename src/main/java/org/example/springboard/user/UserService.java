package org.example.springboard.user;

import org.example.springboard.Const;
import org.example.springboard.board.BoardMapper;
import org.example.springboard.user.model.UserEntity;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class UserService { //로직담당

    @Autowired //객체 자동생성
    private UserMapper mapper;
    @Autowired
    private HttpSession hs;

    public int login(UserEntity entity){
        UserEntity loginUser = null;
        try { loginUser = mapper.selUser(entity); }
        catch (Exception e){
            e.printStackTrace();
            return 0;
        }
        if(loginUser == null){
            return 2; //아이디 없음
        }
        //암호비교
        if (BCrypt.checkpw(entity.getUpw(), loginUser.getUpw())){ //비밀번호 맞았음
            loginUser.setUpw(null);
            loginUser.setRdt(null);
            hs.setAttribute(Const.LOGIN_USER, loginUser);
            return 1;
        }
        return 3; //비밀번호 다름
    }

    public int join(UserEntity entity){
        String plainPw = entity.getUpw();
        entity.setUpw(BCrypt.hashpw(entity.getUpw(), BCrypt.gensalt()));
        int result = mapper.insUser(entity);
        entity.setUpw(plainPw);
        return result;
    }
}
