package com.e.mandiriapps.presentation.basefragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import androidx.viewbinding.ViewBindings
import com.e.mandiriapps.databinding.FragmentSettingsBinding

abstract class BaseFragement<T:ViewBinding> : Fragment() {
    var _binding :T? = null
    private val binding get() = _binding!!

    abstract fun inflateBinding() : T
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflateBinding()
        setupView(binding)
        return binding.root
    }
    abstract fun setupView(binding: T);
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }

}