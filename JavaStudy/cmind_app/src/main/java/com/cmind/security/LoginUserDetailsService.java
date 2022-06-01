package com.cmind.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cmind.entity.Staff;
import com.cmind.entity.StaffExample;
import com.cmind.mybatis.mapper.StaffMapper;

/***
 * ログインイン時に認証ユーザーを「staffテーブル」から情報を取得するクラス
 */
@Service
public class LoginUserDetailsService implements UserDetailsService {
    @Autowired
    StaffExample staffExample;

    @Autowired
    StaffMapper staffMapper;
    
    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        //入力されたユーザーIDをキーにstaffテーブルのレコードを1件取得
        Staff staff = staffMapper.selectById(id);

        //該当レコードが取得できなかった場合はエラーにする
        if  (staff   ==  null)   {
            throw new UsernameNotFoundException("Wrong id or password");
        }

        //ログインユーザー権限を設定
        String role = "ROLE_ADMIN";

        return new LoginUserDetails(staff, role);
    }
}