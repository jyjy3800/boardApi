package com.kopo.wise.domain.reply;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kopo.wise.domain.user.UserResponse;

@RestController
@RequiredArgsConstructor
public class RplyApiController {

	private final ReplyService commentService;
	



	@GetMapping("/posts/{postId}/comments")
	public Map<Long, List<ReplyResponse>> findAllComment(@PathVariable final Long postId) {
		 Map<Long, List<ReplyResponse>> result = commentService.findPostId(postId);
		 return result;
	}

	

	@PatchMapping("/posts/{postId}/comments/{id}")
	public int updateComment(HttpServletRequest request,@PathVariable final Long id, @RequestBody final ReplyRequest params) {
		HttpSession session = request.getSession();
		UserResponse loginMember = (UserResponse) session.getAttribute("loginMember");
		String writerId = loginMember.getLoginId();
		Long memberId = loginMember.getId();
		int role = loginMember.getRole();	
		if (params.getWriter().equals(writerId) || role == 1) {
			commentService.updateComment(params, memberId);
			
			return 1;
		} else
			return 0;	
	}

	@DeleteMapping("/posts/{postId}/comments/{id}")
	public int deleteComment(HttpServletRequest request,@PathVariable final Long id, @RequestBody final ReplyRequest params) {
		HttpSession session = request.getSession();
		UserResponse loginMember = (UserResponse) session.getAttribute("loginMember");
		String writerId = loginMember.getLoginId();
		Long memberId = loginMember.getId();
		int role = loginMember.getRole();		
		if (params.getWriter().equals(writerId) || role == 1) {
			commentService.deleteComment(id,memberId);			
			return 1;
		} else
			return 0;

	}

}
