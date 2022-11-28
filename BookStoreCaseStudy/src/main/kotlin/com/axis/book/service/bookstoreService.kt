package com.axis.book.service
import com.axis.book.Exception.InvalidBookException
import com.axis.book.model.Book
import com.axis.book.utility.bookstoreUtil
import java.util.*

class bookstoreService {
    var bookUtil =bookstoreUtil()

    fun addBook(book: Book){
        bookUtil.addBook(book)
    }

    fun updateBook(bookID:String, updateValue:String):Int{
        var result=bookUtil.updateBook(bookID, updateValue)
        return result
    }

    fun deleteBook(deletebookID:String):Int{
        var delete=bookUtil.deleteBook(deletebookID)
        return delete
    }

    fun displayAll():MutableList<Book>{
       return bookUtil.displayAll()
    }

    fun displayBook(bookID: String):MutableList<Book>{
        return bookUtil.display(bookID)
    }

    fun searchbyTitle(title:String):MutableList<Book>{
       return bookUtil.searchbyTitle(title)
    }

    fun searchbyAuthor(author:String):MutableList<Book>{
       return bookUtil.searchbyAuthor(author)
    }

    fun sortByName():List<Book>{
        return bookUtil.displayAll().sortedBy { it.price }
    }


    }

