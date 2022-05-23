package calculator

class StringCalculator {

    fun calculate(inputs: String?): Int {
        val strings = Parser.parse(inputs)
        val numbers = strings.map(String::toInt)
        checkIsNotNegative(numbers)
        return numbers.sum()
    }

    private fun checkIsNotNegative(numbers: List<Int>) {
        require(numbers.none { it < 0 }) { "음수값은 허용하지 않습니다." }
    }
}
