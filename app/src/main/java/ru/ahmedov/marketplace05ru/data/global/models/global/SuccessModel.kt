package ru.ahmedov.marketplace05ru.data.global.models.global

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class SuccessModel<T : Parcelable> (
    @SerializedName("success") var success: Boolean,
    @SerializedName("result") var result: List<T>? = null
) : Parcelable