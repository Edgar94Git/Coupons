package com.example.coupons

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CouponDao {

    @Query("SELECT * FROM CouponEntity WHERE code = :code")
    suspend fun consultCouponBy(code: String): CouponEntity?

    @Insert
    suspend fun addCoupon(couponEntity: CouponEntity): Long
}