package com.example.lab3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdaptor( private val items: List<Any>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private  val FIRST_ITEM = 0
    private  val SECOND_ITEM= 1
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if(viewType==FIRST_ITEM){
            val view = LayoutInflater.from(parent.context).inflate(R.layout.results_list_item1, parent, false)
            Item1ViewHolder(view)
        } else{
            val view = LayoutInflater.from(parent.context).inflate(R.layout.results_list_item2, parent, false)
            Item2ViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]
            if(holder.itemViewType==FIRST_ITEM){
                val firstItem = item as ResultItem1
                (holder as Item1ViewHolder).bindData(firstItem)
            }else{
                val secondItem = item as ResultItem2
                (holder as Item2ViewHolder).bindData(secondItem)
            }
    }

    override fun getItemCount(): Int {
        return items.size
    }
    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is ResultItem1-> FIRST_ITEM
            is ResultItem2 -> SECOND_ITEM
            else -> throw IllegalArgumentException("Invalid item type")
        }
    }

    inner class Item1ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.results_image)
        private val titleTextView: TextView = itemView.findViewById(R.id.results_title)
        private val descriptionTextView: TextView = itemView.findViewById(R.id.results_description)
        private val priceTextView: TextView = itemView.findViewById(R.id.results_price)

        fun bindData(item: ResultItem1) {
            imageView.setImageResource(item.src)
            titleTextView.text = item.title
            descriptionTextView.text = item.description
            priceTextView.text = item.price
        }
    }
    inner class Item2ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.results_image2)
        private val titleTextView: TextView = itemView.findViewById(R.id.results_title2)
        private val descriptionTextView: TextView = itemView.findViewById(R.id.results_description2)
        private val priceTextView: TextView = itemView.findViewById(R.id.results_price2)
        private val quantityTextView: TextView = itemView.findViewById(R.id.results_quantity)

        fun bindData(item: ResultItem2) {
            imageView.setImageResource(item.src)
            titleTextView.text = item.title
            descriptionTextView.text = item.description
            priceTextView.text = item.price
            quantityTextView.text= item.quantity.toString()
        }
    }

}