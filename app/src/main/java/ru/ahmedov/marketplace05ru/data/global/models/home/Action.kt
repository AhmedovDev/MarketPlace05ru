package ru.ahmedov.marketplace05ru.data.global.models.home

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
class Action(
    @SerializedName("NAME") val name: String,
    @SerializedName("ID") val id: String?,
    @SerializedName("COLOR") val color: String
) : Parcelable