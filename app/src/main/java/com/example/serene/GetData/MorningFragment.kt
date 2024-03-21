package com.example.serene.GetData

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.example.First
import com.example.serene.Apidata.RetrofitInstance
import com.example.serene.R
import com.example.serene.SplaseScreen
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MorningFragment : Fragment() {

    private lateinit var multianswer1 : TextView
    private lateinit var multianswer2 : TextView
    private lateinit var multianswer3 : TextView
    private lateinit var seconanswer : TextView
    private lateinit var thirdanswer : TextView

    private var multianswerarray = arrayListOf<String>()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.morningfragment, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        multianswer1 = view.findViewById(R.id.multianswer1)
        multianswer2 = view.findViewById(R.id.multianswer2)
        multianswer3 =  view.findViewById(R.id.multianswer3)
        seconanswer =  view.findViewById(R.id.secondanswer)
        thirdanswer =  view.findViewById(R.id.thirdanswer)

        var token = SplaseScreen.sp.getString("token"," ")
        var getid = SplaseScreen.sp.getString("getid"," ")
        var s = SplaseScreen.sp.getString("formattedDate","gh")

        Log.d("==+-+--", "onCreate: ${getid.toString()}")
        Log.d("==+-+--", "onCreate: ${s.toString()}")
        Toast.makeText(context, "please wait", Toast.LENGTH_SHORT).show()

//
        RetrofitInstance().method().fetchmornign(token!!).enqueue(object : Callback<First> {
            override fun onResponse(
                call: Call<First>,
                response: Response<First>,
            ) {
                Log.d("==-++----", "onResponse: ${response.body()}")
                if (response.body()?.status == "success"){

                    Log.d("==+-+--", "onResponse: ${response.body()?.status}")
                    Log.d("==+-+--", "onResponse: ${response.body()?.data?.get(0)?.updatedAt.toString()}")

                    if (response.body()!!.data.get(0).category.toString() == "morning" ) {

                        Log.d("==+-+--", "onResponse: ${response.body()?.data?.get(0)?.Id.toString()}")

                        multianswer1.text = response.body()!!.data.get(0).answers?.q1?.get(0).toString()
                        multianswer2.text = response.body()!!.data.get(0).answers?.q1?.get(1).toString()
                        multianswer3.text = response.body()!!.data.get(0).answers?.q1?.get(2).toString()

                        seconanswer.text = response.body()!!.data.get(0).answers?.q2.toString()
                        thirdanswer.text = response.body()!!.data.get(0).answers?.q3.toString()

//                        multianswerarray.addAll(listOf(response.body()!!.data?.answers?.q2.toString()))
                    }
                }
            }
            override fun onFailure(call: Call<First>, t: Throwable) {
                Log.d("=+=", "onResponse: ${t.localizedMessage}")
            }
        })
    }
}
