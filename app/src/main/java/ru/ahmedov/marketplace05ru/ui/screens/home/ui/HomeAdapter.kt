package ru.ahmedov.marketplace05ru.ui.screens.home.ui

import android.content.Context
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arasthel.spannedgridlayoutmanager.SpanSize
import com.arasthel.spannedgridlayoutmanager.SpannedGridLayoutManager
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_baner_block.view.*
import kotlinx.android.synthetic.main.item_category_block.view.*
import kotlinx.android.synthetic.main.item_discont_block.view.*
import kotlinx.android.synthetic.main.item_left_category_block.view.*
import kotlinx.android.synthetic.main.item_menu_block.view.*
import kotlinx.android.synthetic.main.item_products_block.view.*
import ru.ahmedov.marketplace05ru.R
import ru.ahmedov.marketplace05ru.data.global.models.home.HomeModel
import ru.ahmedov.marketplace05ru.ui.screens.home.ViewHolderFactory
import ru.ahmedov.marketplace05ru.ui.screens.home.ui.adapters.*

const val BANNER_SLIDERS = 0
const val CATEGORIES_LIST = 1
const val MENU = 2
const val PRODUCTS_BLOCK = 3
const val CATEGORY = 4
const val DISCOUNT_BLOCK = 5
const val BONUS_INFO = 6
const val SEARCH_INPUT = 7

private typealias OnItemClickListener = ((HomeModel) -> Unit)

class HomeAdapter(private val homeModels: List<HomeModel>) :
    RecyclerView.Adapter<HomeAdapter.BaseViewHolder<*>>() {

    private var clickListener: OnItemClickListener? = null

    override fun getItemViewType(position: Int): Int {
        when (homeModels[position].type) {
            "SEARCH_INPUT" -> {
                return SEARCH_INPUT
            }
            "BANNER_SLIDERS" -> {
                return BANNER_SLIDERS
            }
            "CATEGORIES_LIST" -> {
                return CATEGORIES_LIST
            }
            "MENU" -> {
                return MENU
            }
            "PRODUCTS_BLOCK" -> {
                return PRODUCTS_BLOCK
            }
            "CATEGORY" -> {
                return CATEGORY
            }
            "DISCOUNT_BLOCK" -> {
                return DISCOUNT_BLOCK
            }
            "BONUS_INFO" -> {
                return BONUS_INFO
            }
            else -> return -1
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return ViewHolderFactory().create(parent,viewType,homeModels)
    }

    abstract class BaseViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
        abstract fun bind(item: T)
    }

    override fun getItemCount(): Int {
        return homeModels.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        val element = homeModels[position]
        return when (holder) {
            is ViewHolderFactory.SearchInputViewHolder -> holder.bind(element)
            is ViewHolderFactory.BannerSlidersViewHolder -> holder.bind(element)
            is ViewHolderFactory.BonusBlockViewHolder -> holder.bind(element)
            is ViewHolderFactory.CategoryBlockViewHolder -> holder.bind(element)
            is ViewHolderFactory.CategoryListViewHolder -> holder.bind(element)
            is ViewHolderFactory.DiscountBlockViewHolder -> holder.bind(element)
            is ViewHolderFactory.MenuViewHolder -> holder.bind(element)
            is ViewHolderFactory.ProductsBlockViewHolder -> holder.bind(element)
            else -> throw IllegalArgumentException()
        }
    }
}