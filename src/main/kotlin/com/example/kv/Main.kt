package com.example.kv

import com.example.kv.repository.add
import com.example.kv.repository.delete
import com.example.kv.repository.get
import java.time.Instant

fun main(){
    add("abc","cd", Instant.now().epochSecond + 3000)
    val res = get("abc")
    println("result is $res")

    delete("abc")
    val res1 = get("abc")
    println("result after delete $res1")
}