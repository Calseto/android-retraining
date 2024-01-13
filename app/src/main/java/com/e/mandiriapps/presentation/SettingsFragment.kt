package com.e.mandiriapps.presentation

import android.graphics.Color
import com.e.mandiriapps.databinding.FragmentSettingsBinding
import com.e.mandiriapps.presentation.basefragment.BaseFragment

class SettingsFragment : BaseFragment<FragmentSettingsBinding>() {
    override fun inflateBinding(): FragmentSettingsBinding {
        return  FragmentSettingsBinding.inflate(layoutInflater)
    }

    override fun setupView(){
        binding.apply {
            val sumthing = componentSetIns
            componentSetIns.apply {
                btnInstantSettings.apply {
                    tvItemSettings.text="Instant Access"
                }
            }
            componentSetAcc.apply {
//                val listOption = mutableListOf(
//                    btnEmailSettings,
//                    btnNameSettings,
//                    btnLanguangeSettings,
//                    btnRenewSettings
//                )
//                for(option in listOption){
//                    option.tvItemSettings.text="hahaha isok"
//                }
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

}