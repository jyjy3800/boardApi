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
     * 로그?��
     * @param loginId - 로그?�� ID
     * @param password - 비�?번호
     * @return ?��?�� ?��?��?���?
     */
    public UserResponse login(final String loginId, final String password) {

        // 1. ?��?�� ?���? �? 비�?번호 조회
        UserResponse member = findMemberByLoginId(loginId);
        String encodedPassword = (member == null) ? "" : member.getPassword();

        // 2. ?��?�� ?���? �? 비�?번호 체크
        if (member == null || passwordEncoder.matches(password, encodedPassword) == false) {
            return null;
        }

        // 3. ?��?�� ?��?�� 객체?��?�� 비�?번호�? ?��거한 ?�� ?��?�� ?���? 리턴  
        member.clearPassword();
        return member;
    }

    /**
     * ?��?�� ?���? ???�� (?��?���??��)
     * @param params - ?��?�� ?���?
     * @return PK
     */
    @Transactional
    public Long saveMember(final UserRequest params) {
        params.encodingPassword(passwordEncoder);
        memberMapper.save(params);
        return params.getId();
    }

    /**
     * ?��?�� ?��?��?���? 조회
     * @param loginId - UK
     * @return ?��?�� ?��?��?���?
     */
    public UserResponse findMemberByLoginId(final String loginId) {
        return memberMapper.findByLoginId(loginId);
    }

    /**
     * ?��?�� ?���? ?��?��
     * @param params - ?��?�� ?���?
     * @return PK
     */
    @Transactional
    public Long updateMember(final UserRequest params) {
       
        memberMapper.update(params);
        return params.getId();
    }

    /**
     * ?��?�� ?���? ?��?�� (?��?�� ?��?��)
     * @param id - PK
     * @return PK
     */
    @Transactional
    public Long deleteMemberById(final Long id) {
        memberMapper.deleteById(id);
        return id;
    }


    /**
     * ?��?�� ?�� 카운?�� (ID 중복 체크)
     * @param loginId - UK
     * @return ?��?�� ?��
     */
    public int countMemberByLoginId(final String loginId) {
        return memberMapper.countByLoginId(loginId);
    }

}
