package com.example.coupons.common.dataAccess

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.coupons.common.entities.CouponEntity

@Database(entities = [CouponEntity::class], version = 1)
abstract class CouponDataBase: RoomDatabase() {
    abstract fun couponDao() : CouponDao
}