package com.thomasphillips3.tomcoin

class Blockchain {
    private var blocks: MutableList<Block> = mutableListOf()

    fun add(block: Block) : Block {
        blocks.add(block)
        return block
    }
}