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
//     * 게시�? ???��
//     * @param params - 게시�? ?���?
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
//     * 게시�? ?��?��?���? 조회
//     * @param id - PK
//     * @return 게시�? ?��?��?���?
//     */
//    public PostResponse findPostById(final Long id) {
//    	postMapper.increaseViewCount(id);
//        return postMapper.findById(id);
//    }
//
//    /**
//     * 게시�? ?��?��
//     * @param params - 게시�? ?���?
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
//     * 게시�? ?��?��
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
//     * 게시�? 리스?�� 조회
//     * @param params - search conditions
//     * @return list & pagination information
//     */
//    
//    
//    public PagingResponse<PostResponse> findAllPost(final SearchDto params) {
//
//        // 조건?�� ?��?��?��?�� ?��?��?���? ?��?�� 경우, ?��?�� ?��?��?��?�� 비어?��?�� 리스?��?? null?�� ?��?�� 반환
//        int count = postMapper.postCount(params);
//        if (count < 1) {
//            return new PagingResponse<>(Collections.emptyList(), null);
//        }
//
//        // Pagination 객체�? ?��?��?��?�� ?��?���? ?���? 계산 ?�� SearchDto ???��?�� 객체?�� params?�� 계산?�� ?��?���? ?���? ???��
//        Pagination pagination = new Pagination(count, params);
//        params.setPagination(pagination);
//
//        // 계산?�� ?��?���? ?��보의 ?���?(limitStart, recordSize)�? 기�??���? 리스?�� ?��?��?�� 조회 ?�� ?��?�� ?��?��?�� 반환
//        List<PostResponse> list = postMapper.findAll(params);
//        return new PagingResponse<>(list, pagination);
//    }
//    
//    public PagingResponse<PostResponse> findNotice(final SearchDto params) {
//
//        // 조건?�� ?��?��?��?�� ?��?��?���? ?��?�� 경우, ?��?�� ?��?��?��?�� 비어?��?�� 리스?��?? null?�� ?��?�� 반환
//        int count = postMapper.noticeCount(params);
//        if (count < 1) {
//            return new PagingResponse<>(Collections.emptyList(), null);
//        }
//
//        // Pagination 객체�? ?��?��?��?�� ?��?���? ?���? 계산 ?�� SearchDto ???��?�� 객체?�� params?�� 계산?�� ?��?���? ?���? ???��
//        Pagination pagination = new Pagination(count, params);
//        params.setPagination(pagination);
//
//        // 계산?�� ?��?���? ?��보의 ?���?(limitStart, recordSize)�? 기�??���? 리스?�� ?��?��?�� 조회 ?�� ?��?�� ?��?��?�� 반환
//        List<PostResponse> list = postMapper.findNotice(params);
//        return new PagingResponse<>(list, pagination);
//    }
//    
//    public PagingResponse<PostResponse> findBest(final SearchDto params) {
//
//        // 조건?�� ?��?��?��?�� ?��?��?���? ?��?�� 경우, ?��?�� ?��?��?��?�� 비어?��?�� 리스?��?? null?�� ?��?�� 반환
//        int count = postMapper.postCount(params);;
//        if (count < 1) {
//            return new PagingResponse<>(Collections.emptyList(), null);
//        }else if (count>20) {
//        	count = 20;
//        }
//        // Pagination 객체�? ?��?��?��?�� ?��?���? ?���? 계산 ?�� SearchDto ???��?�� 객체?�� params?�� 계산?�� ?��?���? ?���? ???��
//        Pagination pagination = new Pagination(count, params);
//        params.setPagination(pagination);
//
//        // 계산?�� ?��?���? ?��보의 ?���?(limitStart, recordSize)�? 기�??���? 리스?�� ?��?��?�� 조회 ?�� ?��?�� ?��?��?�� 반환
//        List<PostResponse> list = postMapper.findBest(params);
//        return new PagingResponse<>(list, pagination);
//    }
//    
//    public PagingResponse<PostResponse> findBestLIke(final SearchDto params) {
//
//        // 조건?�� ?��?��?��?�� ?��?��?���? ?��?�� 경우, ?��?�� ?��?��?��?�� 비어?��?�� 리스?��?? null?�� ?��?�� 반환
//        int count = postMapper.postCount(params);;
//        if (count < 1) {
//            return new PagingResponse<>(Collections.emptyList(), null);
//        }else if (count>20) {
//        	count = 20;
//        }
//        // Pagination 객체�? ?��?��?��?�� ?��?���? ?���? 계산 ?�� SearchDto ???��?�� 객체?�� params?�� 계산?�� ?��?���? ?���? ???��
//        Pagination pagination = new Pagination(count, params);
//        params.setPagination(pagination);
//
//        // 계산?�� ?��?���? ?��보의 ?���?(limitStart, recordSize)�? 기�??���? 리스?�� ?��?��?�� 조회 ?�� ?��?�� ?��?��?�� 반환
//        List<PostResponse> list = postMapper.findBestLike(params);
//        return new PagingResponse<>(list, pagination);
//    }
//    
//    public PagingResponse<PostResponse> findLikePost(final SearchDto params, final Long memberId) {
//    	
//    	params.setMemberId(memberId);
//        // 조건?�� ?��?��?��?�� ?��?��?���? ?��?�� 경우, ?��?�� ?��?��?��?�� 비어?��?�� 리스?��?? null?�� ?��?�� 반환
//        int count = postMapper.likeCount(params);
//        
//        if (count < 1) {
//            return new PagingResponse<>(Collections.emptyList(), null);
//        }
//        // Pagination 객체�? ?��?��?��?�� ?��?���? ?���? 계산 ?�� SearchDto ???��?�� 객체?�� params?�� 계산?�� ?��?���? ?���? ???��
//        Pagination pagination = new Pagination(count, params);
//        params.setPagination(pagination);
//        
//        // 계산?�� ?��?���? ?��보의 ?���?(limitStart, recordSize)�? 기�??���? 리스?�� ?��?��?�� 조회 ?�� ?��?�� ?��?��?�� 반환
//        List<PostResponse> list = postMapper.findLike(params);
//        return new PagingResponse<>(list, pagination);
//    }
//    
//public PagingResponse<PostResponse> findMyPost(final SearchDto params, final Long memberId) {
//    	
//    	
//        // 조건?�� ?��?��?��?�� ?��?��?���? ?��?�� 경우, ?��?�� ?��?��?��?�� 비어?��?�� 리스?��?? null?�� ?��?�� 반환
//        int count = postMapper.mineCount(params);
//        
//        if (count < 1) {
//            return new PagingResponse<>(Collections.emptyList(), null);
//        }
//        // Pagination 객체�? ?��?��?��?�� ?��?���? ?���? 계산 ?�� SearchDto ???��?�� 객체?�� params?�� 계산?�� ?��?���? ?���? ???��
//        Pagination pagination = new Pagination(count, params);
//        params.setPagination(pagination);
//        params.setMemberId(memberId);
//       
//        // 계산?�� ?��?���? ?��보의 ?���?(limitStart, recordSize)�? 기�??���? 리스?�� ?��?��?�� 조회 ?�� ?��?�� ?��?��?�� 반환
//        List<PostResponse> list = postMapper.findMine(params);
//        return new PagingResponse<>(list, pagination);
//    }
//    
//    
//
//}
