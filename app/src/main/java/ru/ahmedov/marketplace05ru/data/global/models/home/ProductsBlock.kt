package ru.ahmedov.marketplace05ru.data.global.models.home

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class ProductsBlock(
    @SerializedName("TITLE") val title: String?,
    @SerializedName("GROUP_NAME") val groupName: String,
    @SerializedName("ITEMS") val items: List<Item>,
    @SerializedName("SIZE") val size: String

) : Parcelable