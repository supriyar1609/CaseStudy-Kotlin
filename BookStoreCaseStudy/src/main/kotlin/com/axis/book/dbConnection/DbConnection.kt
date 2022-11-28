package com.axis.app

import java.sql.Connection
import java.sql.DriverManager

class dbConnection {
    fun connect(): Connection {
        val dburl ="jdbc:mysql://localhost:3306/bookstoredb"
        val connection= DriverManager.getConnection(dburl,"root","supriya97")
        return connection
    }
}
