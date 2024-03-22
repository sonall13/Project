package com.example.serene.GetData.Getapidata

import com.google.gson.annotations.SerializedName


data class Data (

  @SerializedName("morning"   ) var morning   : Morning?   = Morning(),
  @SerializedName("gratitude" ) var gratitude : Gratitude? = Gratitude(),
  @SerializedName("night"     ) var night     : Night?     = Night(),
  @SerializedName("freestyle" ) var freestyle : Freestyle? = Freestyle(),
  @SerializedName("memory"    ) var memory    : Memory?    = Memory(),
  @SerializedName("mood"      ) var mood      : Mood?      = Mood()

)