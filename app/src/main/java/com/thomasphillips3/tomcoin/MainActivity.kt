package com.thomasphillips3.tomcoin

import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val blockchain = Blockchain()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val genesisBlock = Block.create(previousHash = "0", data = "first block data")
        blockchain.add(genesisBlock)

        fab.setOnClickListener { view ->
            val block = Block.create(previousHash = blockchain.previousHash().toString().hash(), data = "block data")
            blockchain.add(block)

            Log.d(this.localClassName.toString(), "blockchain: ${blockchain.toString()}")
            Snackbar.make(view, block.toString(), Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
