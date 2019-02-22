package api.managesoccer.config;

import api.managesoccer.model.ManagePrivilege;
import api.managesoccer.model.Player;
import api.managesoccer.repository.PlayerRepository;
import api.managesoccer.repository.PrivilegeRepository;
import api.managesoccer.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService implements UserDetailsService {
    @Autowired
    PlayerService playerService;
    UserDetail userDetail;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Player player = playerService.findByUsername(username);

        if (player == null) {
            throw new UsernameNotFoundException("UserName " + username + " not found");
        }
        System.out.println(new UserDetail(player).toString());
        userDetail = new UserDetail(player);
        return userDetail;
    }

    public UserDetail getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetail userDetail) {
        this.userDetail = userDetail;
    }


}
