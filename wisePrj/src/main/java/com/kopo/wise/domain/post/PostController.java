
package com.kopo.wise.domain.post;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.kopo.wise.common.dto.SearchDto;
import com.kopo.wise.common.file.FileUtils;
import com.kopo.wise.common.paging.PagingResponse;
import com.kopo.wise.domain.file.FileRequest;
import com.kopo.wise.domain.file.FileResponse;
import com.kopo.wise.domain.file.FileService;
import com.kopo.wise.domain.user.UserResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequiredArgsConstructor
public class PostController {

	private final PostService postService;
	private final FileUtils fileUtils;
	private final FileService fileService;

	@Value("${uploadPath}")
	private String uploadPath;

	private Map<String, Object> queryParamsToMap(final SearchDto queryParams) {
		Map<String, Object> data = new HashMap<>();
		data.put("page", queryParams.getPage());
		data.put("recordSize", queryParams.getRecordSize());
		data.put("pageSize", queryParams.getPageSize());
		data.put("keyword", queryParams.getKeyword());
		data.put("searchType", queryParams.getSearchType());
		return data;
	}

	@GetMapping("/posts")
	public PagingResponse<PostResponse> openPostList(final SearchDto params, Model model) {
		PagingResponse<PostResponse> response = postService.findAllPost(params);
		return response;
	}

	@GetMapping("/post/view.do")
	public PostResponse openPostView(@RequestParam final Long id, Model model) {
		PostResponse post = postService.findPostById(id);
		return post;
	}

	@PostMapping("/post/save.do")
	public String savePost(final PostRequest params, HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		UserResponse loginMember = (UserResponse) session.getAttribute("loginMember");
		long memberId = loginMember.getId();
		Long id = postService.savePost(params, memberId);
		List<FileRequest> files = fileUtils.uploadFiles(params.getFiles());
		fileService.saveFiles(id, files);
		return "성공";
	}

	@PostMapping("/post/update.do")
	public String updatePost(final PostRequest params, HttpServletRequest request) {
		String result = "";
		HttpSession session = request.getSession();
		UserResponse loginMember = (UserResponse) session.getAttribute("loginMember");
		String memberId = loginMember.getName();
		int role = loginMember.getRole();
		if (memberId.equals(params.getWriter()) || role == 1) {
			long id = loginMember.getId();

			postService.updatePost(params, id);

			List<FileRequest> uploadFiles = fileUtils.uploadFiles(params.getFiles());

			fileService.saveFiles(params.getId(), uploadFiles);

			List<FileResponse> deleteFiles = fileService.findAllFileByIds(params.getRemoveFileIds());

			fileUtils.deleteFiles(deleteFiles);

			fileService.deleteAllFileByIds(params.getRemoveFileIds());

			result = "성공";
			return result;
		} else {
			result = "실패";
			return result;
		}
	}

	@PostMapping("/post/delete.do")
	public String deletePost(@RequestParam("id") Long postId, @RequestParam("writer") String postWriter,
			 HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		String result = "";
		UserResponse loginMember = (UserResponse) session.getAttribute("loginMember");
		String memberId = loginMember.getLoginId();
		int role = loginMember.getRole();
		long id = loginMember.getId();
		if (memberId.equals(postWriter) || role == 1) {
			postService.deletePost(postId, id);

			result = "성공";
			return result;
		} else {
			result = "실패";
			return result;
		}
	}

}