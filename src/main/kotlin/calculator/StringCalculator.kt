package calculator

class StringCalculator {

    fun calculate(numbers: List<Int>): Int {
        validation(numbers)
        return numbers.sum()
    }

    private fun validation(numbers: List<Int>) {
        require(numbers.none { it < 0 }) { "음수값은 허용하지 않습니다." }
    }
}
