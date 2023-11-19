package com.kopo.wise.domain.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kopo.wise.common.dto.SearchDto;
import com.kopo.wise.common.paging.Pagination;
import com.kopo.wise.common.paging.PagingResponse;
import com.kopo.wise.domain.reply.ReplyResponse;
import com.kopo.wise.domain.reply.ReplyService;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
	
    private final PostMapper postMapper;
    private final ReplyService replyService;

  
    @Transactional
    public Long savePost(final PostRequest params,long memberId) {
        postMapper.save(params);
        return params.getId();
    }

 
    public PostResponse findPostById(final Long id) {
    	PostResponse post = postMapper.findById(id);
    	List<ReplyResponse> replies = replyService.findPostId(id);
    	post.setReplies(replies);
        return post;
    }

    @Transactional
    public Long updatePost(final PostRequest params, long id) {
        postMapper.update(params);
        return params.getId();
    }
    
    

    public Long deletePost(final Long postId,long loginId) {
        postMapper.deleteById(postId);
        return postId;
    }


    
    
    public PagingResponse<PostResponse> findAllPost(final SearchDto params) {

        // 조건?�� ?��?��?��?�� ?��?��?���? ?��?�� 경우, ?��?�� ?��?��?��?�� 비어?��?�� 리스?��?? null?�� ?��?�� 반환
        int count = postMapper.postCount(params);
        if (count < 1) {
            return new PagingResponse<>(Collections.emptyList(), null);
        }

        // Pagination 객체�? ?��?��?��?�� ?��?���? ?���? 계산 ?�� SearchDto ???��?�� 객체?�� params?�� 계산?�� ?��?���? ?���? ???��
        Pagination pagination = new Pagination(count, params);
        params.setPagination(pagination);

        // 계산?�� ?��?���? ?��보의 ?���?(limitStart, recordSize)�? 기�??���? 리스?�� ?��?��?�� 조회 ?�� ?��?�� ?��?��?�� 반환
        List<PostResponse> list = postMapper.findAll(params);
        return new PagingResponse<>(list, pagination);
    }
 
    
    

}
