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

        fab.setOnClickListener { view ->
            val block1 = Block.create(previousHash = "0", data = "first block data")
            val block2 = Block.create(previousHash = block1.toString().hash(), data = "second block data")
            val block3 = Block.create(previousHash = block2.toString().hash(), data = "third block data")

            blockchain.add(block1)
            blockchain.add(block2)
            blockchain.add(block3)

            Log.d(this.localClassName.toString(), "blockchain: ${blockchain.toString()}")
            Snackbar.make(view, block3.toString(), Snackbar.LENGTH_LONG)
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
