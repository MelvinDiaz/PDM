package com.example.gamescoreinfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        savedInstanceState?.let {
            scoreTeamA = it.getInt("scoreTeamA", )
            scoreTeamB = it.getInt("scoreTeamB", )
        }


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
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
        outState.putInt("scoreTeamA", scoreTeamA)
        outState.putInt("scoreTeamB", scoreTeamB)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        savedInstanceState?.let {
            scoreTeamA = it.getInt("scoreTeamA", 0)
            scoreTeamB = it.getInt("scoreTeamB", 0)
        }
    }
}