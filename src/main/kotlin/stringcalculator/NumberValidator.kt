package stringcalculator

object NumberValidator {
    fun negativeValidate(number: Int): Int {
        if (number < Constants.ZERO)
            throw RuntimeException("음수는 입력할 수 없습니다.")
        return number
    }
}
