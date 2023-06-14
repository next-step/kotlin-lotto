package stringadditioncalculator

fun String.isInt(): Boolean {
    return try {
        this.toInt()
        true
    } catch (exception: NumberFormatException) {
        false
    }
}

class StringAdditionCalculator {
    fun calculate(expression: String?): Int {
        val stringNumbers = StringAdditionCalculatorInputParser.parse(expression)
        validate(stringNumbers)

        return stringNumbers.asSequence()
            .map { it.toInt() }
            .fold(0, Int::plus)
    }

    private fun validate(stringNumbers: List<String>) {
        val isValidStringNumbers = stringNumbers.any { !it.isInt() || it.toInt() < 0 }
        require(!isValidStringNumbers) { "문자열 계산기에 숫자 이외의 값 또는 음수를 전달할 수 없습니다." }
    }
}
