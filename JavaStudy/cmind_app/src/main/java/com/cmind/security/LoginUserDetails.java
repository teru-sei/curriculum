package com.cmind.security;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.cmind.entity.Staff;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
//equals()とhashCode()を生成するが親クラスのメソッドは呼び出さない
@EqualsAndHashCode(callSuper=false)
public class LoginUserDetails extends User{
    //staffテーブルから取得したオブジェクトを格納
	private final Staff staff;

    //認証処理
    public LoginUserDetails(Staff staff, String role) {
        //staffテーブルのユーザーIDとパスワードでログイン認証を行う
        super(staff.getId(), staff.getPassword(), AuthorityUtils.createAuthorityList(role));
        
        BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
        bcpe.matches(staff.getPassword(), staff.getPassword());
        this.staff = staff;
        
    }
}