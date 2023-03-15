package com.example.clase03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView

//UI Elements
private lateinit var displayTeamA: TextView
private lateinit var displayTeamB: TextView
private lateinit var addOneTeamA: Button
private lateinit var addOneTeamB: Button
//private lateinit var gameOverButton: Button

//Data Elements
private var scoreTeamA = 0
private var scoreTeamB = 0


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()
        addEventListener()

    }

    private fun bind(){
        displayTeamA = findViewById(R.id.display_score_team_a_text_view)
        displayTeamB = findViewById(R.id.display_score_team_b_text_view)
        addOneTeamA = findViewById(R.id.add_one_team_a_button)
        addOneTeamB = findViewById(R.id.add_one_team_b_button)
        //gameOverButton = findViewById(R.id.game_over_action)
    }

    private fun addEventListener(){
        addOneTeamA.setOnClickListener {
            scoreTeamA++
            displayTeamA.text = scoreTeamA.toString()
        }

        addOneTeamB.setOnClickListener {
            scoreTeamB++
            displayTeamB.text = scoreTeamB.toString()
        }

        //gameOverButton.setOnClickListener {

        //}
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.apply {
            putInt(TEAM_A_SCORE, scoreTeamA)
            putInt(TEAM_B_SCORE, scoreTeamB) }
    }

    companion object {
        const val TEAM_A_SCORE = "TEAM_A_SCORE"
        const val TEAM_B_SCORE = "TEAM_B_SCORE"
    }
}