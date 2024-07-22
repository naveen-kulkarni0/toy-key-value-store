package com.example.kv.repository

import java.sql.ResultSet
import java.time.Instant


fun add(key:String, value:String, expiryAt:Long?=null){
        val query = "INSERT INTO backend (id, value, expiry_at) " +
                "VALUES (?, ?, ?) " +
                "ON DUPLICATE KEY UPDATE value = VALUES(value), expiry_at = VALUES(expiry_at)"
        val ps = getConnection.prepareStatement(query)
        ps.setString(1,key)
        ps.setString(2,value)
        if (expiryAt != null) {
            ps.setLong(3,expiryAt)
        }
        ps.execute()
}

fun get(key:String):String?{
        val query = "select value from backend where id=(?) and expiry_at > (?)"
        val ps = getConnection.prepareStatement(query)
        ps.setString(1,key)
        ps.setLong(2, Instant.now().epochSecond)
        val resultSet: ResultSet = ps.executeQuery()
        if(resultSet.next()){
            return resultSet.getString("value")
        }
        return null
}

fun delete(key:String){
    add(key,"null", Instant.now().epochSecond)
}
