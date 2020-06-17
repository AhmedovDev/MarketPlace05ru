package ru.ahmedov.marketplace05ru.ui.screens.home

import android.os.CountDownTimer
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
import ru.ahmedov.marketplace05ru.data.global.models.home.HomeModel
import ru.ahmedov.marketplace05ru.ui.screens.home.ui.*
import ru.ahmedov.marketplace05ru.ui.screens.home.ui.adapters.*


class ViewHolderFactory {



    inner class BannerSlidersViewHolder(itemView: View) :
        HomeAdapter.BaseViewHolder<HomeModel>(itemView) {

        override fun bind(item: HomeModel) {
            itemView.recyclerView_banner_block.run {
                layoutManager = LinearLayoutManager(
                    recyclerView_banner_block.context,
                    LinearLayoutManager.HORIZONTAL,
                    false
                )

               infinityScrollingBanners()

            }

            val adapter =
                BannerAdapter(
                    item.bannerSliders!!
                )
            itemView.recyclerView_banner_block.adapter = adapter

            itemView.recyclerView_banner_block.scrollToPosition(Int.MAX_VALUE / 2)

            itemView.indicator.attachToRecyclerView(itemView.recyclerView_banner_block);


        }

        fun infinityScrollingBanners() {
            val speedScroll = 4000
            val handler = Handler()
            var count = 0
            val runnable: Runnable = object : Runnable {
                var flag = true
                override fun run() {
                    if (count < Int.MAX_VALUE) {
                        count++
//                        if (count == Int.MAX_VALUE - 1) {
//                            flag = false
//                        } else if (count == 0) {
//                            flag = true
//                        }
//                        if (flag) count++ else {
//                            count = 0
//                            itemView.recyclerView_banner_block.scrollToPosition(count)
//                        }
                        itemView.recyclerView_banner_block.smoothScrollToPosition(count)
                    }
                    handler.postDelayed(this, speedScroll.toLong())

                }
            }

            handler.postDelayed(runnable, speedScroll.toLong())

            itemView.recyclerView_banner_block.addOnScrollListener(object :
                RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    count =
                        (itemView.recyclerView_banner_block.layoutManager as LinearLayoutManager?)!!.findFirstVisibleItemPosition()
                }
            })
        }
    }

    inner class CategoryListViewHolder(itemView: View) :
        HomeAdapter.BaseViewHolder<HomeModel>(itemView) {

        override fun bind(item: HomeModel) {

            val categoryListAdapter =
                CategoryListAdapter(
                    item.categoryList!!
                )

            itemView.recyclerView_category_block.adapter = categoryListAdapter
            categoryListAdapter.setOnProductClickListener {
            }

            itemView.recyclerView_category_block.run {
                layoutManager = GridLayoutManager(
                    itemView.recyclerView_category_block.context,
                    4
                )
            }
        }
    }

    inner class ProductsBlockViewHolder(itemView: View) :
        HomeAdapter.BaseViewHolder<HomeModel>(itemView) {

        override fun bind(item: HomeModel) {

            val productAdapter =
                ProductAdapter(
                    item.productsBlock!!.items,
                    item.productsBlock!!.size
                )

            productAdapter.setOnProductClickListener {
            }

            if (item.productsBlock!!.size == "BIG") {
                itemView.recyclerView_product_block.run {


                    val spannedGridLayoutManager = SpannedGridLayoutManager(
                        orientation = SpannedGridLayoutManager.Orientation.VERTICAL,
                        spans = 3
                    )

                    spannedGridLayoutManager.itemOrderIsStable = true


                    spannedGridLayoutManager.spanSizeLookup =
                        SpannedGridLayoutManager.SpanSizeLookup { position ->
                            if (position == 0) {
                                SpanSize(2, 2)
                            } else {
                                SpanSize(1, 1)
                            }
                        }
                    layoutManager = spannedGridLayoutManager

                    itemView.recyclerView_product_block.adapter = productAdapter
                }

            } else {
                itemView.recyclerView_product_block.run {
                    layoutManager = GridLayoutManager(
                        itemView.recyclerView_product_block.context,
                        3
                    )
                }

                itemView.recyclerView_product_block.adapter = productAdapter

            }
        }
    }

    inner class BonusBlockViewHolder(itemView: View) :
        HomeAdapter.BaseViewHolder<HomeModel>(itemView) {

        override fun bind(item: HomeModel) {
//            Picasso.get()
//                .load(item.bonusInfo!!.image)
//                .into(itemView.imageView_bonus_block)
        }
    }

    inner class MenuViewHolder(itemView: View) :
        HomeAdapter.BaseViewHolder<HomeModel>(itemView) {

        override fun bind(item: HomeModel) {
            itemView.recyclerView_menu_block.run {
                layoutManager = LinearLayoutManager(
                    recyclerView_menu_block.context,
                    LinearLayoutManager.HORIZONTAL,
                    false
                )

                val adapter = MenuAdapter(item.menu!!)
                itemView.recyclerView_menu_block.adapter = adapter
            }
        }
    }

    inner class CategoryBlockViewHolder(itemView: View) :
        HomeAdapter.BaseViewHolder<HomeModel>(itemView) {

        override fun bind(item: HomeModel) {

            Picasso.get()
                .load(item.category!!.image)
                .fit()
                .into(itemView.image_left_category_block)

            itemView.recyclerView_left_category_block.run {
                layoutManager = LinearLayoutManager(
                    recyclerView_left_category_block.context,
                    LinearLayoutManager.VERTICAL,
                    false
                )

                val adapter = CategoryAdapter(item.category)
                itemView.recyclerView_left_category_block.adapter = adapter
            }

        }
    }

    inner class DiscountBlockViewHolder(itemView: View) :
        HomeAdapter.BaseViewHolder<HomeModel>(itemView) {

        override fun bind(item: HomeModel) {
            Picasso.get()
                .load(item.discountBlock!!.image)
                .fit()
                .centerCrop()
                .into(itemView.imageView_discont_block)
        }
    }

    inner class SearchInputViewHolder(itemView: View) :
        HomeAdapter.BaseViewHolder<HomeModel>(itemView) {

        override fun bind(item: HomeModel) {

        }
    }

    final fun create(
        parent: ViewGroup,
        viewType: Int,
        homeModels: List<HomeModel>
    ): HomeAdapter.BaseViewHolder<*> {
        return when (viewType) {
//             SEARCH_INPUT -> {
//                 val itemView = LayoutInflater
//                     .from(parent.context)
//                     .inflate(R.layout.ite, parent, false)
//                  SearchInputViewHolder(itemView)
//             }
            BANNER_SLIDERS -> {
                val itemView = LayoutInflater
                    .from(parent.context)
                    .inflate(ru.ahmedov.marketplace05ru.R.layout.item_baner_block, parent, false)
                BannerSlidersViewHolder(itemView)
            }
            CATEGORIES_LIST -> {
                val itemView = LayoutInflater
                    .from(parent.context)
                    .inflate(ru.ahmedov.marketplace05ru.R.layout.item_category_block, parent, false)
                CategoryListViewHolder(itemView)
            }
            MENU -> {
                val itemView = LayoutInflater
                    .from(parent.context)
                    .inflate(ru.ahmedov.marketplace05ru.R.layout.item_menu_block, parent, false)
                MenuViewHolder(itemView)
            }
            PRODUCTS_BLOCK -> {
                val itemView = LayoutInflater
                    .from(parent.context)
                    .inflate(ru.ahmedov.marketplace05ru.R.layout.item_products_block, parent, false)
                ProductsBlockViewHolder(itemView)
            }
            CATEGORY -> {
                if (homeModels[6].category != null) {
                    if (homeModels[6].category!!.position == "LEFT") {
                        val itemView = LayoutInflater
                            .from(parent.context)
                            .inflate(
                                ru.ahmedov.marketplace05ru.R.layout.item_left_category_block,
                                parent,
                                false
                            )
                        CategoryBlockViewHolder(itemView)
                    } else {
                        val itemView = LayoutInflater
                            .from(parent.context)
                            .inflate(
                                ru.ahmedov.marketplace05ru.R.layout.item_right_category_block,
                                parent,
                                false
                            )
                        CategoryBlockViewHolder(itemView)
                    }
                } else {
                    val itemView = LayoutInflater
                        .from(parent.context)
                        .inflate(
                            ru.ahmedov.marketplace05ru.R.layout.item_search_block,
                            parent,
                            false
                        )
                    SearchInputViewHolder(itemView)
                }
            }
            DISCOUNT_BLOCK -> {
                val itemView = LayoutInflater
                    .from(parent.context)
                    .inflate(ru.ahmedov.marketplace05ru.R.layout.item_discont_block, parent, false)
                DiscountBlockViewHolder(itemView)
            }
            BONUS_INFO -> {
                val itemView = LayoutInflater
                    .from(parent.context)
                    .inflate(ru.ahmedov.marketplace05ru.R.layout.item_bonus_block, parent, false)
                BonusBlockViewHolder(itemView)
            }
            else -> {
                val itemView = LayoutInflater
                    .from(parent.context)
                    .inflate(ru.ahmedov.marketplace05ru.R.layout.item_search_block, parent, false)
                SearchInputViewHolder(itemView)
            }
        }!!
    }

}