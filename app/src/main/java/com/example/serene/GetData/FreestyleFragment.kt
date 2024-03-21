package com.example.serene.GetData

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.serene.Apidata.RetrofitInstance
import com.example.serene.R
import com.example.serene.SplaseScreen
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FreestyleFragment : Fragment() {

    lateinit var freestyletext:TextView
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.freestylefragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        freestyletext=view.findViewById(R.id.freestyletext)

        Toast.makeText(context, "please wait", Toast.LENGTH_SHORT).show()

        var token = SplaseScreen.sp.getString("token"," ")
        var  formattedDate= SplaseScreen.sp.getString("formattedDate"," ")

        RetrofitInstance().method().fetchfreestyle(token!!).enqueue(object : Callback<GetFreeStyleData> {
            override fun onResponse(
                call: Call<GetFreeStyleData>,
                response: Response<GetFreeStyleData>,
            ) {
                Log.d("==-----", "onResponse: ${response.body()}")
                if (response.body()?.status == "success") {

                    Log.d("==+---", "onResponse: ${response.body()?.data?.get(0)?.createdAt.toString()}")


                    if (response.body()!!.data.get(0).createdAt.toString() == "2024-03-17") {
                        freestyletext.text = response.body()!!.data.get(0).text.toString()
                    }
                }
                }
            override fun onFailure(call: Call<GetFreeStyleData>, t: Throwable) {
                Log.d("=+=", "onResponse: ${t.localizedMessage}")
            }
        })
    }

}
