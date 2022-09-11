package com.example.coupons.mainModule.model

import android.database.sqlite.SQLiteConstraintException
import com.example.coupons.CouponsApplication
import com.example.coupons.common.dataAccess.CouponDao
import com.example.coupons.common.entities.CouponEntity
import com.example.coupons.common.utils.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RoomDatabase {
    private val dao: CouponDao by lazy { CouponsApplication.dataBase.couponDao() }

    suspend fun consultCouponByCode(code: String) = dao.consultCouponBy(code)

    suspend fun saveCoupon(couponEntity: CouponEntity) = withContext(Dispatchers.IO) {
        try {
            dao.addCoupon(couponEntity)
        }catch (exp: Exception){
            (exp as? SQLiteConstraintException)?.let { throw Exception(Constants.ERROR_EXIST) }
            throw Exception(exp.message ?: Constants.ERROR_UNKNOW)
        }
    }
}