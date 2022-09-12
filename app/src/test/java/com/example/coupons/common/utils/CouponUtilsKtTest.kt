package com.example.coupons.common.utils

import org.junit.Assert.*
import org.junit.Test

class CouponUtilsKtTest{
    @Test
    fun validateTextCodeSuccessTest(){
        val code = "welcome"
        assertTrue(validateTextCode(code))
    }

    @Test
    fun validateTextCodeEmptyFailTest(){
        val code = ""
        assertFalse(validateTextCode(code))
    }
}