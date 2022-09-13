package com.example.coupons.common.utils

import com.example.coupons.R
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

    @Test
    fun validateTextCodeMinLengthTest(){
        val code = "Hola"
        assertFalse(validateTextCode(code))
    }

    @Test
    fun validateTextCodeMaxLengthTest(){
        val code = "Bienvenidos al curso"
        assertFalse(validateTextCode(code))
    }

    @Test
    fun getMsgErrorByCodeNullTest(){
        val errorCode = null
        val expectedValue = R.string.error_unknow
        val result = getMsgErrorByCode(errorCode)
        assertEquals(expectedValue, result)
    }
}