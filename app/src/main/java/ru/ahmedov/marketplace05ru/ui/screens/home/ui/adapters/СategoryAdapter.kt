package ru.ahmedov.marketplace05ru.ui.screens.home.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_recycler_left_category_block.view.*
import ru.ahmedov.marketplace05ru.R
import ru.ahmedov.marketplace05ru.data.global.models.home.Category
import ru.ahmedov.marketplace05ru.data.global.models.home.Item

private typealias OnCategoryClickListener = (Category) -> Unit

class CategoryAdapter(private val category: Category) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {


    private var clickListener: OnCategoryClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        if (category.position == "LEFT") {
            val itemView = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_recycler_left_category_block, parent, false)
            return CategoryViewHolder(itemView)
        } else {
            val itemView = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_recycler_right_category_block, parent, false)
            return CategoryViewHolder(itemView)
        }
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) =
        holder.bind(category.items[position], clickListener)

    override fun getItemCount(): Int = 5

    fun setOnCategoryClickListener(listener: OnCategoryClickListener?) {
        clickListener = listener
    }

    fun adapterUpdate() {
        notifyDataSetChanged()
    }

    inner class CategoryViewHolder(override val containerView: View) :
        RecyclerView.ViewHolder(containerView), LayoutContainer {

        fun bind(item: Item, clickListener: OnCategoryClickListener?) {
            containerView.textView_item_recycler_category.text = item.name
        }
    }

}