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
import com.example.serene.GetData.Getapidata.GetDataClass
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

        RetrofitInstance().method().fetchfreestyle(token!!,formattedDate.toString()).enqueue(object : Callback<GetDataClass> {
            override fun onResponse(
                call: Call<GetDataClass>,
                response: Response<GetDataClass>,
            ) {
                Log.d("==-----", "onResponse: ${response.body()}")
                if (response.body()?.status == "success") {

//                    JournalingDataActivity.progressbar.visibility=View.INVISIBLE
                    Log.d("==+---", "onResponse: ${response.body()?.data?.freestyle?.createdAt.toString()}")


                    if (response.body()!!.data?.freestyle?.createdAt.toString() == formattedDate) {
                        freestyletext.text = response.body()!!.data?.freestyle?.text.toString()
                    }
                    else {
                        fragmentmanager()
                    }
                }
                }
            override fun onFailure(call: Call<GetDataClass>, t: Throwable) {
                Log.d("=+=", "onResponse: ${t.localizedMessage}")
            }
        })
    }
    fun fragmentmanager(){
        val fragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        // Replace current fragment with the new fragment
        fragmentTransaction.replace(R.id.cat_frame, NullDataFragment())
        // If you want to add the new fragment to the back stack, allowing the user to navigate back to the previous fragment
        fragmentTransaction.addToBackStack(null)
        // Commit the transaction
        fragmentTransaction.commit()
    }

}
