package ru.ahmedov.marketplace05ru.data.global.models.home

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class Category(
    @SerializedName("ID") val id: String,
    @SerializedName("NAME") val name: String,
    @SerializedName("POSITION") val position: String?,
    @SerializedName("IMAGE") val image: String,
    @SerializedName("ITEMS") val items: List<Item>
) : Parcelable