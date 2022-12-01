package stringsumcalculator

object StringSumCalculator {
    fun sum(text: String?): INumber {
        if (text.isNullOrBlank()) {
            return StringNumber.ZERO
        }

        return Sum(StringNumbers(text))
    }
}
