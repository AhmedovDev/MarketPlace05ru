package ru.ahmedov.marketplace05ru.data.global.models.home

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class HomeModel(
    @SerializedName("TITLE") val title: String?,
    @SerializedName("TYPE") val type: String,
    @SerializedName("SEARCH_INPUT") val searchInput: Boolean?,
    @SerializedName("BANNER_SLIDERS") val bannerSliders: List<Banner>?,
    @SerializedName("CATEGORIES_LIST") val categoryList: List<CategoryList>?,
    @SerializedName("MENU") val menu: List<Menu>?,
    @SerializedName("PRODUCTS_BLOCK") val productsBlock: ProductsBlock?,
    @SerializedName("CATEGORY") val category: Category?,
    @SerializedName("DISCOUNT_BLOCK") val discountBlock: DiscountBlock?,
    @SerializedName("BONUS_INFO") val bonusInfo: BonusInfo?
) : Parcelable