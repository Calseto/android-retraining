package com.e.mandiriapps.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.e.mandiriapps.databinding.ItemSavingDepositBinding
import com.e.mandiriapps.model.EwalletModel
import com.e.mandiriapps.model.SavingDepositModel

class SavingDepositAdapter(
    private val savingDepositData:List<SavingDepositModel>,
    private var maximumItems :Int = 2
):RecyclerView.Adapter<SavingDepositAdapter.SavingDepositViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SavingDepositViewHolder {
        return SavingDepositViewHolder(
            ItemSavingDepositBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount()=if (savingDepositData.size>=5) maximumItems else savingDepositData.size

    override fun onBindViewHolder(holder: SavingDepositViewHolder, position: Int) {
        holder.bind(savingDepositData[position])
    }
    inner class SavingDepositViewHolder(private val itemBinding:ItemSavingDepositBinding):
        RecyclerView.ViewHolder(itemBinding.root){
            fun bind(model:SavingDepositModel){
                itemBinding.nameSavingTxt.text=model.savingName
                itemBinding.tvAccountName.text=model.accountNumber
                itemBinding.ivCardPic.setImageResource(model.imageCard)
        }
    }
    fun updateQuantitySize(sizeUpdate:Int){
        maximumItems=sizeUpdate
        notifyDataSetChanged()
    }
}