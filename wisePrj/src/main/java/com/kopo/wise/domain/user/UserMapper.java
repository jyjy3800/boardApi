//package com.kopo.wise.domain.user;
//
//import org.apache.ibatis.annotations.Mapper;
//
//@Mapper
//public interface UserMapper {
//
//    /**
//     * ?? ? λ³? ???₯ (??κ°??)
//     * @param params - ?? ? λ³?
//     */
//    void save(UserRequest params);
//
//    /**
//     * ?? ??Έ? λ³? μ‘°ν
//     * @param loginId - UK
//     * @return ?? ??Έ? λ³?
//     */
//    UserResponse findByLoginId(String loginId);
//
//    /**
//     * ?? ? λ³? ?? 
//     * @param params - ?? ? λ³?
//     */
//    void update(UserRequest params);
//
//    /**
//     * ?? ? λ³? ?­?  (?? ??΄)
//     * @param id - PK
//     */
//    void deleteById(Long id);
//
//    /**
//     * ?? ? μΉ΄μ΄? (ID μ€λ³΅ μ²΄ν¬)
//     * @param loginId - UK
//     * @return ?? ?
//     */
//    int countByLoginId(String loginId);
//
//}
