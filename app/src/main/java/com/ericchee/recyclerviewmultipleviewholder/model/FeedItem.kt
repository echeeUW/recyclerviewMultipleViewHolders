package com.ericchee.recyclerviewmultipleviewholder.model

/**
 * Define the different kind of data objects that represent what could be in your RecyclerView (i.e. Text, Video, Image)
 * And wrap it around a parent type (i.e. FeedItem)
 */
sealed class FeedItem {
    class TextItem(val textMessage: String): FeedItem()
    class VideoItem(val videoTitle: String, val duration: String): FeedItem()
    class ImageItem(val imageDrawableID: Int): FeedItem()
}