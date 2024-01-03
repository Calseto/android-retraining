package com.e.mandiriapps.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.e.mandiriapps.databinding.ItemNotificationBinding
import com.e.mandiriapps.databinding.ItemSavingDepositBinding
import com.e.mandiriapps.model.NotificationModel
import com.e.mandiriapps.model.SavingDepositModel
import com.e.mandiriapps.model.ServiceModel

class NotifAdapter(
    private val data:MutableList<NotificationModel>
):RecyclerView.Adapter<NotifAdapter.NotifViewHolder>() {
    inner class NotifViewHolder(private val itemBinding: ItemNotificationBinding):
        RecyclerView.ViewHolder(itemBinding.root){
        fun bind(model: NotificationModel){
            itemBinding.tvTitleNotif.text=model.title
            itemBinding.tvDescNotif.text=model.description
            itemBinding.tvDateNotif.text=model.date

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotifViewHolder {
        return NotifViewHolder(
            ItemNotificationBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: NotifViewHolder, position: Int) {
        holder.bind(data[position])
    }
}