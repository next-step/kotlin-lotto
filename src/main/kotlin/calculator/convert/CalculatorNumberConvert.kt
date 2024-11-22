package calculator.convert

object CalculatorNumberConvert {
    fun convertInt(target: String): Int {

        val convertedNumber:Int
        try {
            convertedNumber = Integer.parseInt(target)
        } catch (ex: NumberFormatException) {
            throw IllegalStateException("$target 은 숫자 가 아닙니다.")
        }
        validateNegative(convertedNumber)
        return convertedNumber
    }

    private fun validateNegative(convertedNumber: Int) {
        if (convertedNumber < 0) throw RuntimeException("음수는 더 할 수 업습니다.")
    }
}