package com.kopo.wise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Service;



@Service
public class BookService {


	public BoardResponse<Book> findAllBook(final SearchDto params) {

		// 조건에 해당하는 데이터가 없는 경우, 응답 데이터에 비어있는 리스트와 null을 담아 반환
		int count = 10;
		if (count < 1) {
			return new BoardResponse<>(Collections.emptyList(), null);
		}

		// Pagination 객체를 생성해서 페이지 정보 계산 후 SearchDto 타입의 객체인 params에 계산된 페이지 정보 저장
		Pagination pagination = new Pagination(count, params);
		params.setPagination(pagination);

		// 계산된 페이지 정보의 일부(limitStart, recordSize)를 기준으로 리스트 데이터 조회 후 응답 데이터 반환
		List<Book> list = new ArrayList<>();
		Book bookRow = Book.bookValidBuilder().title("bookname").writer("writer")
				.publisher("publisher").year("year")
				.stockTry("stockString").genre("genre").build();
		Book bookRo = Book.bookValidBuilder().title("bookame").writer("wrter")
				.publisher("puhe").year("yea")
				.stockTry("sting").genre("gnre").build();
		list.add(bookRo);list.add(bookRow);
		return new BoardResponse<>(list, pagination);
	}
}
