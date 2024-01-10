package com.e.mandiriapps.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.e.mandiriapps.databinding.ItemEwalletBinding
import com.e.mandiriapps.model.EwalletModel

class EwalletAdapter(private val listEwallet:List<EwalletModel>):RecyclerView.Adapter<EwalletAdapter.ViewHolder>(){

    inner class ViewHolder(private val itemBinding: ItemEwalletBinding): RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(ewallet:EwalletModel){
            itemBinding.ivEwallet.setImageResource(ewallet.image)
            if (ewallet.isConnected){
                itemBinding.tvBalance.text = ewallet.balance.toString()
                itemBinding.tvBalance.visibility= View.VISIBLE
                itemBinding.btnHubungkan.visibility=View.GONE
            }else{
                itemBinding.tvBalance.visibility= View.GONE
                itemBinding.btnHubungkan.visibility=View.VISIBLE
            }
            itemBinding.btnHubungkan.setOnClickListener{
                ewallet.isConnected=true
                notifyDataSetChanged()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemEwalletBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listEwallet.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listEwallet[position])
    }
}