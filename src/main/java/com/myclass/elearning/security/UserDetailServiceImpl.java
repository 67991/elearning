package com.myclass.elearning.security;

import com.myclass.elearning.enity.User;
import com.myclass.elearning.repo.UserRepo;
import com.myclass.elearning.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
@Autowired
private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        //Lấy ra user có email giống email người dùng gửi lên từ from đăng nhập
        User user = userRepo.findByEmail(email);
        if(user == null ) throw new UsernameNotFoundException("Không tìm thấy tài khoản!");
        //Tạo danh sách chưa tên quyên cả người dùng
        List<GrantedAuthority> authorities = new ArrayList<>();
        String roleName = user.getRole().getName();//Lấy ra tên quyền
        authorities.add(new SimpleGrantedAuthority(roleName));//Lưu vào danh sách

        // Trả về đối tượng chưa thông tin email, pasword và quyền

        return new CustomUserDetails(user.getEmail(), user.getPassword(), authorities);
    }
}
