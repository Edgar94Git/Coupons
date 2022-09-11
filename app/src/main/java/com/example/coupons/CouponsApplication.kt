package com.example.coupons

import android.app.Application
import androidx.room.Room
import com.example.coupons.common.dataAccess.CouponDataBase

class CouponsApplication: Application() {
    companion object{
        lateinit var dataBase: CouponDataBase
    }

    override fun onCreate() {
        super.onCreate()
        dataBase = Room.databaseBuilder(this,
            CouponDataBase::class.java,
            "CouponDataBase")
            .build()
    }
}