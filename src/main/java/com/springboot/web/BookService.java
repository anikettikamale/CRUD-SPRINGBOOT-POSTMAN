package com.springboot.web;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
@Component
public class BookService {
private static List<Book> list=new ArrayList<>();	
	static
	{
		list.add(new Book(12,"java book","XYZ"));
		list.add(new Book(36,"c++ book","PQR"));
		list.add(new Book(113,"java222 book","LMN"));
	}
	public List<Book> getAllBooks()
	{
		return list;
	}
	
	public Book getBookById(int id)
	{
		Book book=null;
		book=list.stream().filter(e->e.getId()==id).findFirst().get();
	return book;
	}
	 
	// add the book
	public Book addBook(Book b)
	{
		list.add(b);
		return b;  
	}
	
	public void deleteBook(int bid)
	{
		list=list.stream().filter(book ->book.getId()!=bid).
		collect(Collectors.toList());
	}
	
	public void updateBook(Book book,int bookId)
	{
	list=list.stream().map(b->{
		if(b.getId()==bookId)
		{
			b.setTitle(book.getTitle());
			b.setAuthor(book.getAuthor());
		}
		return b;
	}).collect(Collectors.toList());
	}
}
