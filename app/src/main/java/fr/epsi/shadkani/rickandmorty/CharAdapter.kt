package fr.epsi.shadkani.rickandmorty

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import coil3.load


class CharAdapter(private val context: Context, charModelArrayList: ArrayList<CharModel>) :
    RecyclerView.Adapter<CharAdapter.ViewHolder>() {

    private val charModelArrayList: ArrayList<CharModel>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharAdapter.ViewHolder {
        // to inflate the layout for each item of recycler view.
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.character_item, parent, false)



        
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharAdapter.ViewHolder, position: Int) {
        // to set data to textview and imageview of each card layout
        val model: CharModel = charModelArrayList[position]
        holder.CharNameTV.text = model.getCharName()
        holder.CharIV.load(model.getCharImage())
        holder.mCardView?.setTag(position)

    }

    override fun getItemCount(): Int {

        return charModelArrayList.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val CharIV: ImageView
        val CharNameTV: TextView
        public var mCardView: CardView? = null
        init {
            CharNameTV = itemView.findViewById(R.id.nameViewChar)
            CharIV = itemView.findViewById(R.id.imageViewChar)
            mCardView = itemView.findViewById<View>(R.id.charCV) as CardView



        }
    }

    // Constructor
    init {
        this.charModelArrayList = charModelArrayList

    }
}
