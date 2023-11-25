package com.veg.kotlincase.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class CharacterModel (
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name="id")
        var id:Int?,
        @ColumnInfo(name="character_name")
        val name:String?,
        @ColumnInfo(name="character_username")
        val username:String?,
        @ColumnInfo(name="character_email")
        val email:String?,
        @ColumnInfo(name="character_phone")
        val phone:String?,
        ): Parcelable