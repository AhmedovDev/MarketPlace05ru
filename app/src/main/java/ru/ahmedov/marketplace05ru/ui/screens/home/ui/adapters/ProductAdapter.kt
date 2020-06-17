package ru.ahmedov.marketplace05ru.ui.screens.home.ui.adapters

import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target.SIZE_ORIGINAL
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_product.view.*
import ru.ahmedov.marketplace05ru.R
import ru.ahmedov.marketplace05ru.data.global.models.home.Item


private typealias OnProductClickListener = ((Item) -> Unit)


class ProductAdapter(private val products: List<Item>, private val size: String) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    private var clickListener: OnProductClickListener? = null

    //    private val list : List<String> = ArrayList()
    private var lastCheckedPosition = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_product, parent, false)

        return ProductViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(products[position], clickListener)

    }

    override fun getItemCount(): Int =
        if (size == "BIG")
             6
        else
            9


    fun setOnProductClickListener(listener: OnProductClickListener?) {
        clickListener = listener
    }


    inner class ProductViewHolder(override val containerView: View) :
        RecyclerView.ViewHolder(containerView), LayoutContainer {

        fun bind(
            product: Item,
            clickListener: OnProductClickListener?
        ) {

            Glide.with(containerView).load(product.image)
            .into(containerView.image_product)

//            Picasso.get()
//                .load(product.image)
//                .noFade()
//                .into(containerView.image_product)
        }
    }
}
