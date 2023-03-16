package com.example.clase03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ScoreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        if (intent != null) {
            intent.extras?.apply {
                val scoreTeamA = getInt(MainActivity.TEAM_A_SCORE)
                val scoreTeamB = getInt(MainActivity.TEAM_B_SCORE)
                findViewById<TextView>(R.id.display_score).apply {
                    text = getString(R.string.text_result, scoreTeamA, scoreTeamB)
                }
            }
        }

    }

    companion object {
        const val TAG = "com.example.clase03.ScoreActivity"
    }
}