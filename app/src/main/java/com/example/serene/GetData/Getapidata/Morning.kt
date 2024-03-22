package com.example.serene.GetData.Getapidata

import com.google.gson.annotations.SerializedName


data class Morning (

  @SerializedName("_id"       ) var Id        : String?  = null,
  @SerializedName("userid"    ) var userid    : String?  = null,
  @SerializedName("category"  ) var category  : String?  = null,
  @SerializedName("answers"   ) var answers   : Answers? = Answers(),
  @SerializedName("createdAt" ) var createdAt : String?  = null,
  @SerializedName("updatedAt" ) var updatedAt : String?  = null,
  @SerializedName("__v"       ) var _v        : Int?     = null

)