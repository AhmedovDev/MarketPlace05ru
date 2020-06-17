package ru.ahmedov.marketplace05ru.ui.screens.home.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_banner.view.*
import okhttp3.OkHttpClient
import okhttp3.Protocol
import ru.ahmedov.marketplace05ru.R
import ru.ahmedov.marketplace05ru.data.global.models.home.Banner
import java.util.*


private typealias OnBannerClickListener = ((Banner) -> Unit)

class BannerAdapter(private val banner: List<Banner>) :
    RecyclerView.Adapter<BannerAdapter.BannerViewHolder>() {

    private var clickListener: OnBannerClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_banner, parent, false)
        return BannerViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {
        holder.bind(banner[position % banner.size], clickListener)
    }

    override fun getItemCount(): Int =  Integer.MAX_VALUE;

    fun setOnEventClickListener(listener: OnBannerClickListener?) {
        clickListener = listener
    }

    class BannerViewHolder(override val containerView: View) :
        RecyclerView.ViewHolder(containerView), LayoutContainer {

        fun bind(banner: Banner, clickListener: OnBannerClickListener?) {

            Picasso.get()
                .load(banner.image)
                .error(R.drawable.banner)
                .into(containerView.image_banner)
        }
    }
}