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
//     * ê²Œì‹œê¸? ???¥
//     * @param params - ê²Œì‹œê¸? ? •ë³?
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
//     * ê²Œì‹œê¸? ?ƒ?„¸? •ë³? ì¡°íšŒ
//     * @param id - PK
//     * @return ê²Œì‹œê¸? ?ƒ?„¸? •ë³?
//     */
//    public PostResponse findPostById(final Long id) {
//    	postMapper.increaseViewCount(id);
//        return postMapper.findById(id);
//    }
//
//    /**
//     * ê²Œì‹œê¸? ?ˆ˜? •
//     * @param params - ê²Œì‹œê¸? ? •ë³?
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
//     * ê²Œì‹œê¸? ?‚­? œ
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
//     * ê²Œì‹œê¸? ë¦¬ìŠ¤?Š¸ ì¡°íšŒ
//     * @param params - search conditions
//     * @return list & pagination information
//     */
//    
//    
//    public PagingResponse<PostResponse> findAllPost(final SearchDto params) {
//
//        // ì¡°ê±´?— ?•´?‹¹?•˜?Š” ?°?´?„°ê°? ?—†?Š” ê²½ìš°, ?‘?‹µ ?°?´?„°?— ë¹„ì–´?ˆ?Š” ë¦¬ìŠ¤?Š¸?? null?„ ?‹´?•„ ë°˜í™˜
//        int count = postMapper.postCount(params);
//        if (count < 1) {
//            return new PagingResponse<>(Collections.emptyList(), null);
//        }
//
//        // Pagination ê°ì²´ë¥? ?ƒ?„±?•´?„œ ?˜?´ì§? ? •ë³? ê³„ì‚° ?›„ SearchDto ???…?˜ ê°ì²´?¸ params?— ê³„ì‚°?œ ?˜?´ì§? ? •ë³? ???¥
//        Pagination pagination = new Pagination(count, params);
//        params.setPagination(pagination);
//
//        // ê³„ì‚°?œ ?˜?´ì§? ? •ë³´ì˜ ?¼ë¶?(limitStart, recordSize)ë¥? ê¸°ì??œ¼ë¡? ë¦¬ìŠ¤?Š¸ ?°?´?„° ì¡°íšŒ ?›„ ?‘?‹µ ?°?´?„° ë°˜í™˜
//        List<PostResponse> list = postMapper.findAll(params);
//        return new PagingResponse<>(list, pagination);
//    }
//    
//    public PagingResponse<PostResponse> findNotice(final SearchDto params) {
//
//        // ì¡°ê±´?— ?•´?‹¹?•˜?Š” ?°?´?„°ê°? ?—†?Š” ê²½ìš°, ?‘?‹µ ?°?´?„°?— ë¹„ì–´?ˆ?Š” ë¦¬ìŠ¤?Š¸?? null?„ ?‹´?•„ ë°˜í™˜
//        int count = postMapper.noticeCount(params);
//        if (count < 1) {
//            return new PagingResponse<>(Collections.emptyList(), null);
//        }
//
//        // Pagination ê°ì²´ë¥? ?ƒ?„±?•´?„œ ?˜?´ì§? ? •ë³? ê³„ì‚° ?›„ SearchDto ???…?˜ ê°ì²´?¸ params?— ê³„ì‚°?œ ?˜?´ì§? ? •ë³? ???¥
//        Pagination pagination = new Pagination(count, params);
//        params.setPagination(pagination);
//
//        // ê³„ì‚°?œ ?˜?´ì§? ? •ë³´ì˜ ?¼ë¶?(limitStart, recordSize)ë¥? ê¸°ì??œ¼ë¡? ë¦¬ìŠ¤?Š¸ ?°?´?„° ì¡°íšŒ ?›„ ?‘?‹µ ?°?´?„° ë°˜í™˜
//        List<PostResponse> list = postMapper.findNotice(params);
//        return new PagingResponse<>(list, pagination);
//    }
//    
//    public PagingResponse<PostResponse> findBest(final SearchDto params) {
//
//        // ì¡°ê±´?— ?•´?‹¹?•˜?Š” ?°?´?„°ê°? ?—†?Š” ê²½ìš°, ?‘?‹µ ?°?´?„°?— ë¹„ì–´?ˆ?Š” ë¦¬ìŠ¤?Š¸?? null?„ ?‹´?•„ ë°˜í™˜
//        int count = postMapper.postCount(params);;
//        if (count < 1) {
//            return new PagingResponse<>(Collections.emptyList(), null);
//        }else if (count>20) {
//        	count = 20;
//        }
//        // Pagination ê°ì²´ë¥? ?ƒ?„±?•´?„œ ?˜?´ì§? ? •ë³? ê³„ì‚° ?›„ SearchDto ???…?˜ ê°ì²´?¸ params?— ê³„ì‚°?œ ?˜?´ì§? ? •ë³? ???¥
//        Pagination pagination = new Pagination(count, params);
//        params.setPagination(pagination);
//
//        // ê³„ì‚°?œ ?˜?´ì§? ? •ë³´ì˜ ?¼ë¶?(limitStart, recordSize)ë¥? ê¸°ì??œ¼ë¡? ë¦¬ìŠ¤?Š¸ ?°?´?„° ì¡°íšŒ ?›„ ?‘?‹µ ?°?´?„° ë°˜í™˜
//        List<PostResponse> list = postMapper.findBest(params);
//        return new PagingResponse<>(list, pagination);
//    }
//    
//    public PagingResponse<PostResponse> findBestLIke(final SearchDto params) {
//
//        // ì¡°ê±´?— ?•´?‹¹?•˜?Š” ?°?´?„°ê°? ?—†?Š” ê²½ìš°, ?‘?‹µ ?°?´?„°?— ë¹„ì–´?ˆ?Š” ë¦¬ìŠ¤?Š¸?? null?„ ?‹´?•„ ë°˜í™˜
//        int count = postMapper.postCount(params);;
//        if (count < 1) {
//            return new PagingResponse<>(Collections.emptyList(), null);
//        }else if (count>20) {
//        	count = 20;
//        }
//        // Pagination ê°ì²´ë¥? ?ƒ?„±?•´?„œ ?˜?´ì§? ? •ë³? ê³„ì‚° ?›„ SearchDto ???…?˜ ê°ì²´?¸ params?— ê³„ì‚°?œ ?˜?´ì§? ? •ë³? ???¥
//        Pagination pagination = new Pagination(count, params);
//        params.setPagination(pagination);
//
//        // ê³„ì‚°?œ ?˜?´ì§? ? •ë³´ì˜ ?¼ë¶?(limitStart, recordSize)ë¥? ê¸°ì??œ¼ë¡? ë¦¬ìŠ¤?Š¸ ?°?´?„° ì¡°íšŒ ?›„ ?‘?‹µ ?°?´?„° ë°˜í™˜
//        List<PostResponse> list = postMapper.findBestLike(params);
//        return new PagingResponse<>(list, pagination);
//    }
//    
//    public PagingResponse<PostResponse> findLikePost(final SearchDto params, final Long memberId) {
//    	
//    	params.setMemberId(memberId);
//        // ì¡°ê±´?— ?•´?‹¹?•˜?Š” ?°?´?„°ê°? ?—†?Š” ê²½ìš°, ?‘?‹µ ?°?´?„°?— ë¹„ì–´?ˆ?Š” ë¦¬ìŠ¤?Š¸?? null?„ ?‹´?•„ ë°˜í™˜
//        int count = postMapper.likeCount(params);
//        
//        if (count < 1) {
//            return new PagingResponse<>(Collections.emptyList(), null);
//        }
//        // Pagination ê°ì²´ë¥? ?ƒ?„±?•´?„œ ?˜?´ì§? ? •ë³? ê³„ì‚° ?›„ SearchDto ???…?˜ ê°ì²´?¸ params?— ê³„ì‚°?œ ?˜?´ì§? ? •ë³? ???¥
//        Pagination pagination = new Pagination(count, params);
//        params.setPagination(pagination);
//        
//        // ê³„ì‚°?œ ?˜?´ì§? ? •ë³´ì˜ ?¼ë¶?(limitStart, recordSize)ë¥? ê¸°ì??œ¼ë¡? ë¦¬ìŠ¤?Š¸ ?°?´?„° ì¡°íšŒ ?›„ ?‘?‹µ ?°?´?„° ë°˜í™˜
//        List<PostResponse> list = postMapper.findLike(params);
//        return new PagingResponse<>(list, pagination);
//    }
//    
//public PagingResponse<PostResponse> findMyPost(final SearchDto params, final Long memberId) {
//    	
//    	
//        // ì¡°ê±´?— ?•´?‹¹?•˜?Š” ?°?´?„°ê°? ?—†?Š” ê²½ìš°, ?‘?‹µ ?°?´?„°?— ë¹„ì–´?ˆ?Š” ë¦¬ìŠ¤?Š¸?? null?„ ?‹´?•„ ë°˜í™˜
//        int count = postMapper.mineCount(params);
//        
//        if (count < 1) {
//            return new PagingResponse<>(Collections.emptyList(), null);
//        }
//        // Pagination ê°ì²´ë¥? ?ƒ?„±?•´?„œ ?˜?´ì§? ? •ë³? ê³„ì‚° ?›„ SearchDto ???…?˜ ê°ì²´?¸ params?— ê³„ì‚°?œ ?˜?´ì§? ? •ë³? ???¥
//        Pagination pagination = new Pagination(count, params);
//        params.setPagination(pagination);
//        params.setMemberId(memberId);
//       
//        // ê³„ì‚°?œ ?˜?´ì§? ? •ë³´ì˜ ?¼ë¶?(limitStart, recordSize)ë¥? ê¸°ì??œ¼ë¡? ë¦¬ìŠ¤?Š¸ ?°?´?„° ì¡°íšŒ ?›„ ?‘?‹µ ?°?´?„° ë°˜í™˜
//        List<PostResponse> list = postMapper.findMine(params);
//        return new PagingResponse<>(list, pagination);
//    }
//    
//    
//
//}
