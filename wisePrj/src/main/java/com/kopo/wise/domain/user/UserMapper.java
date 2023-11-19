//package com.kopo.wise.domain.user;
//
//import org.apache.ibatis.annotations.Mapper;
//
//@Mapper
//public interface UserMapper {
//
//    /**
//     * ?šŒ?› ? •ë³? ???¥ (?šŒ?›ê°??…)
//     * @param params - ?šŒ?› ? •ë³?
//     */
//    void save(UserRequest params);
//
//    /**
//     * ?šŒ?› ?ƒ?„¸? •ë³? ì¡°íšŒ
//     * @param loginId - UK
//     * @return ?šŒ?› ?ƒ?„¸? •ë³?
//     */
//    UserResponse findByLoginId(String loginId);
//
//    /**
//     * ?šŒ?› ? •ë³? ?ˆ˜? •
//     * @param params - ?šŒ?› ? •ë³?
//     */
//    void update(UserRequest params);
//
//    /**
//     * ?šŒ?› ? •ë³? ?‚­? œ (?šŒ?› ?ƒˆ?‡´)
//     * @param id - PK
//     */
//    void deleteById(Long id);
//
//    /**
//     * ?šŒ?› ?ˆ˜ ì¹´ìš´?Œ… (ID ì¤‘ë³µ ì²´í¬)
//     * @param loginId - UK
//     * @return ?šŒ?› ?ˆ˜
//     */
//    int countByLoginId(String loginId);
//
//}
