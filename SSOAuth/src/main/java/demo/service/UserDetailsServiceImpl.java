package demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        // 获取用户权限列表
        List<GrantedAuthority> authorities = new ArrayList();
            // 存储用户、角色信息到GrantedAuthority，并放到GrantedAuthority列表
        GrantedAuthority authority = new SimpleGrantedAuthority("user");
        authorities.add(authority);

        return new User("test",passwordEncoder.encode("user"),authorities);
    }
}
