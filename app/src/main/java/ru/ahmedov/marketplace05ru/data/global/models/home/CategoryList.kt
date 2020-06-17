package ru.ahmedov.marketplace05ru.data.global.models.home

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class CategoryList(
    @SerializedName("ID") val id: String,
    @SerializedName("NAME") val name: String,
    @SerializedName("PICTURE") val picture: String,
    @SerializedName("IMAGE") val image: String,
    @SerializedName("LINK") val link: Link
) : Parcelable