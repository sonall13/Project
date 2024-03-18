package com.example.serene.GetData

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import com.example.serene.R

class NightFragment : Fragment() {
 lateinit var back : ImageButton
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.nightfragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        back =view.findViewById(R.id.back)
        back.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()

        }
    }


}
