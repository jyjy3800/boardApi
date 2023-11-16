package com.kopo.wise.domain.user;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;

import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserRequest {

    private Long id;                // ?��?�� 번호 (PK)
    private String loginId;         // 로그?�� ID
    private String password;        // 비�?번호
    private String name;            // ?���?
    private LocalDate birthday;     // ?��?��?��?��
    private int role;				// 권한

    public void encodingPassword(PasswordEncoder passwordEncoder) {
        if (StringUtils.isEmpty(password)) {
            return;
        }
        password = passwordEncoder.encode(password);
    }

}
