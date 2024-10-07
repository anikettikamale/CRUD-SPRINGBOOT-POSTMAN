package com.springboot.web;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
	@Autowired
	private BookService  bookService;
	
@GetMapping("/books")
	public List<Book> getBooks()
	{
		return this.bookService.getAllBooks();
	}

	@GetMapping("/books/{id}")
	public Book getBook(@PathVariable int id)
	{
		return bookService.getBookById(id);
	}
	
@PostMapping("/books")	
public Book addBook(@RequestBody Book book)
{
Book b=this.bookService.addBook(book);
return b;
} 

@DeleteMapping("/books/{bookId}")
public void  deleteBook(@PathVariable int bookId)
{
	this.bookService.deleteBook(bookId);
}

@PutMapping("/books/{bookId}")
  public Book updateBook(@RequestBody Book book,@PathVariable int bookId)
  {
	this.bookService.updateBook(book,bookId);
	return book;
  }
    // id would not change remaining data can be updated  

}
