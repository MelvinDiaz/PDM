package com.example.gamescoreinfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

const val SCORE_TEAM_A = "scoreTeamA"
const val SCORE_TEAM_B = "scoreTeamB"

/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment() {
    private var scoreTeamA: Int = 0
    private var scoreTeamB: Int = 0

    private var displayTeamA: TextView? = null
    private var displayTeamB: TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState != null) {
            scoreTeamA = savedInstanceState.getInt(SCORE_TEAM_A, 0)
            scoreTeamB = savedInstanceState.getInt(SCORE_TEAM_B, 0)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        displayTeamA = view.findViewById(R.id.text_view_score_team_a)
        displayTeamB = view.findViewById(R.id.text_view_score_team_b)
        val buttonTeamA = view.findViewById<TextView>(R.id.button_team_a)
        val buttonTeamB = view.findViewById<TextView>(R.id.button_team_b)

        buttonTeamA.setOnClickListener {
            scoreTeamA++
            displayTeamA?.text = scoreTeamA.toString()
        }

        buttonTeamB.setOnClickListener {
            scoreTeamB++
            displayTeamB?.text = scoreTeamB.toString()
        }
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(SCORE_TEAM_A, scoreTeamA)
        outState.putInt(SCORE_TEAM_B, scoreTeamB)
    }


/*
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(SCORE_TEAM_A, scoreTeamA)
        outState.putInt(SCORE_TEAM_B, scoreTeamB)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        savedInstanceState?.let {
            scoreTeamA = it.getInt(SCORE_TEAM_A, 0)
            scoreTeamB = it.getInt(SCORE_TEAM_B, 0)
        }
    }
*/

}