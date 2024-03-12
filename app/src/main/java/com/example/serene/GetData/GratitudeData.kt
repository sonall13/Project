package com.example.serene.GetData

import com.google.gson.annotations.SerializedName


data class GratitudeData (

  @SerializedName("userid"    ) var userid    : String?  = null,
  @SerializedName("category"  ) var category  : String?  = null,
  @SerializedName("answers"   ) var answers   : GratitudeAnswers? = GratitudeAnswers(),
  @SerializedName("_id"       ) var Id        : String?  = null,
  @SerializedName("createdAt" ) var createdAt : String?  = null,
  @SerializedName("updatedAt" ) var updatedAt : String?  = null,
  @SerializedName("__v"       ) var _v        : Int?     = null

)