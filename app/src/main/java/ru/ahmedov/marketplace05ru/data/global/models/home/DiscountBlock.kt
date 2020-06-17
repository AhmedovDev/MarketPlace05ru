package ru.ahmedov.marketplace05ru.data.global.models.home

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class DiscountBlock(
    @SerializedName("ID") val id: String?,
    @SerializedName("NAME") val name: String?,
    @SerializedName("PREVIEW_TEXT") val previewText: String?,
    @SerializedName("DETAIL_TEXT") val detailText: String?,
    @SerializedName("DATE_ACTIVE_TO") val dateActiveTo: String?,
    @SerializedName("DETAIL_TEXT_TYPE") val detailTextType: String?,
    @SerializedName("PREVIEW_TEXT_TYPE") val previewTextType: String?,
    @SerializedName("PHOTO") val photo: String?,
    @SerializedName("IMAGE") val image: String?,
    @SerializedName("TITLE") val title: String?,
    @SerializedName("LINK") val link: Link,
    @SerializedName("ITEMS") val items: List<Item>

) : Parcelable