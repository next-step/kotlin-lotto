package stringsumcalculator

object StringSumCalculator {
    fun sum(text: String?): Number {
        if (text.isNullOrBlank()) {
            return StringNumber.ZERO
        }

        return Sum(StringSplitNumbers(text))
    }
}
