class ConvertNumber {
    companion object {
        fun decimalToBinary(decimal: Int): String {
            if (decimal == 0) {
                return "0"
            } else if (decimal == 1) {
                return "1"
            } else {
                return decimalToBinary(decimal / 2) + (decimal % 2).toString()
            }
        }

        fun decimalToOctal(decimal: Int): String {
            if (decimal == 0) {
                return "0"
            } else {
                return decimalToOctal(decimal / 8) + (decimal % 8).toString()
            }
        }

        fun decimalToHexadecimal(decimal: Int): String {
            if (decimal == 0) {
                return "0"
            } else {
                val remainder = decimal % 16
                return decimalToHexadecimal(decimal / 16) + if (remainder < 10) remainder.toString() else ('A' + remainder - 10).toString()
            }
        }

        fun binaryToDecimal(binary: String): Int {
            return if (binary.length == 1) {
                binary.toInt()
            } else {
                val firstDigit = binary.substring(0, 1).toInt()
                val remainingDigits = binary.substring(1)
                firstDigit * Math.pow(2.0, remainingDigits.length.toDouble()).toInt() + binaryToDecimal(remainingDigits)
            }
        }

        fun binaryToOctal(binary: String): String {
            val decimal = binaryToDecimal(binary)
            return decimalToOctal(decimal)
        }

        fun binaryToHexadecimal(binary: String): String {
            val decimal = binaryToDecimal(binary)
            return decimalToHexadecimal(decimal)
        }

        fun octalToBinary(octal: String): String {
            val decimal = octalToDecimal(octal)
            return decimalToBinary(decimal)
        }

        fun octalToDecimal(octal: String): Int {
            return if (octal.length == 1) {
                octal.toInt()
            } else {
                val firstDigit = octal.substring(0, 1).toInt()
                val remainingDigits = octal.substring(1)
                firstDigit * Math.pow(8.0, remainingDigits.length.toDouble()).toInt() + octalToDecimal(remainingDigits)
            }
        }

        fun octalToHexadecimal(octal: String): String {
            val decimal = octalToDecimal(octal)
            return decimalToHexadecimal(decimal)
        }

        fun hexadecimalToBinary(hexadecimal: String): String {
            val decimal = hexadecimalToDecimal(hexadecimal)
            return decimalToBinary(decimal)
        }

        fun hexadecimalToOctal(hexadecimal: String): String {
            val decimal = hexadecimalToDecimal(hexadecimal)
            return decimalToOctal(decimal)
        }

        fun hexadecimalToDecimal(hexadecimal: String): Int {
            return if (hexadecimal.length == 1) {
                if (hexadecimal[0] in '0'..'9') {
                    hexadecimal[0].toString().toInt()
                } else {
                    hexadecimal[0].toUpperCase().toInt() - 55
                }
            } else {
                val firstDigit = if (hexadecimal[0] in '0'..'9') {
                    hexadecimal[0].toString().toInt()
                } else {
                    hexadecimal[0].toUpperCase().toInt() - 55
                }
                val remainingDigits = hexadecimal.substring(1)
                firstDigit * Math.pow(16.0, remainingDigits.length.toDouble()).toInt() + hexadecimalToDecimal(remainingDigits)
            }
        }
    }
}
