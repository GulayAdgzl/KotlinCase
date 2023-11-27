package com.veg.kotlincase.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CharacterModel (
        var id:Int?,
        val name:String?,
        val username:String?,
        val email:String?,
        val phone:String?,
        ): Parcelable
