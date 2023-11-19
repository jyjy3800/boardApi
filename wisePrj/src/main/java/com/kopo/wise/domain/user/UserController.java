//package com.kopo.wise.domain.user;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PatchMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//@Controller
//@RequiredArgsConstructor
//public class UserController {
//
//	private final UserService memberService;
//
//
//	@GetMapping("/login.do")
//	public String openNeedLogin() {
//
//		return "member/login";
//	}
//
//	@GetMapping("/loginneed.do")
//	public String openLogin(Model model) {
//		model.addAttribute("status", "Î°úÍ∑∏?ù∏?ù¥ ?ïÑ?öî?ïú ?éò?ù¥Ïß??ûÖ?ãà?ã§.");
//		return "member/login";
//	}
//
//	@PostMapping("/login")
//	@ResponseBody
//	public UserResponse login(HttpServletRequest request, HttpServletResponse response) {
//
//		String loginId = request.getParameter("loginId");
//		String password = request.getParameter("password");
//		UserResponse member = memberService.login(loginId, password);
//		Long memberId = member.getId();
//		
//		HttpSession session = request.getSession();
//		UserResponse loginMember = (UserResponse) session.getAttribute("loginMember");
//		if (loginMember != null) {
//			UserLogIn.logout(memberId); 
//			session.invalidate(); 
//		}
//
//		if (member != null) {
//
//			HttpSession newSession = request.getSession(true);
//			newSession.setAttribute("loginMember", member);
//			newSession.setMaxInactiveInterval(60 * 30);
//		}
//		return member;
//	}
//
//	@PostMapping("/logout")
//	public String logout(HttpSession session) {
//		UserResponse loginMember = (UserResponse) session.getAttribute("loginMember");
//		if (loginMember != null) {
//			Long memberId = loginMember.getId();
//			UserLogIn.logout(memberId);
//		}
//		session.invalidate();
//		return "redirect:/";
//	}
//
//	@PostMapping("/members")
//	@ResponseBody
//	public Long saveMember(@RequestBody final UserRequest params) {		
//		return memberService.saveMember(params);
//	}
//
//	@GetMapping("/members/{loginId}")
//	@ResponseBody
//	public UserResponse findMemberByLoginId(@PathVariable final String loginId) {
//		return memberService.findMemberByLoginId(loginId);
//	}
//
//	@PatchMapping("/members/{id}")
//	@ResponseBody
//	public Long updateMember(@PathVariable final Long id, HttpServletRequest request,@RequestBody final UserRequest params) {
//		HttpSession session = request.getSession();
//		UserResponse loginMember = (UserResponse) session.getAttribute("loginMember");
//		int role = loginMember.getRole();
//		if (role == 1) {
//			return memberService.updateMember(params);
//		} else {
//			System.out.println("Í∂åÌïú ?óÜ?ùå");
//			return id + 1;		
//		}
//		
//	}
//
//	@DeleteMapping("/members/{id}")
//	@ResponseBody
//	public Long deleteMemberById(@PathVariable final Long id, HttpServletRequest request, Model model) {
//		System.out.println(id);
//		HttpSession session = request.getSession();
//		UserResponse loginMember = (UserResponse) session.getAttribute("loginMember");
//		int role = loginMember.getRole();
//		if (role == 1) {
//			return memberService.deleteMemberById(id);
//		} else {
//			System.out.println("Í∂åÌïú ?óÜ?ùå");
//			return id + 1;		
//		}
//
//	}
//
//	@GetMapping("/member-count")
//	@ResponseBody
//	public int countMemberByLoginId(@RequestParam final String loginId) {
//		return memberService.countMemberByLoginId(loginId);
//	}
//
//}
