package calculator

class StringCalculator {

    fun calculate(inputs: List<String>): Int {
        val numbers = inputs.map(String::toInt)
        validation(numbers)
        return numbers.sum()
    }

    private fun validation(numbers: List<Int>) {
        require(numbers.none { it < 0 }) { "음수값은 허용하지 않습니다." }
    }
}
