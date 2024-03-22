package com.example.serene.GetData.Getapidata

import com.google.gson.annotations.SerializedName


data class GetDataClass (

  @SerializedName("status"  ) var status  : String? = null,
  @SerializedName("message" ) var message : String? = null,
  @SerializedName("data"    ) var data    : Data?   = Data()

)