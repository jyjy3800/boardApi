package com.kopo.wise.domain.post;

import org.apache.ibatis.annotations.Mapper;

import com.kopo.wise.common.dto.SearchDto;

import java.util.List;

@Mapper
public interface PostMapper {

    /**
     * ê²Œì‹œê¸? ???¥
     *
     * @param params - ê²Œì‹œê¸? ? •ë³?
     */
    void save(PostRequest params);

    /**
     * ê²Œì‹œê¸? ì¡°íšŒ?ˆ˜ ì¦ê?
     *
     * @param id - PK
     */   
    void increaseViewCount(Long id);
    
    
    
    /**
     * ê²Œì‹œê¸? ?ƒ?„¸? •ë³? ì¡°íšŒ
     *
     * @param id - PK
     * @return ê²Œì‹œê¸? ?ƒ?„¸? •ë³?
     */    
    PostResponse findById(Long id);
    
   

    /**
     * ê²Œì‹œê¸? ?ˆ˜? •
     *
     * @param params - ê²Œì‹œê¸? ? •ë³?
     */
    void update(PostRequest params);

    /**
     * ê²Œì‹œê¸? ?‚­? œ
     *
     * @param id - PK
     */
    void deleteById(Long id);

    /**
     * ê²Œì‹œê¸? ë¦¬ìŠ¤?Š¸ ì¡°íšŒ
     *
     * @return ê²Œì‹œê¸? ë¦¬ìŠ¤?Š¸
     */
    List<PostResponse> findAll(SearchDto params);

    /**
     * ê²Œì‹œê¸? ê³µì? ì¡°íšŒ
     *
     * @param id - PK
     * @return ê²Œì‹œê¸? ?ƒ?„¸? •ë³?
     */    
    List<PostResponse> findNotice(SearchDto params);
    
    /**
     * ê²Œì‹œê¸? ì¡°íšŒ?ˆ˜ Best20
     *
     * @param id - PK
     * @return ê²Œì‹œê¸? ?ƒ?„¸? •ë³?
     */    
    List<PostResponse> findBest(SearchDto params);
    
    
    /**
     * ê²Œì‹œê¸? ì¢‹ì•„?š”?ˆ˜ Best20
     *
     * @param id - PK
     * @return ê²Œì‹œê¸? ?ƒ?„¸? •ë³?
     */    
    List<PostResponse> findBestLike(SearchDto params);
    
    /**
     * ì¢‹ì•„?š” ?ˆ„ë¥? ê²ƒë§Œ ë³´ê¸°
     *
     * @param id - PK
     * @return ê²Œì‹œê¸? ?ƒ?„¸? •ë³?
     */    
    List<PostResponse> findLike(SearchDto params);
    
    /**
     * ?‚´ê°? ?“´ ê²ƒë§Œ ë³´ê¸°
     *
     * @param id - PK
     * @return ê²Œì‹œê¸? ?ƒ?„¸? •ë³?
     */    
    List<PostResponse> findMine(SearchDto params);
    
    
    /**
     * ê³µì? ?ˆ˜ ì¹´ìš´?Œ…
     *
     * @return ê²Œì‹œê¸? ?ˆ˜
     */
    int noticeCount(SearchDto params);
    
    /**
     * ê²Œì‹œê¸? ?ˆ˜ ì¹´ìš´?Œ…
     *
     * @return ê²Œì‹œê¸? ?ˆ˜
     */
    int postCount(SearchDto params);
    
    /**
     * ì¢‹ì•„?š” ?ˆ„ë¥? ê²Œì‹œê¸? ?ˆ˜ ì¹´ìš´?Œ…
     *
     * @return ê²Œì‹œê¸? ?ˆ˜
     */
    int likeCount(SearchDto params);
    
    /**
     * ì¢‹ì•„?š” ?ˆ„ë¥? ê²Œì‹œê¸? ?ˆ˜ ì¹´ìš´?Œ…
     *
     * @return ê²Œì‹œê¸? ?ˆ˜
     */
    int mineCount(SearchDto params);
    

}
