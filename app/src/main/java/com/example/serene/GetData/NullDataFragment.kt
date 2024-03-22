package com.example.serene.GetData

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.serene.R


class NullDataFragment : Fragment() {
    lateinit var empty:TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_null_data, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        empty=view.findViewById(R.id.empty)
    }

}