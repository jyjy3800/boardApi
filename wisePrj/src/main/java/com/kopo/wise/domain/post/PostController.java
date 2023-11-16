//
//package com.kopo.wise.domain.post;
//
//import lombok.RequiredArgsConstructor;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import com.dish.common.dto.MessageDto;
//import com.dish.common.dto.SearchDto;
//import com.dish.common.file.FileUtils;
//import com.dish.common.paging.PagingResponse;
//import com.dish.domain.file.FileRequest;
//import com.dish.domain.file.FileResponse;
//import com.dish.domain.file.FileService;
//import com.dish.domain.history.HistoryService;
//import com.dish.domain.member.MemberResponse;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
//@Controller
//@RequiredArgsConstructor
//public class PostController {
//
//	private final PostService postService;
//	private final FileService fileService;
//	private final FileUtils fileUtils;
//	
//	
//	@Value("${uploadPath}")
//	private String uploadPath;
//
//	private String showMessageAndRedirect(final MessageDto params, Model model) {
//		model.addAttribute("params", params);
//		return "common/messageRedirect";
//	}
//
//	private Map<String, Object> queryParamsToMap(final SearchDto queryParams) {
//		Map<String, Object> data = new HashMap<>();
//		data.put("page", queryParams.getPage());
//		data.put("recordSize", queryParams.getRecordSize());
//		data.put("pageSize", queryParams.getPageSize());
//		data.put("keyword", queryParams.getKeyword());
//		data.put("searchType", queryParams.getSearchType());
//		return data;
//	}
//
//	@GetMapping("/post/write.do")
//	public String openPostWrite(@RequestParam(value = "id", required = false) final Long id, Model model) {
//		if (id != null) {
//			PostResponse post = postService.findPostById(id);
//			model.addAttribute("post", post);
//		}
//		return "post/write";
//	}
//
//	@GetMapping("/post/notice.do")
//	public String openNoticeList(@ModelAttribute("params") final SearchDto params, Model model) {
//		PagingResponse<PostResponse> response = postService.findNotice(params);
//		model.addAttribute("response", response);
//		return "post/notice";
//	}
//
//	@GetMapping("/")
//	public String openPostList(@ModelAttribute("params") final SearchDto params, Model model) {
//		PagingResponse<PostResponse> response = postService.findAllPost(params);
//		model.addAttribute("response", response);		
//		return "post/list";
//	}
//
//// Î≤†Ïä§?ä∏ 20 ?éò?ù¥Ïß?
//	@GetMapping("/post/bestview.do")
//	public String openBestList(@ModelAttribute("params") final SearchDto params, Model model) {
//		PagingResponse<PostResponse> response = postService.findBest(params);
//
//		model.addAttribute("response", response);
//		model.addAttribute("title", "Ï°∞Ìöå?àò BEST 20");
//		model.addAttribute("sub", "Ï¢ãÏïÑ?öî BEST 20");
//		model.addAttribute("change", "bestlike");
//		model.addAttribute("this", "best");
//
//		return "post/list";
//	}
//
//	@GetMapping("/post/bestlike.do")
//	public String openBestLike(@ModelAttribute("params") final SearchDto params, Model model) {
//		PagingResponse<PostResponse> response = postService.findBestLIke(params);
//		model.addAttribute("response", response);
//		model.addAttribute("title", "Ï¢ãÏïÑ?öî BEST 20");
//		model.addAttribute("sub", "Ï°∞Ìöå?àò BEST 20");
//		model.addAttribute("change", "bestview");
//		model.addAttribute("this", "best");
//
//		return "post/list";
//	}
//
//	@GetMapping("/post/mypost.do")
//	public String openLikeList(HttpServletRequest request, @ModelAttribute("params") final SearchDto params,
//			Model model) {
//		HttpSession session = request.getSession();
//		UserResponse loginMember = (UserResponse) session.getAttribute("loginMember");
//		Long memberId = loginMember.getId();
//		params.setMemberId(memberId);
//		PagingResponse<PostResponse> response = postService.findMyPost(params, memberId);
//		model.addAttribute("response", response);
//		return "post/list";
//	}
//
//	@GetMapping("/post/like.do")
//	public String openMyList(HttpServletRequest request, @ModelAttribute("params") final SearchDto params,
//			Model model) {
//		HttpSession session = request.getSession();
//		UserResponse loginMember = (UserResponse) session.getAttribute("loginMember");
//		Long memberId = loginMember.getId();
//
//		PagingResponse<PostResponse> response = postService.findLikePost(params, memberId);
//		model.addAttribute("response", response);
//		return "post/list";
//
//	}
//
//	@GetMapping("/post/view.do")
//	public String openPostView(@RequestParam final Long id, Model model) {
//		PostResponse post = postService.findPostById(id);
//		model.addAttribute("post", post);
//		return "post/view";
//	}
//
//	@PostMapping("/post/save.do")
//	public String savePost(final PostRequest params, HttpServletRequest request, Model model) {
//		HttpSession session = request.getSession();
//		UserResponse loginMember = (UserResponse) session.getAttribute("loginMember");
//		long memberId = loginMember.getId();
//		Long id = postService.savePost(params,memberId);
//		List<FileRequest> files = fileUtils.uploadFiles(params.getFiles());
//		fileService.saveFiles(id, files);
//				
//		
//		
//		MessageDto message = new MessageDto("Í≤åÏãúÍ∏? ?Éù?Ñ±?ù¥ ?ôÑÎ£åÎêò?óà?äµ?ãà?ã§.", "/", RequestMethod.GET, null);
//		return showMessageAndRedirect(message, model);
//	}
//
//	@PostMapping("/post/update.do")
//	public String updatePost(final PostRequest params, final SearchDto queryParams, HttpServletRequest request,
//			Model model) {
//
//		HttpSession session = request.getSession();
//		UserResponse loginMember = (UserResponse) session.getAttribute("loginMember");
//		String memberId = loginMember.getName();
//		int role = loginMember.getRole();
//		if (memberId.equals(params.getWriter()) || role == 1) {
//			// 1. Í≤åÏãúÍ∏? ?†ïÎ≥? ?àò?†ï
//			long id = loginMember.getId() ;
//			
//			postService.updatePost(params, id);
//
//			// 2. ?åå?ùº ?óÖÎ°úÎìú (to disk)
//			List<FileRequest> uploadFiles = fileUtils.uploadFiles(params.getFiles());
//
//			// 3. ?åå?ùº ?†ïÎ≥? ???û• (to database)
//			fileService.saveFiles(params.getId(), uploadFiles);
//
//			// 4. ?Ç≠?†ú?ï† ?åå?ùº ?†ïÎ≥? Ï°∞Ìöå (from database)
//			List<FileResponse> deleteFiles = fileService.findAllFileByIds(params.getRemoveFileIds());
//
//			// 5. ?åå?ùº ?Ç≠?†ú (from disk)
//			fileUtils.deleteFiles(deleteFiles);
//
//			// 6. ?åå?ùº ?Ç≠?†ú (from database)
//			fileService.deleteAllFileByIds(params.getRemoveFileIds());
//
//			MessageDto message = new MessageDto("Í≤åÏãúÍ∏? ?àò?†ï?ù¥ ?ôÑÎ£åÎêò?óà?äµ?ãà?ã§.", "/", RequestMethod.GET,
//					queryParamsToMap(queryParams));
//			return showMessageAndRedirect(message, model);
//		} else {
//			MessageDto message = new MessageDto("Í∂åÌïú?ù¥ ?óÜ?äµ?ãà?ã§.", "/", RequestMethod.GET,
//					queryParamsToMap(queryParams));
//			return showMessageAndRedirect(message, model);
//		}
//	}
//
//	@PostMapping("/post/delete.do")
//	public String deletePost(@RequestParam("id") Long postId, 
//			@RequestParam("writer") String postWriter,
//			final SearchDto queryParams, HttpServletRequest request, Model model) {
//		HttpSession session = request.getSession();
//		UserResponse loginMember = (UserResponse) session.getAttribute("loginMember");
//		String memberId = loginMember.getLoginId();		
//		int role = loginMember.getRole();
//		long id = loginMember.getId();
//		if (memberId.equals(postWriter) || role == 1) {
//			postService.deletePost(postId,id);
//			
//			MessageDto message = new MessageDto("Í≤åÏãúÍ∏? ?Ç≠?†úÍ∞? ?ôÑÎ£åÎêò?óà?äµ?ãà?ã§.", "/", RequestMethod.GET,
//					queryParamsToMap(queryParams));
//			return showMessageAndRedirect(message, model);
//		} else {
//			MessageDto message = new MessageDto("Í∂åÌïú?ù¥ ?óÜ?äµ?ãà?ã§.", "/", RequestMethod.GET,
//					queryParamsToMap(queryParams));
//			return showMessageAndRedirect(message, model);
//		}
//	}
//
//}