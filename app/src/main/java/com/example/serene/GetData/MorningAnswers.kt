package com.example.serene.GetData

import com.google.gson.annotations.SerializedName


data class MorningAnswers (

  @SerializedName("q1" ) var q1 : String?           = null,
  @SerializedName("q2" ) var q2 : ArrayList<String> = arrayListOf(),
  @SerializedName("q3" ) var q3 : String?           = null

)