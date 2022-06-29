package com.example.praktik

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ListAdapter (private val ctx: Context) : RecyclerView.Adapter<ListAdapter.ViewHolder>(){
    private val dataModel: ArrayList<DataModel> = ArrayList()

    fun setData(data: List<DataModel>){
        dataModel.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
            return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataModel[position], ctx)
    }

    override fun getItemCount(): Int {
        return dataModel.size
    }

    class ViewHolder(v : View) : RecyclerView.ViewHolder(v) {

        private lateinit var  tvNim : TextView
        private lateinit var  tvNama : TextView

        fun bind(data: DataModel, ctx: Context) {
            tvNim = itemView.findViewById(R.id.tv_nim)
            tvNama = itemView.findViewById(R.id.tv_nama)

            tvNim.text = data.nim
            tvNama.text = data.nama

            itemView.setOnClickListener {
                val intent = Intent(ctx, DetailActivity::class.java)
                ctx.startActivity(intent)
            }

        }
    }


}