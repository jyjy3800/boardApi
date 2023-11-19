//package com.kopo.wise.domain.user;
//
//import org.apache.ibatis.annotations.Mapper;
//
//@Mapper
//public interface UserMapper {
//
//    /**
//     * ?��?�� ?���? ???�� (?��?���??��)
//     * @param params - ?��?�� ?���?
//     */
//    void save(UserRequest params);
//
//    /**
//     * ?��?�� ?��?��?���? 조회
//     * @param loginId - UK
//     * @return ?��?�� ?��?��?���?
//     */
//    UserResponse findByLoginId(String loginId);
//
//    /**
//     * ?��?�� ?���? ?��?��
//     * @param params - ?��?�� ?���?
//     */
//    void update(UserRequest params);
//
//    /**
//     * ?��?�� ?���? ?��?�� (?��?�� ?��?��)
//     * @param id - PK
//     */
//    void deleteById(Long id);
//
//    /**
//     * ?��?�� ?�� 카운?�� (ID 중복 체크)
//     * @param loginId - UK
//     * @return ?��?�� ?��
//     */
//    int countByLoginId(String loginId);
//
//}
