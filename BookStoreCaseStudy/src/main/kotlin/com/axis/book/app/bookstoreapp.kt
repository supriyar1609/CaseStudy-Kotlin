package com.axis.book.app
import com.axis.book.model.Book
import com.axis.book.service.bookstoreService
import java.util.*
import com.axis.book.Exception.InvalidBookException


fun main() {
    var bookService = bookstoreService()


    var validate = Validate()
    var scanner=Scanner(System.`in`)

    println("Menu")
    println("""1.Add Book  2.Modify Book 3.Delete Book  4.Display All Books  5.Display Specific Book 6.Search Book by Title 7.Search Book by Author 8.sortByName9.exit """)
    println("Enter Choice")
    var choice=scanner.nextInt()
    while(choice<10) {
        when (choice) {
            1 -> {

                //add book
                println("Enter bookID")
                var bookID = scanner.next()
                try {

                    //validating  book id
                    validate.validateBookId(bookID)
                } catch (e: InvalidBookException) {
                    println(e.message)
                }

                println("Enter Title")
                var title: String = scanner.next()

                println("Enter Author")
                var author: String = scanner.next()

                println("enter Category")
                var category = scanner.next()
                try {
                    //validating category
                    validate.validateCategory(category)
                } catch (e: InvalidBookException) {
                    println(e.message)
                }

                println("Enter Price ")
                var price = scanner.nextDouble()
                try {
                    //validating price
                    validate.validatePrice(price)
                } catch (e: InvalidBookException) {
                    println(e.message)
                }

                var book = Book(bookID, title, author, category, price)
                var resultRows = bookService.addBook(book)
              /*  if (resultRows>0)
                    println("Book is inserted")
                else
                    println("Book is not inserted")*/

            }

            2 -> {

                // update/modify book id
                println("enter book id to update")
                var bookId = scanner.next()
                println("enter updated value")
                var updatedValue = scanner.next()
                var result = bookService.updateBook(bookId, updatedValue)
                if (result > 0) println("updated successfully")
                else println("book not found")

            }

            3 -> {
                //delete a specific book
                println("Enter bookId to delete")
                var deleteBookId = scanner.next()
                var result = bookService.deleteBook(deleteBookId)
                if (result > 0) println("book deleted successfully")
                else println("book not found")
            }

            4 -> {
                //display all books
                var books = bookService.displayAll()
                for (book in books) {
                    println(book)
                }

            }

            5 -> {
                //display specific book details
                println("enter book id to display")
                var bookId = scanner.next()
                var bookList = bookService.displayBook(bookId)
                var length = bookList.size
                if (length > 0) {
                    for (book in bookList) {
                        println(book)
                    }
                } else {
                    println("Book not found")
                }

            }

            6 -> {
                //Search Book by Title
                println("enter  book title to search")
                var bookTitle = scanner.next()
                var bookTitleBooks = bookService.searchbyTitle(bookTitle)
                var length = bookTitleBooks.size
                if (length > 0) {
                    for (book in bookTitleBooks) {
                        println(book)
                    }
                } else {
                    println("book not found")
                }
            }

            7 -> {
                //search book by author
                println("enter  book Author to search")
                var bookAuthor = scanner.next()
                var bookAuthorBooks = bookService.searchbyAuthor(bookAuthor)
                var length = bookAuthorBooks.size
                if (length > 0) {
                    for (book in bookAuthorBooks) {
                        println(book)
                    }
                } else {
                    println("book not found")
                }
            }

            8 -> {
                var sortedBooksbyName = bookService.sortByName()
                for (book in sortedBooksbyName) {
                    println(book)
                }
            }

            9 -> {
                //exit
                System.exit(0)
            }
        }

        println("process completed, enter choice to continue")
        println(
            "1.Add Book \n2.Modify Book \n3.Delete Book \n4.Display All Books \n5.Display Specific Book"
                    + "\n6.Search Book by Title \n7.Search Book by Author\n8.sort by price\n9.Exit"
        );

        var ch = scanner.nextInt()
        choice = ch

    }

}


