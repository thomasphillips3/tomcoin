package com.thomasphillips3.tomcoin

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
        TODO("Not yet implemented")
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
            Log.d(this.toString(), "clicked")
        }

        companion object {
            private val BLOCK_KEY = "BLOCK"
        }
    }
}

