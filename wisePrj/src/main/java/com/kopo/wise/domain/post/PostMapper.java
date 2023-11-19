package com.kopo.wise.domain.post;

import org.apache.ibatis.annotations.Mapper;

import com.kopo.wise.common.dto.SearchDto;

import java.util.List;

@Mapper
public interface PostMapper {

    /**
     * 게시�? ???��
     *
     * @param params - 게시�? ?���?
     */
    void save(PostRequest params);

    /**
     * 게시�? 조회?�� 증�?
     *
     * @param id - PK
     */   
    void increaseViewCount(Long id);
    
    
    
    /**
     * 게시�? ?��?��?���? 조회
     *
     * @param id - PK
     * @return 게시�? ?��?��?���?
     */    
    PostResponse findById(Long id);
    
   

    /**
     * 게시�? ?��?��
     *
     * @param params - 게시�? ?���?
     */
    void update(PostRequest params);

    /**
     * 게시�? ?��?��
     *
     * @param id - PK
     */
    void deleteById(Long id);

    /**
     * 게시�? 리스?�� 조회
     *
     * @return 게시�? 리스?��
     */
    List<PostResponse> findAll(SearchDto params);

    /**
     * 게시�? 공�? 조회
     *
     * @param id - PK
     * @return 게시�? ?��?��?���?
     */    
    List<PostResponse> findNotice(SearchDto params);
    
    /**
     * 게시�? 조회?�� Best20
     *
     * @param id - PK
     * @return 게시�? ?��?��?���?
     */    
    List<PostResponse> findBest(SearchDto params);
    
    
    /**
     * 게시�? 좋아?��?�� Best20
     *
     * @param id - PK
     * @return 게시�? ?��?��?���?
     */    
    List<PostResponse> findBestLike(SearchDto params);
    
    /**
     * 좋아?�� ?���? 것만 보기
     *
     * @param id - PK
     * @return 게시�? ?��?��?���?
     */    
    List<PostResponse> findLike(SearchDto params);
    
    /**
     * ?���? ?�� 것만 보기
     *
     * @param id - PK
     * @return 게시�? ?��?��?���?
     */    
    List<PostResponse> findMine(SearchDto params);
    
    
    /**
     * 공�? ?�� 카운?��
     *
     * @return 게시�? ?��
     */
    int noticeCount(SearchDto params);
    
    /**
     * 게시�? ?�� 카운?��
     *
     * @return 게시�? ?��
     */
    int postCount(SearchDto params);
    
    /**
     * 좋아?�� ?���? 게시�? ?�� 카운?��
     *
     * @return 게시�? ?��
     */
    int likeCount(SearchDto params);
    
    /**
     * 좋아?�� ?���? 게시�? ?�� 카운?��
     *
     * @return 게시�? ?��
     */
    int mineCount(SearchDto params);
    

}
