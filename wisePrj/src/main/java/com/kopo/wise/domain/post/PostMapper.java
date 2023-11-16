//package com.kopo.wise.domain.post;
//
//import org.apache.ibatis.annotations.Mapper;
//
//import com.dish.common.dto.SearchDto;
//
//import java.util.List;
//
//@Mapper
//public interface PostMapper {
//
//    /**
//     * κ²μκΈ? ???₯
//     *
//     * @param params - κ²μκΈ? ? λ³?
//     */
//    void save(PostRequest params);
//
//    /**
//     * κ²μκΈ? μ‘°ν? μ¦κ?
//     *
//     * @param id - PK
//     */   
//    void increaseViewCount(Long id);
//    
//    
//    
//    /**
//     * κ²μκΈ? ??Έ? λ³? μ‘°ν
//     *
//     * @param id - PK
//     * @return κ²μκΈ? ??Έ? λ³?
//     */    
//    PostResponse findById(Long id);
//    
//   
//
//    /**
//     * κ²μκΈ? ?? 
//     *
//     * @param params - κ²μκΈ? ? λ³?
//     */
//    void update(PostRequest params);
//
//    /**
//     * κ²μκΈ? ?­? 
//     *
//     * @param id - PK
//     */
//    void deleteById(Long id);
//
//    /**
//     * κ²μκΈ? λ¦¬μ€?Έ μ‘°ν
//     *
//     * @return κ²μκΈ? λ¦¬μ€?Έ
//     */
//    List<PostResponse> findAll(SearchDto params);
//
//    /**
//     * κ²μκΈ? κ³΅μ? μ‘°ν
//     *
//     * @param id - PK
//     * @return κ²μκΈ? ??Έ? λ³?
//     */    
//    List<PostResponse> findNotice(SearchDto params);
//    
//    /**
//     * κ²μκΈ? μ‘°ν? Best20
//     *
//     * @param id - PK
//     * @return κ²μκΈ? ??Έ? λ³?
//     */    
//    List<PostResponse> findBest(SearchDto params);
//    
//    
//    /**
//     * κ²μκΈ? μ’μ?? Best20
//     *
//     * @param id - PK
//     * @return κ²μκΈ? ??Έ? λ³?
//     */    
//    List<PostResponse> findBestLike(SearchDto params);
//    
//    /**
//     * μ’μ? ?λ₯? κ²λ§ λ³΄κΈ°
//     *
//     * @param id - PK
//     * @return κ²μκΈ? ??Έ? λ³?
//     */    
//    List<PostResponse> findLike(SearchDto params);
//    
//    /**
//     * ?΄κ°? ?΄ κ²λ§ λ³΄κΈ°
//     *
//     * @param id - PK
//     * @return κ²μκΈ? ??Έ? λ³?
//     */    
//    List<PostResponse> findMine(SearchDto params);
//    
//    
//    /**
//     * κ³΅μ? ? μΉ΄μ΄?
//     *
//     * @return κ²μκΈ? ?
//     */
//    int noticeCount(SearchDto params);
//    
//    /**
//     * κ²μκΈ? ? μΉ΄μ΄?
//     *
//     * @return κ²μκΈ? ?
//     */
//    int postCount(SearchDto params);
//    
//    /**
//     * μ’μ? ?λ₯? κ²μκΈ? ? μΉ΄μ΄?
//     *
//     * @return κ²μκΈ? ?
//     */
//    int likeCount(SearchDto params);
//    
//    /**
//     * μ’μ? ?λ₯? κ²μκΈ? ? μΉ΄μ΄?
//     *
//     * @return κ²μκΈ? ?
//     */
//    int mineCount(SearchDto params);
//    
//
//}
