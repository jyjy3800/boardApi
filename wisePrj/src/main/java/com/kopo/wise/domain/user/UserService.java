//package com.kopo.wise.domain.user;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//
//@Service
//@RequiredArgsConstructor
//public class UserService {
//
//    private final UserMapper memberMapper;
//    private final PasswordEncoder passwordEncoder;
//    
//    
//
//
//    /**
//     * λ‘κ·Έ?Έ
//     * @param loginId - λ‘κ·Έ?Έ ID
//     * @param password - λΉλ?λ²νΈ
//     * @return ?? ??Έ? λ³?
//     */
//    public UserResponse login(final String loginId, final String password) {
//
//        // 1. ?? ? λ³? λ°? λΉλ?λ²νΈ μ‘°ν
//        UserResponse member = findMemberByLoginId(loginId);
//        String encodedPassword = (member == null) ? "" : member.getPassword();
//
//        // 2. ?? ? λ³? λ°? λΉλ?λ²νΈ μ²΄ν¬
//        if (member == null || passwordEncoder.matches(password, encodedPassword) == false) {
//            return null;
//        }
//
//        // 3. ?? ??΅ κ°μ²΄?? λΉλ?λ²νΈλ₯? ? κ±°ν ? ?? ? λ³? λ¦¬ν΄  
//        member.clearPassword();
//        return member;
//    }
//
//    /**
//     * ?? ? λ³? ???₯ (??κ°??)
//     * @param params - ?? ? λ³?
//     * @return PK
//     */
//    @Transactional
//    public Long saveMember(final UserRequest params) {
//        params.encodingPassword(passwordEncoder);
//        memberMapper.save(params);
//        return params.getId();
//    }
//
//    /**
//     * ?? ??Έ? λ³? μ‘°ν
//     * @param loginId - UK
//     * @return ?? ??Έ? λ³?
//     */
//    public UserResponse findMemberByLoginId(final String loginId) {
//        return memberMapper.findByLoginId(loginId);
//    }
//
//    /**
//     * ?? ? λ³? ?? 
//     * @param params - ?? ? λ³?
//     * @return PK
//     */
//    @Transactional
//    public Long updateMember(final UserRequest params) {
//       
//        memberMapper.update(params);
//        return params.getId();
//    }
//
//    /**
//     * ?? ? λ³? ?­?  (?? ??΄)
//     * @param id - PK
//     * @return PK
//     */
//    @Transactional
//    public Long deleteMemberById(final Long id) {
//        memberMapper.deleteById(id);
//        return id;
//    }
//
//
//    /**
//     * ?? ? μΉ΄μ΄? (ID μ€λ³΅ μ²΄ν¬)
//     * @param loginId - UK
//     * @return ?? ?
//     */
//    public int countMemberByLoginId(final String loginId) {
//        return memberMapper.countByLoginId(loginId);
//    }
//
//}
