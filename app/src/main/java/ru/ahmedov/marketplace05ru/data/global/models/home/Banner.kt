package ru.ahmedov.marketplace05ru.data.global.models.home

import android.os.Parcelable
import android.provider.ContactsContract
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class Banner(
    @SerializedName("ID") val id: String,
    @SerializedName("NAME") val name: String,
    @SerializedName("TYPE") val type: String?,
    @SerializedName("CODE") val code: String?,
    @SerializedName("PHOTO") val photo: String,
    @SerializedName("IMAGE") val image: String,
    @SerializedName("LINK") val link: Link
) : Parcelable