package com.example.serene.GetData.Getapidata

import com.google.gson.annotations.SerializedName


data class Freestyle (

  @SerializedName("_id"       ) var Id        : String? = null,
  @SerializedName("userid"    ) var userid    : String? = null,
  @SerializedName("text"      ) var text      : String? = null,
  @SerializedName("createdAt" ) var createdAt : String? = null,
  @SerializedName("updatedAt" ) var updatedAt : String? = null,
  @SerializedName("__v"       ) var _v        : Int?    = null

)