package ru.ahmedov.marketplace05ru.data.global.models.home

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class Menu(
    @SerializedName("NAME") val name: String,
    @SerializedName("TITLE") val title: String?,
    @SerializedName("LINK") val link: Link
) : Parcelable