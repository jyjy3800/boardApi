//package com.kopo.wise.domain.post;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import com.dish.common.dto.SearchDto;
//import com.dish.common.paging.Pagination;
//import com.dish.common.paging.PagingResponse;
//import com.dish.domain.history.HistoryService;
//
//import javax.transaction.Transactional;
//import java.util.Collections;
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class PostService {
//	
//	private final HistoryService historyService;
//    private final PostMapper postMapper;
//
//    /**
//     * κ²μκΈ? ???₯
//     * @param params - κ²μκΈ? ? λ³?
//     * @return Generated PK
//     */
//    @Transactional
//    public Long savePost(final PostRequest params,long memberId) {
//        postMapper.save(params);
//        historyService.postSave(memberId);
//        return params.getId();
//    }
//
//    /**
//     * κ²μκΈ? ??Έ? λ³? μ‘°ν
//     * @param id - PK
//     * @return κ²μκΈ? ??Έ? λ³?
//     */
//    public PostResponse findPostById(final Long id) {
//    	postMapper.increaseViewCount(id);
//        return postMapper.findById(id);
//    }
//
//    /**
//     * κ²μκΈ? ?? 
//     * @param params - κ²μκΈ? ? λ³?
//     * @return PK
//     */
//    @Transactional
//    public Long updatePost(final PostRequest params, long id) {
//        postMapper.update(params);
//        historyService.postUpdate(id);
//        return params.getId();
//    }
//    
//    
//
//    /**
//     * κ²μκΈ? ?­? 
//     * @param id - PK
//     * @return PK
//     */
//    public Long deletePost(final Long postId,long loginId) {
//        postMapper.deleteById(postId);
//        historyService.postDelete(loginId);
//        return postId;
//    }
//
//    /**
//     * κ²μκΈ? λ¦¬μ€?Έ μ‘°ν
//     * @param params - search conditions
//     * @return list & pagination information
//     */
//    
//    
//    public PagingResponse<PostResponse> findAllPost(final SearchDto params) {
//
//        // μ‘°κ±΄? ?΄?Ή?? ?°?΄?°κ°? ?? κ²½μ°, ??΅ ?°?΄?°? λΉμ΄?? λ¦¬μ€?Έ?? null? ?΄? λ°ν
//        int count = postMapper.postCount(params);
//        if (count < 1) {
//            return new PagingResponse<>(Collections.emptyList(), null);
//        }
//
//        // Pagination κ°μ²΄λ₯? ??±?΄? ??΄μ§? ? λ³? κ³μ° ? SearchDto ???? κ°μ²΄?Έ params? κ³μ°? ??΄μ§? ? λ³? ???₯
//        Pagination pagination = new Pagination(count, params);
//        params.setPagination(pagination);
//
//        // κ³μ°? ??΄μ§? ? λ³΄μ ?ΌλΆ?(limitStart, recordSize)λ₯? κΈ°μ??Όλ‘? λ¦¬μ€?Έ ?°?΄?° μ‘°ν ? ??΅ ?°?΄?° λ°ν
//        List<PostResponse> list = postMapper.findAll(params);
//        return new PagingResponse<>(list, pagination);
//    }
//    
//    public PagingResponse<PostResponse> findNotice(final SearchDto params) {
//
//        // μ‘°κ±΄? ?΄?Ή?? ?°?΄?°κ°? ?? κ²½μ°, ??΅ ?°?΄?°? λΉμ΄?? λ¦¬μ€?Έ?? null? ?΄? λ°ν
//        int count = postMapper.noticeCount(params);
//        if (count < 1) {
//            return new PagingResponse<>(Collections.emptyList(), null);
//        }
//
//        // Pagination κ°μ²΄λ₯? ??±?΄? ??΄μ§? ? λ³? κ³μ° ? SearchDto ???? κ°μ²΄?Έ params? κ³μ°? ??΄μ§? ? λ³? ???₯
//        Pagination pagination = new Pagination(count, params);
//        params.setPagination(pagination);
//
//        // κ³μ°? ??΄μ§? ? λ³΄μ ?ΌλΆ?(limitStart, recordSize)λ₯? κΈ°μ??Όλ‘? λ¦¬μ€?Έ ?°?΄?° μ‘°ν ? ??΅ ?°?΄?° λ°ν
//        List<PostResponse> list = postMapper.findNotice(params);
//        return new PagingResponse<>(list, pagination);
//    }
//    
//    public PagingResponse<PostResponse> findBest(final SearchDto params) {
//
//        // μ‘°κ±΄? ?΄?Ή?? ?°?΄?°κ°? ?? κ²½μ°, ??΅ ?°?΄?°? λΉμ΄?? λ¦¬μ€?Έ?? null? ?΄? λ°ν
//        int count = postMapper.postCount(params);;
//        if (count < 1) {
//            return new PagingResponse<>(Collections.emptyList(), null);
//        }else if (count>20) {
//        	count = 20;
//        }
//        // Pagination κ°μ²΄λ₯? ??±?΄? ??΄μ§? ? λ³? κ³μ° ? SearchDto ???? κ°μ²΄?Έ params? κ³μ°? ??΄μ§? ? λ³? ???₯
//        Pagination pagination = new Pagination(count, params);
//        params.setPagination(pagination);
//
//        // κ³μ°? ??΄μ§? ? λ³΄μ ?ΌλΆ?(limitStart, recordSize)λ₯? κΈ°μ??Όλ‘? λ¦¬μ€?Έ ?°?΄?° μ‘°ν ? ??΅ ?°?΄?° λ°ν
//        List<PostResponse> list = postMapper.findBest(params);
//        return new PagingResponse<>(list, pagination);
//    }
//    
//    public PagingResponse<PostResponse> findBestLIke(final SearchDto params) {
//
//        // μ‘°κ±΄? ?΄?Ή?? ?°?΄?°κ°? ?? κ²½μ°, ??΅ ?°?΄?°? λΉμ΄?? λ¦¬μ€?Έ?? null? ?΄? λ°ν
//        int count = postMapper.postCount(params);;
//        if (count < 1) {
//            return new PagingResponse<>(Collections.emptyList(), null);
//        }else if (count>20) {
//        	count = 20;
//        }
//        // Pagination κ°μ²΄λ₯? ??±?΄? ??΄μ§? ? λ³? κ³μ° ? SearchDto ???? κ°μ²΄?Έ params? κ³μ°? ??΄μ§? ? λ³? ???₯
//        Pagination pagination = new Pagination(count, params);
//        params.setPagination(pagination);
//
//        // κ³μ°? ??΄μ§? ? λ³΄μ ?ΌλΆ?(limitStart, recordSize)λ₯? κΈ°μ??Όλ‘? λ¦¬μ€?Έ ?°?΄?° μ‘°ν ? ??΅ ?°?΄?° λ°ν
//        List<PostResponse> list = postMapper.findBestLike(params);
//        return new PagingResponse<>(list, pagination);
//    }
//    
//    public PagingResponse<PostResponse> findLikePost(final SearchDto params, final Long memberId) {
//    	
//    	params.setMemberId(memberId);
//        // μ‘°κ±΄? ?΄?Ή?? ?°?΄?°κ°? ?? κ²½μ°, ??΅ ?°?΄?°? λΉμ΄?? λ¦¬μ€?Έ?? null? ?΄? λ°ν
//        int count = postMapper.likeCount(params);
//        
//        if (count < 1) {
//            return new PagingResponse<>(Collections.emptyList(), null);
//        }
//        // Pagination κ°μ²΄λ₯? ??±?΄? ??΄μ§? ? λ³? κ³μ° ? SearchDto ???? κ°μ²΄?Έ params? κ³μ°? ??΄μ§? ? λ³? ???₯
//        Pagination pagination = new Pagination(count, params);
//        params.setPagination(pagination);
//        
//        // κ³μ°? ??΄μ§? ? λ³΄μ ?ΌλΆ?(limitStart, recordSize)λ₯? κΈ°μ??Όλ‘? λ¦¬μ€?Έ ?°?΄?° μ‘°ν ? ??΅ ?°?΄?° λ°ν
//        List<PostResponse> list = postMapper.findLike(params);
//        return new PagingResponse<>(list, pagination);
//    }
//    
//public PagingResponse<PostResponse> findMyPost(final SearchDto params, final Long memberId) {
//    	
//    	
//        // μ‘°κ±΄? ?΄?Ή?? ?°?΄?°κ°? ?? κ²½μ°, ??΅ ?°?΄?°? λΉμ΄?? λ¦¬μ€?Έ?? null? ?΄? λ°ν
//        int count = postMapper.mineCount(params);
//        
//        if (count < 1) {
//            return new PagingResponse<>(Collections.emptyList(), null);
//        }
//        // Pagination κ°μ²΄λ₯? ??±?΄? ??΄μ§? ? λ³? κ³μ° ? SearchDto ???? κ°μ²΄?Έ params? κ³μ°? ??΄μ§? ? λ³? ???₯
//        Pagination pagination = new Pagination(count, params);
//        params.setPagination(pagination);
//        params.setMemberId(memberId);
//       
//        // κ³μ°? ??΄μ§? ? λ³΄μ ?ΌλΆ?(limitStart, recordSize)λ₯? κΈ°μ??Όλ‘? λ¦¬μ€?Έ ?°?΄?° μ‘°ν ? ??΅ ?°?΄?° λ°ν
//        List<PostResponse> list = postMapper.findMine(params);
//        return new PagingResponse<>(list, pagination);
//    }
//    
//    
//
//}
