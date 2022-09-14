package com.example.coupons.common.utils

import com.example.coupons.R
import com.example.coupons.common.entities.CouponEntity
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
        assertEquals("Error al evaluar un null", expectedValue, result)
    }

    @Test
    fun getMsgErrorByCodeExistTest(){
        val errorCode = Constants.ERROR_EXIST
        val expectedValue= R.string.error_unique_code
        val result = getMsgErrorByCode(errorCode)
        assertEquals("Error al evaluar un cupon existente",expectedValue, result)
    }

    @Test
    fun getMsgErrorByCodeLengthTest(){
        val errorCode = Constants.ERROR_LENGTH
        val expectedValue = R.string.error_invalid_length
        val result = getMsgErrorByCode(errorCode)
        assertEquals("Error al evaluar la longitud valida.",expectedValue, result)
    }

    @Test
    fun checkNotNullCouponTest(){
        val coupon = CouponEntity(code = "Android", description = "Cusrsos a $9.99 usd")
        assertNotNull("El cupon no deberia ser nulo",coupon)
    }

    @Test
    fun checkGroupsSuccessTest(){
        val aNames = arrayOf("edgar","karem", "gaby")
        val bNames = arrayOf("edgar","karem", "gaby")
        assertArrayEquals("Los arreglos deberian coincidir, revise sus elementos",bNames, aNames)
    }

    @Test
    fun checkNullCouponTest(){
        val coupon = null
        assertNull("El cupon deberiar ser nulo", coupon)
    }

    @Test
    fun checkGroupdFailTest(){
        val aNames = arrayOf("edgar","karem", "gaby")
        val bNames = arrayOf("edgar","karem", "gaby")
        assertNotEquals("Estos arreglos coinciden",bNames, aNames)
    }
}