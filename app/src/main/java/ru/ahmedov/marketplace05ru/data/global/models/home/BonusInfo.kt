package ru.ahmedov.marketplace05ru.data.global.models.home

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class BonusInfo(
    @SerializedName("LINK") val link: Link?,
    @SerializedName("IMAGE") val image: String
) : Parcelable