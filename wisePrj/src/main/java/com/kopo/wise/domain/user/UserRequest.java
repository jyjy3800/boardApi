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

    private Long id;                // ?? λ²νΈ (PK)
    private String loginId;         // λ‘κ·Έ?Έ ID
    private String password;        // λΉλ?λ²νΈ
    private String name;            // ?΄λ¦?
    private LocalDate birthday;     // ????Ό
    private int role;				// κΆν

    public void encodingPassword(PasswordEncoder passwordEncoder) {
        if (StringUtils.isEmpty(password)) {
            return;
        }
        password = passwordEncoder.encode(password);
    }

}
