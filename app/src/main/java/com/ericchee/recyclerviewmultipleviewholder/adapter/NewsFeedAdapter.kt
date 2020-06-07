package com.ericchee.recyclerviewmultipleviewholder.adapter



import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ericchee.recyclerviewmultipleviewholder.R
import com.ericchee.recyclerviewmultipleviewholder.model.FeedItem

/**
 * This recyclerview holds onto a list of FeedItem objects. Look at the FeedItem class
 */
class NewsFeedAdapter(
    private val items: List<FeedItem>
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    /**
     * Identify custom Unique ID that will represent each view type
     */

    companion object {
        const val TEXT_ITEM_TYPE_ID = 0
        const val IMAGE_ITEM_TYPE_ID = 1
        const val VIDEO_ITEM_TYPE_ID = 2
    }

    /**
     * This method lets you determine what the the view type is when given a position
     * For instance Here we just check to see if item at the position is a class of type TextItem, thus we
     *  return the view type id of TEXT_ITEM_TYPE_ID
     */
    override fun getItemViewType(position: Int): Int {
        return when(items[position]) {
            is FeedItem.TextItem -> TEXT_ITEM_TYPE_ID
            is FeedItem.VideoItem -> VIDEO_ITEM_TYPE_ID
            is FeedItem.ImageItem -> IMAGE_ITEM_TYPE_ID
        }
    }

    /**
     * Here it will give us the viewtype ID, and this helps us determine what kind of view holder we should create + the layout
     * (that means we need to made a different view holder class for each type of different view we want in the recycler view)
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
       return when(viewType) {
            TEXT_ITEM_TYPE_ID -> TextItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_text, parent, false))
            IMAGE_ITEM_TYPE_ID -> ImageItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_image, parent, false))
            VIDEO_ITEM_TYPE_ID -> VideoItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_video, parent, false))
            else -> UnknownItemViewHolder(View(parent.context))
        }
    }

    override fun getItemCount(): Int = items.size

    /**
     * This is where are ready to load the data into the view holder. We first have to check what kind of viewholder it is, and then we can load the appropriate data
     */
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is TextItemViewHolder -> holder.bind(items[position] as FeedItem.TextItem)
            is VideoItemViewHolder -> holder.bind(items[position] as FeedItem.VideoItem)
            is ImageItemViewHolder -> holder.bind(items[position] as FeedItem.ImageItem)
        }
    }

    class TextItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(textItem: FeedItem.TextItem) {
            // Todo Handle layout for text type
        }
    }

    class VideoItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(videoItem: FeedItem.VideoItem) {
            // Todo handle layout for video type
        }
    }

    class ImageItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(imageItem: FeedItem.ImageItem) {
            // Todo handle layout for image type
        }
    }

    class UnknownItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

}