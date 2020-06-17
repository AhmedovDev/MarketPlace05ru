package ru.ahmedov.marketplace05ru.ui.screens.home.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_menu.view.*
import ru.ahmedov.marketplace05ru.R
import ru.ahmedov.marketplace05ru.data.global.models.home.Menu

private typealias OnMenuClickListener = (Menu) -> Unit

class MenuAdapter(private val menus: List<Menu>
) :
    RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {


    private var clickListener: OnMenuClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_menu, parent, false)
        return MenuViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) =
        holder.bind(menus[position], clickListener)

    override fun getItemCount(): Int = menus.size


    fun setOnCategoryClickListener(listener: OnMenuClickListener?) {
        clickListener = listener
    }

    fun adapterUpdate(){
        notifyDataSetChanged()
    }

    inner  class MenuViewHolder(override val containerView: View) :
        RecyclerView.ViewHolder(containerView), LayoutContainer {

        fun bind(menu: Menu, clickListener: OnMenuClickListener?) {

            containerView.textView_menu.text = menu.name

        }
    }

}

