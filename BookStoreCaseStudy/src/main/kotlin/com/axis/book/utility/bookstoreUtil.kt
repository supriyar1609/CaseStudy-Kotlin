package com.axis.book.utility
import com.axis.app.dbConnection
import com.axis.book.model.Book
import com.axis.book.service.bookstoreService
import java.util.Scanner


class bookstoreUtil {
    var dbConnection=dbConnection()
    var connection=dbConnection.connect()

    var scanner=Scanner(System.`in`)

    //var book= mutableListOf<Book>()

    //add Book
    fun addBook(book: Book): Int {
        val addbook=connection.prepareStatement("Insert into BookStore value(?,?,?,?,?)")
        addbook.setString(1,book.bookID)
        addbook.setString(2,book.title)
        addbook.setString(3,book.author)
        addbook.setString(4,book.category)
        addbook.setDouble(5,book.price)

       val result=addbook.executeUpdate()
        return result

    }

    fun deleteBook(deletebookID:String):Int{
        val deletebook= connection.prepareStatement("delete from bookstore where bookID=?")
        deletebook.setString(1, deletebookID)
        val result=deletebook.executeUpdate()
        return result

    }

    fun displayAll():MutableList<Book>{
        var books= mutableListOf<Book>()
        val query = connection.prepareStatement("select * from bookstore")
        val result = query.executeQuery()

        while(result.next()){
            val bookId = result.getString("bookID")
            val Title= result.getString("Title")
            val Author= result.getString("Author")
            val Category= result.getString("Category")
            val Price=result.getDouble("Price")
            books.add(Book(bookId,Title,Author,Category,Price))
        }
        return books

    }
    fun display(bookId:String):MutableList<Book>{
        var books= mutableListOf<Book>()
        var display=connection.prepareStatement("select * from bookstore where bookID=?")
        display.setString(1,bookId)
        var result=display.executeQuery()
        while(result.next()){
            val bookId = result.getString("bookId")
            val Title= result.getString("Title")
            val Author= result.getString("Author")
            val Category= result.getString("Category")
            val Price=result.getDouble("Price")
            books.add(Book(bookId,Title,Author,Category,Price))
        }
        return books
    }

    fun searchbyTitle(title:String):MutableList<Book>{
        var books= mutableListOf<Book>()
        var bytitle=connection.prepareStatement("select * from bookstore where bookID=?")
        bytitle.setString(1,title)
        var result=bytitle.executeQuery()
        while(result.next()){
            val bookId = result.getString("bookId")
            val Title= result.getString("Title")
            val Author= result.getString("Author")
            val Category= result.getString("Category")
            val Price=result.getDouble("Price")
            books.add(Book(bookId,Title,Author,Category,Price))
        }
        return books
    }

    fun searchbyAuthor(author:String):MutableList<Book>{
        var books= mutableListOf<Book>()
        var byauthor=connection.prepareStatement("select * from bookstore where bookID=?")
        byauthor.setString(1,author)
        var result=byauthor.executeQuery()
        while(result.next()){
            val bookId = result.getString("bookId")
            val Title= result.getString("Title")
            val Author= result.getString("Author")
            val Category= result.getString("Category")
            val Price=result.getDouble("Price")
            books.add(Book(bookId,Title,Author,Category,Price))
        }
        return books
    }

    fun updateBook(bookId:String,updatedValue:String):Int{
        val update=connection.prepareStatement("update bookstore set bookID=? where bookId=?")
        update.setString(1,updatedValue)
        update.setString(2,bookId)

        var rows=update.executeUpdate()
        return rows

    }





}