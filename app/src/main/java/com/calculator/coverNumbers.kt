package com.calculator

fun convertNumber(number: String) {
//    // Decimal to binary
//    val binary = Integer.toBinaryString(number.toInt())
//
//    // Decimal to octal
//    val octal = Integer.toOctalString(number.toInt())
//
//    // Decimal to hexadecimal
//    val hex = Integer.toHexString(number.toInt())
//
//    // Binary to decimal
//    val decimalFromBinary = Integer.parseInt(binary, 2)
//
//    // Octal to decimal
//    val decimalFromOctal = Integer.parseInt(octal, 8)
//
//    // Hexadecimal to decimal
//    val decimalFromHex = Integer.parseInt(hex, 16)
fun decimalToBinary(decimal: Int): String {
    return Integer.toBinaryString(decimal)
}
    fun decimalToOctal(decimal: Int): String {
        return Integer.toOctalString(decimal)
    }
    fun decimalToHexadecimal(decimal: Int): String {
        return Integer.toHexString(decimal)
    }
}
