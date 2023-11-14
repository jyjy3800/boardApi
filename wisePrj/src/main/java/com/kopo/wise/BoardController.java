package com.kopo.wise;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
public class BoardController {
	
	private final BookService bookService;
	
	
	
	@GetMapping("/")
	public BoardResponse<Book> jsonTest() {
		BookService bookService = new BookService();
		SearchDto params = new SearchDto();
		BoardResponse<Book> response = bookService.findAllBook(params);
		return response;
	}
	
	@GetMapping("/test")
	public String test() {
		return "test";
	}

}
