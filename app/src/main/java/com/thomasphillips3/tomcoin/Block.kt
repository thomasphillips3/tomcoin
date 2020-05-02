package com.thomasphillips3.tomcoin

import java.time.Instant

data class Block(
    val previousHash: String,
    val data: String,
    val timestamp: Long = Instant.now().toEpochMilli(),
    val nonce: Long = 0,
    var hash: String = ""
) {
    init { hash = calculateHash() }

    fun calculateHash(): String {
        return "$previousHash$data$timestamp$nonce".hash()
    }

    companion object {
        fun create(previousHash: String, data: String): Block {
            return Block(previousHash, data, Instant.now().toEpochMilli(), 0, "")
        }
    }
}
