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

    private Long id;                // ?öå?õê Î≤àÌò∏ (PK)
    private String loginId;         // Î°úÍ∑∏?ù∏ ID
    private String password;        // ÎπÑÎ?Î≤àÌò∏
    private String name;            // ?ù¥Î¶?
    private LocalDate birthday;     // ?Éù?ÖÑ?õî?ùº
    private int role;				// Í∂åÌïú

    public void encodingPassword(PasswordEncoder passwordEncoder) {
        if (StringUtils.isEmpty(password)) {
            return;
        }
        password = passwordEncoder.encode(password);
    }

}
