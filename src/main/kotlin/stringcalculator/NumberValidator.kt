package stringcalculator

object NumberValidator {

    private const val ZERO = 0
    fun negativeValidate(number: Int): Int {
        if (number < ZERO)
            throw RuntimeException("음수는 입력할 수 없습니다.")
        return number
    }
}
