package com.example.kv.repository

import java.lang.RuntimeException
import java.sql.Connection
import java.sql.DriverManager.getConnection


private val connection = openConnection()
private fun openConnection(): Connection {
        val url = "jdbc:mysql://localhost:3306/demo"
        val user = "root"
        val password = "password"
        try {
            return getConnection(url, user, password)
        } catch (e: Exception) {
            e.printStackTrace()
            throw RuntimeException("Failed to open connection")
        }
}

// Getter for connection property
val getConnection: Connection
        get() = connection

