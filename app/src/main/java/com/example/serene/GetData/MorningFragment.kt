package com.example.serene.GetData

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
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

//        var token = SplaseScreen.sp.getString("token"," ")
//        Log.d("=m-token", "onCreate: ${token}")
//
//        RetrofitInstance().method().fetchmornign().enqueue(object : Callback<GetMorningData> {
//            override fun onResponse(
//                call: Call<GetMorningData>,
//                response: Response<GetMorningData>,
//            ) {
//                Log.d("==", "onResponse: ${response.body()}")
//                if (response.body()?.status == "status"){
//
//                    if (response.body()!!.data?.category == "morning" && response.body()!!.data?.createdAt == "2024-03-14T21:20:01.749+00:00" ) {
//                      seconanswer.text = response.body()!!.data?.answers?.q1.toString()
//                      thirdanswer.text = response.body()!!.data?.answers?.q3.toString()
//
////                        multianswerarray.addAll(listOf(response.body()!!.data?.answers?.q2.toString()))
//
//                        multianswer1.text = response.body()!!.data?.answers?.q2?.get(0).toString()
//                        multianswer2.text = response.body()!!.data?.answers?.q2?.get(1).toString()
//                        multianswer3.text = response.body()!!.data?.answers?.q2?.get(2).toString()
//                    }
//                }
//            }
//            override fun onFailure(call: Call<GetMorningData>, t: Throwable) {
//                Log.d("=+=", "onResponse: ${t.localizedMessage}")
//            }
//        })

    }




}
