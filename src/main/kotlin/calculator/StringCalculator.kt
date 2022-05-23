package calculator

class StringCalculator {
    private val parser = Parser()

    fun calculate(inputs: String?): Int {
        val strings = parser.parse(inputs)
        val numbers = strings.map(String::toInt)
        validation(numbers)
        return numbers.sum()
    }

    private fun validation(numbers: List<Int>) {
        require(numbers.none { it < 0 }) { "음수값은 허용하지 않습니다." }
    }
}
