package ru.ahmedov.marketplace05ru.data.global.models.home

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class Price(
    @SerializedName("NAME") val name: String,
    @SerializedName("CODE") val code: String,
    @SerializedName("PRICE_TYPE_ID") val pictureTypeId: String,
    @SerializedName("PRICE") val price: String,
    @SerializedName("PRINT_PRICE") val printPrice: String,
    @SerializedName("CURRENCY") val currency: String,
    @SerializedName("CROSSED") val crossed: Boolean,
    @SerializedName("BONUS") val bonus: Int
) : Parcelable