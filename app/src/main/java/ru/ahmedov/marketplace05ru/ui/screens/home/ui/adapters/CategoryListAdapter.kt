package ru.ahmedov.marketplace05ru.ui.screens.home.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_banner.view.*
import kotlinx.android.synthetic.main.item_category.view.*
import ru.ahmedov.marketplace05ru.R
import ru.ahmedov.marketplace05ru.data.global.models.home.CategoryList

private typealias OnCategoryListClickListener = ((CategoryList) -> Unit)

class CategoryListAdapter(
    private val categories: List<CategoryList>

) :
    RecyclerView.Adapter<CategoryListAdapter.CAtegoryListViewHolder>() {

    private var clickListener: OnCategoryListClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CAtegoryListViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_category, parent, false)
        return CAtegoryListViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CAtegoryListViewHolder, position: Int) {
        holder.bind(categories[position], clickListener)

    }

    override fun getItemCount(): Int = 8

    fun setOnProductClickListener(listener: OnCategoryListClickListener?) {
        clickListener = listener
    }

    inner class CAtegoryListViewHolder(override val containerView: View) :
        RecyclerView.ViewHolder(containerView), LayoutContainer {



        fun bind(category: CategoryList, clickListener: OnCategoryListClickListener?) {

            Picasso.get()
                .load(category.image)
                .error(R.drawable.banner)
                .into(containerView.category_image)

            containerView.category_name.text = category.name

            itemView.setOnClickListener { clickListener?.invoke(category) }
        }
    }
}