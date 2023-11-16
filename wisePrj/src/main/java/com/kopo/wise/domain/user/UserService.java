package com.kopo.wise.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper memberMapper;
    private final PasswordEncoder passwordEncoder;
    
    


    /**
     * ë¡œê·¸?¸
     * @param loginId - ë¡œê·¸?¸ ID
     * @param password - ë¹„ë?ë²ˆí˜¸
     * @return ?šŒ?› ?ƒ?„¸? •ë³?
     */
    public UserResponse login(final String loginId, final String password) {

        // 1. ?šŒ?› ? •ë³? ë°? ë¹„ë?ë²ˆí˜¸ ì¡°íšŒ
        UserResponse member = findMemberByLoginId(loginId);
        String encodedPassword = (member == null) ? "" : member.getPassword();

        // 2. ?šŒ?› ? •ë³? ë°? ë¹„ë?ë²ˆí˜¸ ì²´í¬
        if (member == null || passwordEncoder.matches(password, encodedPassword) == false) {
            return null;
        }

        // 3. ?šŒ?› ?‘?‹µ ê°ì²´?—?„œ ë¹„ë?ë²ˆí˜¸ë¥? ? œê±°í•œ ?›„ ?šŒ?› ? •ë³? ë¦¬í„´  
        member.clearPassword();
        return member;
    }

    /**
     * ?šŒ?› ? •ë³? ???¥ (?šŒ?›ê°??…)
     * @param params - ?šŒ?› ? •ë³?
     * @return PK
     */
    @Transactional
    public Long saveMember(final UserRequest params) {
        params.encodingPassword(passwordEncoder);
        memberMapper.save(params);
        return params.getId();
    }

    /**
     * ?šŒ?› ?ƒ?„¸? •ë³? ì¡°íšŒ
     * @param loginId - UK
     * @return ?šŒ?› ?ƒ?„¸? •ë³?
     */
    public UserResponse findMemberByLoginId(final String loginId) {
        return memberMapper.findByLoginId(loginId);
    }

    /**
     * ?šŒ?› ? •ë³? ?ˆ˜? •
     * @param params - ?šŒ?› ? •ë³?
     * @return PK
     */
    @Transactional
    public Long updateMember(final UserRequest params) {
       
        memberMapper.update(params);
        return params.getId();
    }

    /**
     * ?šŒ?› ? •ë³? ?‚­? œ (?šŒ?› ?ƒˆ?‡´)
     * @param id - PK
     * @return PK
     */
    @Transactional
    public Long deleteMemberById(final Long id) {
        memberMapper.deleteById(id);
        return id;
    }


    /**
     * ?šŒ?› ?ˆ˜ ì¹´ìš´?Œ… (ID ì¤‘ë³µ ì²´í¬)
     * @param loginId - UK
     * @return ?šŒ?› ?ˆ˜
     */
    public int countMemberByLoginId(final String loginId) {
        return memberMapper.countByLoginId(loginId);
    }

}
