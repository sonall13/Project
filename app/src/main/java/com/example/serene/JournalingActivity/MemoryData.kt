package com.example.serene.JournalingActivity

import com.google.gson.annotations.SerializedName


data class MemoryData (

  @SerializedName("userid"    ) var userid    : String? = null,
  @SerializedName("caption"   ) var caption   : String? = null,
  @SerializedName("image"     ) var image     : String? = null,
  @SerializedName("_id"       ) var Id        : String? = null,
  @SerializedName("createdAt" ) var createdAt : String? = null,
  @SerializedName("updatedAt" ) var updatedAt : String? = null,
  @SerializedName("__v"       ) var _v        : Int?    = null

)