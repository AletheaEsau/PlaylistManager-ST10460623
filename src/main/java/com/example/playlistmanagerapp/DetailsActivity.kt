package com.example.playlistmanagerapp


import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class DetailsActivity : AppCompatActivity() {
    private lateinit var resultText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        resultText = findViewById(R.id.resultText)
        findViewById<Button>(R.id.btnShowSongs).setOnClickListener {
            val builder = StringBuilder()
            for (song in Playlist.songs) {
                builder.append("Title: ${song.title}\nArtist: ${song.artist}/nRating: ${song.rating}\nComment: ${song.comment}\n\n")
            }
        }
        findViewById<Button>(R.id.btnAvgRating).setOnClickListener {
            if (Playlist.songs.isNotEmpty()){
                var sum = 0
                for (song in Playlist.songs){
                    sum += song.rating
                }

            }
        }
        findViewById<Button>(R.id.btnBack).setOnClickListener {
            finish()
        }
    }
}