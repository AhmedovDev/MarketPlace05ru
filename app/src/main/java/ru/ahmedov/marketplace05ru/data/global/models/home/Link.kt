package ru.ahmedov.marketplace05ru.data.global.models.home

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class Link(
    @SerializedName("TYPE") val id: String,
    @SerializedName("VALUE") val name: String
) : Parcelable