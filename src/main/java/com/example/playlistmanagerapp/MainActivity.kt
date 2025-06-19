//ST10460623-Alethea Esau
package com.example.playlistmanagerapp


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

data class Song(
    val title: String,
    val artist: String,
    val rating: Int,
    val comment: String

)

object Playlist{
    val songs = mutableListOf<Song>()
}

class MainActivity : AppCompatActivity() {
    private lateinit var titleInput: EditText
    private lateinit var artistInput: EditText
    private lateinit var ratingInput: EditText
    private lateinit var commentInput: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        titleInput = findViewById(R.id.titleInput)
        artistInput = findViewById(R.id.artistInput)
        ratingInput = findViewById(R.id.ratingInput)
        commentInput = findViewById(R.id.commentInput)

        findViewById<Button>(R.id.btnAdd).setOnClickListener {

            val title = titleInput.text.toString()
            val artist = artistInput.text.toString()
            val rating = ratingInput.text.toString().toIntOrNull()
            val comment = commentInput.text.toString()

            if(title.isNotEmpty() && artist.isNotEmpty() && rating != null && rating in 1..5) {
                Playlist.songs.add(Song(title,artist, rating, comment))
                Toast.makeText(this, "Song added!", Toast.LENGTH_SHORT).show()
                titleInput.text.clear()
                artistInput.text.clear()
                ratingInput.text.clear()
                commentInput.text.clear()
            } else {
                Toast.makeText(this, "Invalid input!", Toast.LENGTH_SHORT).show()
            }
        }

       val goToDetailsButton = findViewById<Button>(R.id.btnGoToDetails)
        goToDetailsButton.setOnClickListener {
           val intent = Intent(this,DetailsActivity::class.java)
            startActivity(intent)
        }
        findViewById<Button>(R.id.btnExit).setOnClickListener {
            finish()
        }
    }
}
