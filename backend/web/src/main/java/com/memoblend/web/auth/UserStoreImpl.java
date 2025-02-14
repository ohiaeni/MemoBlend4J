package com.memoblend.web.auth;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import com.memoblend.applicationcore.auth.UserStore;

/**
 * ログインしているユーザーの情報を保持するためのクラスです。
 */
public class UserStoreImpl implements UserStore {

    private final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

    @Override
    public String getLoginUserName() {
        if (authentication != null) {
            return authentication.getName();
        }
        return "";
    }

    @Override
    public List<String> getLoginUserRoles() {
        if (authentication != null) {
            return authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    @Override
    public boolean isInRole(String role) {
        if (authentication != null) {
            return authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority)
                    .anyMatch(roles -> roles.equals(role));
        }
        return false;
    }
}
