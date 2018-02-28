package com.jasonp.top10

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.album_row.view.*
import org.w3c.dom.Text

/**
 * Created by Jason on 2/7/2018.
 */
class MainAdapter(val collection: Format): RecyclerView.Adapter<CustomViewHolder>(){



    override fun getItemCount(): Int {
        val number = 10
        return number
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CustomViewHolder {
        // making view
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.album_row, parent,false)
        return CustomViewHolder(cellForRow)

    }

    override fun onBindViewHolder(holder: CustomViewHolder?, position: Int) {

       val labelInfo = collection.feed?.results!![position]

       val albumTitle = labelInfo.name
     //   val artist = labelInfo.artistName
        val cover = labelInfo.artworkUrl100

        holder?.view?.textView_album_title?.text = albumTitle
     //   holder?.view?.textView_artist_name?.text = artist

        val albumCover = holder?.view?.imageView_album_cover
        Picasso.with(holder?.view?.context).load(cover).into(albumCover)


        holder?.title = albumTitle
//        holder?.artist = labelInfo.artistName
//        holder?.date = labelInfo.releaseDate
//        holder?.legal = labelInfo.copyright




    }

}


class CustomViewHolder(val view: View, var title: String? = null): RecyclerView.ViewHolder(view) {


    companion object {
        val Album_Title_Key = "Album_Title"
//        val Album_Artist_Key = "Album_Artist"
//        val Album_Date_Key = "Album_Date"

//        val Album_Legal_Key = "Album_legal"

    }

              init {
                  view.setOnClickListener {
                      val intent = Intent(view.context, AlbumDetailActivity::class.java)

                      intent.putExtra(Album_Title_Key, title)
//                      intent.putExtra(Album_Artist_Key, artist)
//                      intent.putExtra(Album_Date_Key, date)
//                      intent.putExtra(Album_Legal_Key, legal)


                      view.context.startActivity(intent)
                  }
              }

}