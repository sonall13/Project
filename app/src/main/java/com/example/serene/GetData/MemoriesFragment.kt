package com.example.serene.GetData

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.example.GetMemoryData
import com.example.serene.Apidata.RetrofitInstance
import com.example.serene.GetData.Getapidata.GetDataClass
import com.example.serene.R
import com.example.serene.SplaseScreen
import com.theartofdev.edmodo.cropper.CropImage
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MemoriesFragment : Fragment(){

    lateinit var getimg :ImageView
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.memoriesfragment, container, false)
    }
    override fun onViewCreated(view:  View, savedInstanceState: Bundle?) {
        getimg =view.findViewById(R.id.getimg)
        var token = SplaseScreen.sp.getString("token"," ")
        var  formattedDate= SplaseScreen.sp.getString("formattedDate"," ")
        Toast.makeText(context, "please wait", Toast.LENGTH_LONG).show()

        RetrofitInstance().method().fetchmemory(token!!,formattedDate.toString()).enqueue(object : Callback<GetDataClass> {
            override fun onResponse(call: Call<GetDataClass>, response: Response<GetDataClass>) {
                Log.d("==---+--", "onResponse: ${response.body()}")
                if (response.body()?.status == "success") {
                    Log.d("==+-==--", "onResponse: ${response.body()!!.data?.memory?.image}")

                        if(response.body()?.data?.memory != null) {
                            Log.d(
                                "==+-==--",
                                "onResponse: ${response.body()!!.data?.memory?.image}"
                            )

                            Glide.with(this@MemoriesFragment).load(
                                "https://6gn1hp4c-3000.inc1.devtunnels.ms/image/" +
                                        response.body()!!.data?.memory?.image
                            ).into(getimg)
                        }
                    else {
                        fragmentmanager()
                    }
                }
                }

            override fun onFailure(call: Call<GetDataClass>, t: Throwable) {
                Log.d("=+--=", "onResponse: ${t.localizedMessage}")
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
