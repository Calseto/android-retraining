package com.e.mandiriapps.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.e.mandiriapps.databinding.ItemSavingDepositBinding
import com.e.mandiriapps.databinding.ItemServiceBinding
import com.e.mandiriapps.model.SavingDepositModel
import com.e.mandiriapps.model.ServiceModel

class ServiceMenuAdapter (
    private val serviceMenuData:List<ServiceModel>
):RecyclerView.Adapter<ServiceMenuAdapter.ServiceMenuViewHolder>() {

    private var _onClickMenu: (ServiceModel)->Unit={}
    fun setOnClickMenu(listener: (ServiceModel)-> Unit){
        _onClickMenu = listener
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ServiceMenuAdapter.ServiceMenuViewHolder {
        return ServiceMenuViewHolder(
            ItemServiceBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ServiceMenuAdapter.ServiceMenuViewHolder, position: Int) {
        holder.bind(serviceMenuData[position])
    }

    override fun getItemCount(): Int =serviceMenuData.size
    inner class ServiceMenuViewHolder(private val itemBinding:ItemServiceBinding):
        RecyclerView.ViewHolder(itemBinding.root){
        fun bind(model:ServiceModel){
            itemBinding.tvServiceMenu.text=model.menuTitle
            itemBinding.btnServiceMenu.setOnClickListener{_onClickMenu.invoke(model)}

        }

    }

}