package calculator

class Numbers(strings: List<String>) {
    private val numbers = strings.map(String::toInt)

    init {
        checkIsNotNegative(numbers)
    }

    val sum = numbers.sum()

    private fun checkIsNotNegative(numbers: List<Int>) {
        require(numbers.none { it < 0 }) { "음수값은 허용하지 않습니다." }
    }
}
