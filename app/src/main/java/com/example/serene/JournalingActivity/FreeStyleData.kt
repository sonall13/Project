package com.example.serene.JournalingActivity

import com.google.gson.annotations.SerializedName

data class FreeStyleData (

  @SerializedName("userid"    ) var userid    : String? = null,
  @SerializedName("text"      ) var text      : String? = null,
  @SerializedName("_id"       ) var Id        : String? = null,
  @SerializedName("createdAt" ) var createdAt : String? = null,
  @SerializedName("updatedAt" ) var updatedAt : String? = null,
  @SerializedName("__v"       ) var _v        : Int?    = null

)