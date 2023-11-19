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

        // μ‘°κ±΄? ?΄?Ή?? ?°?΄?°κ°? ?? κ²½μ°, ??΅ ?°?΄?°? λΉμ΄?? λ¦¬μ€?Έ?? null? ?΄? λ°ν
        int count = postMapper.postCount(params);
        if (count < 1) {
            return new PagingResponse<>(Collections.emptyList(), null);
        }

        // Pagination κ°μ²΄λ₯? ??±?΄? ??΄μ§? ? λ³? κ³μ° ? SearchDto ???? κ°μ²΄?Έ params? κ³μ°? ??΄μ§? ? λ³? ???₯
        Pagination pagination = new Pagination(count, params);
        params.setPagination(pagination);

        // κ³μ°? ??΄μ§? ? λ³΄μ ?ΌλΆ?(limitStart, recordSize)λ₯? κΈ°μ??Όλ‘? λ¦¬μ€?Έ ?°?΄?° μ‘°ν ? ??΅ ?°?΄?° λ°ν
        List<PostResponse> list = postMapper.findAll(params);
        return new PagingResponse<>(list, pagination);
    }
 
    
    

}
