package com.e.mandiriapps.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.e.mandiriapps.R
import com.e.mandiriapps.databinding.ItemTransactionBinding
import com.e.mandiriapps.model.ServiceModel
import com.e.mandiriapps.model.Status
import com.e.mandiriapps.model.TransactionStatusModel

class TransactionStatusAdapter(
    private var data:MutableList<TransactionStatusModel>,
    private val onClickMenu: (data:TransactionStatusModel)->Unit={}
): RecyclerView.Adapter<TransactionStatusAdapter.TransactionStatusViewHolder>() {
    inner class TransactionStatusViewHolder(private val itemBinding: ItemTransactionBinding):
        RecyclerView.ViewHolder(itemBinding.root){
        fun bind(model: TransactionStatusModel){
            itemBinding.apply {
                tvTitleTrans.text=model.titleTransaction
                tvSubTitleTrans.text=model.subtitleTransaction
                tvDateNotif.text=model.date
                tvNominalTrans.text=model.nominal
                when(model.status){
                    Status.Success.value-> {
                        tvStatusTrans.text = "Success"
                        tvStatusTrans.setTextColor(Color.GREEN)
                    }
                    Status.Failed.value->{
                        tvStatusTrans.text = "Failed"
                        tvStatusTrans.setTextColor(Color.RED)
                    }
                    Status.Pending.value->{
                        tvStatusTrans.text = "Pending"
                        tvStatusTrans.setTextColor(Color.BLUE)
                    }
                }


                vItemTransaction.setOnClickListener {
                    onClickMenu.invoke(model)
                }
            }

        }
    }

    fun filterTransactionData(updateData:MutableList<TransactionStatusModel>){
        this.data = updateData
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionStatusViewHolder {
        return TransactionStatusViewHolder(
            ItemTransactionBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TransactionStatusAdapter.TransactionStatusViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

}