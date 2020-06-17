package ru.ahmedov.marketplace05ru.data.global.models.home

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class Item(
    @SerializedName("ID") val id: String?,
    @SerializedName("NAME") val name: String?,
    @SerializedName("DETAIL_PICTURE") val detailPicture: String?,
    @SerializedName("SHOW_COUNTER") val showCounter: String?,
    @SerializedName("SHOW_COUNTER_START_X") val showCounterStartX: String?,
    @SerializedName("IMAGE") val image: String?,
    @SerializedName("ACTIONS") val actions: List<Action>?,
    @SerializedName("PRICES") val prices: List<Price>?,
    @SerializedName("LINK") val link: Link

) : Parcelable