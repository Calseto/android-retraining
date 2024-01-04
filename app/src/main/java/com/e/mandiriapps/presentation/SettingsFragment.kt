package com.e.mandiriapps.presentation

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.e.mandiriapps.R
import com.e.mandiriapps.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {
    var _binding : FragmentSettingsBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSettingsBinding.inflate(layoutInflater)
        setupViewSetting()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun setupViewSetting(){
        binding.apply {
            componentSetIns.apply {
                btnInstantSettings.apply {
                    tvItemSettings.text="Instant Access"
                }
            }
            componentSetAcc.apply {
                btnNameSettings.apply {
                    tvItemSettings.text = "Nama Panggilan"
                }
                btnEmailSettings.apply {
                    tvItemSettings.text = "Email"
                }
                btnLanguangeSettings.apply {
                    tvItemSettings.text="Bahas"
                }
                btnRenewSettings.apply {
                    tvItemSettings.text="Pengkinian Data"
                }
            }
            componentSetFeat.apply {
                btnProxySettings.apply {
                    tvItemSettings.text="Proxy untuk BI Fast"
                }
                btnBillSettings.apply {
                    tvItemSettings.text="Sumber Dana WR Bayar"
                }
                btnBalanceSourceSettings.apply {
                    tvItemSettings.text="Terima Tagihan"
                }
            }
            componentSetSec.apply {
                btnBiometricSettings.apply {
                    tvItemSettings.text="Biometric untuk Login"
                }
                btnPinSettings.apply {
                    tvItemSettings.text="Pin"
                }
                btnPassSettings.apply {
                    tvItemSettings.text="Password"
                }
                btnWithoutPinSettings.apply {
                    tvItemSettings.text="Transaksi Tanpa Pin"
                }
                btnPhoneNumberSettings.apply {
                    tvItemSettings.text="Ubah Nomor Handphone"
                }
            }
            componentSetCard.apply {
                btnCardDebitAndCreditSettings.apply {
                    tvItemSettings.text="Kartu Debit & Kartu Kredit"
                }
            }
            componentSetInfo.apply {
                btnFaqSettings.apply {
                    tvItemSettings.text="FAQ"
                }
                btnAboutSettings.apply {
                    tvItemSettings.text="Tentang Livin' by Mandiri"
                }
            }
            componentSetLog.apply {
                btnLogoutSettings.apply {
                    tvItemSettings.apply {
                        text="Log Out"
                        setTextColor(Color.RED)
                    }
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }

}