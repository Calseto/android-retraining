package com.e.mandiriapps.presentation.itemfragment

import android.os.Bundle
import com.bumptech.glide.Glide
import com.e.mandiriapps.R
import com.e.mandiriapps.databinding.FragmentPromoItemBinding
import com.e.mandiriapps.model.PromoModel
import com.e.mandiriapps.presentation.basefragment.BaseFragment

class PromoItemFragment:BaseFragment<FragmentPromoItemBinding>() {

    private lateinit var data:PromoModel
    override fun inflateBinding(): FragmentPromoItemBinding {
        return FragmentPromoItemBinding.inflate(layoutInflater)
    }

    override fun setupView() {
        data= arguments?.getParcelable("data")!!

        binding.apply {
            tvTitlePromoItem.text=data.title
            tvDescPromoItem.text=data.desc
            tvDueDatePromoItem.text=data.dueDate
            Glide.with(requireActivity())
                .load(data.image)
                .placeholder(R.drawable.livin_logo3)
                .error(R.drawable.livin_logo)
                .into(ivPromo)
        }
    }
    companion object {
        fun newInstance(data: PromoModel): PromoItemFragment {
            val fragment = PromoItemFragment()
            val args = Bundle()
            // Pass the data to the fragment
            args.putParcelable("data", data) // Adjust "YourDataType" accordingly
            fragment.arguments = args
            return fragment
        }
    }
}