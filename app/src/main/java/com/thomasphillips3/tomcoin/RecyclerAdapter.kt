package com.thomasphillips3.tomcoin

import android.content.Intent
import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(private val blocks: ArrayList<Block>):
RecyclerView.Adapter<RecyclerAdapter.BlockHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerAdapter.BlockHolder {
        val inflatedView = parent.inflate(R.layout.fragment_blockchain, false)
        return BlockHolder(inflatedView)
    }

    override fun getItemCount(): Int {
        return blocks.size
    }

    override fun onBindViewHolder(holder: BlockHolder, position: Int) {
        TODO("Not yet implemented")
    }

    class BlockHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {
        private var view: View = v
        private var block: Block? = null

        init {
            v.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val context = itemView.context
            val showBlockIntent = Intent(context, BlockchainFragment::class.java)
            showBlockIntent.putExtra(BLOCK_KEY, block.toString())
            context.startActivity(showBlockIntent)
        }

        companion object {
            private val BLOCK_KEY = "BLOCK"
        }
    }
}

