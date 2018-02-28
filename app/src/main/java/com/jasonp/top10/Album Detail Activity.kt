package com.jasonp.top10


import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
//import com.jasonp.top10.CustomViewHolder.Companion.Album_Artist_Key
//import com.jasonp.top10.CustomViewHolder.Companion.Album_Date_Key
//import com.jasonp.top10.CustomViewHolder.Companion.Album_Legal_Key
import com.jasonp.top10.CustomViewHolder.Companion.Album_Title_Key
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.album_detail.view.*


/**
 * Created by Jason on 2/27/2018.
 */


class AlbumDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


     setContentView(R.layout.activity_main)

        recyclerView_main.layoutManager=LinearLayoutManager(this)



        // Setting Navigation Bar Title
        val navBarTitle = intent.getStringExtra(Album_Title_Key)
        supportActionBar?.title = navBarTitle

      //  fetch()



    }

//    fun fetch(){
//
//       val artistName = intent.getStringExtra(Album_Artist_Key)
//       val releaseDate = intent.getStringExtra(Album_Date_Key)
//       val copyRight = intent.getStringExtra(Album_Legal_Key)






//runOnUiThread{
//    recyclerView_main.adapter = AlbumDetailAdapter(artistName, releaseDate, copyRight)
//}



  // }


}

 private class AlbumDetailAdapter(): RecyclerView.Adapter<AlbumViewHolder>(){

    override fun getItemCount(): Int {
        val numberOfAlbums = 1
        return numberOfAlbums
    }



    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): AlbumViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val customView = layoutInflater.inflate(R.layout.album_detail, parent, false)
        return AlbumViewHolder(customView)
    }



    override fun onBindViewHolder(holder: AlbumViewHolder?, position: Int) {

//        holder?.customView?.textView_artist_name?.text = tempName
//        holder?.customView?.textView_album_release?.text = tempDate
//        holder?.customView?.textView_copy_right?.text = tempCopyRight
    }



}


 private class AlbumViewHolder(val customView: View) : RecyclerView.ViewHolder(customView){


}