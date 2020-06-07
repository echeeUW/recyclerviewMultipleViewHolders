package com.ericchee.recyclerviewmultipleviewholder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ericchee.recyclerviewmultipleviewholder.adapter.NewsFeedAdapter
import com.ericchee.recyclerviewmultipleviewholder.model.FeedItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val newsFeedItems = listOf<FeedItem>(
            FeedItem.TextItem("some text layout item"),
            FeedItem.TextItem("Another text layout item"),
            FeedItem.VideoItem("Some video title", "12:30"),
            FeedItem.ImageItem(R.drawable.ic_launcher_foreground),
            FeedItem.ImageItem(R.drawable.ic_launcher_foreground),
            FeedItem.TextItem("Another text layout item"),
            FeedItem.TextItem("Another text layout item"),
            FeedItem.VideoItem("Some video title", "12:30"),
            FeedItem.ImageItem(R.drawable.ic_launcher_foreground),
            FeedItem.VideoItem("Some video title", "12:30")
        )

        rvFeedItems.adapter = NewsFeedAdapter(newsFeedItems)
    }
}