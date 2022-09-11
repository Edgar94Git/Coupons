package com.example.coupons.mainModule.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coupons.R
import com.example.coupons.common.entities.CouponEntity
import com.example.coupons.common.utils.getMsgErrorByCode
import com.example.coupons.mainModule.model.MainRepository
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    private val repository = MainRepository()

    val coupon = MutableLiveData<CouponEntity>()

    private val hideKeyboard = MutableLiveData<Boolean>()
    fun isHideKeynoard() = hideKeyboard

    private val snackbarMsg = MutableLiveData<Int>()
    fun getSnackbarMsg() = snackbarMsg

    fun consultCouponByCode(){
        coupon.value?.code?.let { code ->
            viewModelScope.launch {
                hideKeyboard.value = true
                coupon.value = repository.consultCouponByCode(code)
            }
        }
    }

    fun saveCoupon(){
        coupon.value?.let { couponEntity ->
            viewModelScope.launch {
                hideKeyboard.value = true
                try {
                    repository.saveCoupon(couponEntity)
                    consultCouponByCode()
                    snackbarMsg.value = R.string.main_save_success
                }
                catch (e: Exception){
                    snackbarMsg.value = getMsgErrorByCode(e.message)
                }
            }
        }
    }
}