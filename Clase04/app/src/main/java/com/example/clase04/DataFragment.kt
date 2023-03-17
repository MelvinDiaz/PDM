package com.example.clase04

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_NAME = "param1"
private const val ARG_LASTNAME = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DataFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DataFragment : Fragment() {

    private var name: String? = null
    private var lastname: String? = null
    private var displayName: View? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            name = it.getString(ARG_NAME)
            lastname = it.getString(ARG_LASTNAME)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_data, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        displayName = view.findViewById(R.id.display_name)
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param name of person.
         * @param lastname of person.
         * @return A new instance of fragment DataFragment.
         */

        @JvmStatic
        fun newInstance(name: String, lastname: String) =
            DataFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_NAME, name)
                    putString(ARG_LASTNAME, lastname)
                }
                /*arguments = bundleOf(
                    ARG_NAME to param1,
                    ARG_LASTNAME to param2
                )*/
            }
    }
}