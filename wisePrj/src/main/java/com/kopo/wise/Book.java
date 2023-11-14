package com.kopo.wise;


import java.util.Objects;

import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Alias("book")
public class Book {
	private Long id;

	private String title;

	private String writer;

	private String publisher;

	private String year;

	private String stockTry;

	private int stock;

	private String genre;

	private MultipartFile picture;

	private String explain;

	private String imageUrl;
	
	public Book() {
		
	}

	@Builder(builderMethodName = "bookValidBuilder")
	public Book(String title, String writer, String publisher, String year, String stockTry, String genre) {

		this.title = title;
		this.writer = writer;
		this.publisher = publisher;
		this.year = year;
		this.stockTry = stockTry;
		this.genre = genre;

	}


	@Builder(builderMethodName = "bookBuilder")
	public Book(String title, String writer, String publisher, String year,  String genre) {

		this.title = title;
		this.writer = writer;
		this.publisher = publisher;
		this.year = year;

	}
	
	
	@Override
	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (o == null || getClass() != o.getClass()) return false;
	    Book book = (Book) o;
	    return Objects.equals(title, book.title) &&
	           Objects.equals(writer, book.writer) &&
	           Objects.equals(publisher, book.publisher) &&
	           Objects.equals(year, book.year) &&
	           Objects.equals(genre, book.genre);
	}


	@Override
	public int hashCode() {
	    return Objects.hash(title, writer, publisher, year, genre);
	}
	

}
