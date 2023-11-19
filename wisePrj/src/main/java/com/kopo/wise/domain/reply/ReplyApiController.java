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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kopo.wise.domain.user.UserResponse;

@RestController
@RequiredArgsConstructor
public class ReplyApiController {

	
	private final ReplyService replyService; 
	
	// 신규 댓글 생성
		@PostMapping("/posts/replys/save.do")
		public ReplyResponse saveReply(@RequestParam Long postId, @RequestBody final ReplyRequest params) {
			Long id = replyService.saveReply(params);
			return replyService.findReplyById(id);
		}

		

		// 댓글 상세정보 조회
		@GetMapping("/posts/replys")
		public ReplyResponse findReplyById(@RequestParam("postId")  Long postId, @RequestParam("id") final Long id) {
			return replyService.findReplyById(id);
		}

		// 기존 댓글 수정
		@PostMapping("/posts/replys/update.do")
		public int updateReply(HttpServletRequest request,@RequestParam("id")  Long id, @RequestBody final ReplyRequest params) {
			HttpSession session = request.getSession();
			UserResponse loginMember = (UserResponse) session.getAttribute("loginMember");
			String memberId = loginMember.getLoginId();
			int role = loginMember.getRole();
			System.out.println("이거랑 " + params.getWriter());
			System.out.println("이거랑 " + memberId);
			if (params.getWriter().equals(memberId) || role == 1) {
				replyService.updateReply(params);
				return 1;
			} else
				return 0;	
		}

		// 댓글 삭제
		@PostMapping("/posts/replys/delete.do")
		public int deleteReply(HttpServletRequest request,@RequestParam("id") Long id, @RequestBody final ReplyRequest params) {
			HttpSession session = request.getSession();
			UserResponse loginMember = (UserResponse) session.getAttribute("loginMember");
			String memberId = loginMember.getLoginId();
			int role = loginMember.getRole();		
			if (params.getWriter().equals(memberId) || role == 1) {
				replyService.deleteReply(id);
				return 1;
			} else
				return 0;

		}

}
